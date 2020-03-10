package students_xlsx_data.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import students_xlsx_data.entity.Student;
import students_xlsx_data.exceptions.CustomGenericException;
import students_xlsx_data.form.DeleteStudentForm;
import students_xlsx_data.form.EditForm;
import students_xlsx_data.form.InputStudentForm;
import students_xlsx_data.repository.StudentsRepository;

@org.springframework.stereotype.Service
public class Service {
	private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);
	private final int pageSize = 12;
	private int currrentPage = 0;
	private int totalPages = 0;

	@Autowired
	private StudentsRepository repository;
	
	public void deleteStudents (DeleteStudentForm form) {
		int id = form.getId();
		if (!repository.exists(id)) {
			LOGGER.error("input non-correct id to remove " + id);
			throw new CustomGenericException("student which id " + id + " is not existed, please, input correct data");
			
		}
		repository.delete(id);
	}
	
	public void updateStudents (EditForm form) {
		int id = form.getId();
		if (!repository.exists(id)) {
			LOGGER.error("input non-correct id " + id);
			throw new CustomGenericException("student which id " + id + " is not existed, please, input correct data");
		}
		repository.save(updateDataStudent(form, repository.findOne(id)));
	}

	public void uploadService() {
		List<Student> students = repository.findAll(new Sort("id"));
		try {
			XSSFconvert.writeData(students);
		} catch (IOException e) {
			throw new CustomGenericException("CAN NOT CREATE FILE, PLEASE, TRY AGAINST LATER");
		}
	}

	public void saveStudent(InputStudentForm studentForm, Student student) {
		student.setAge(studentForm.getAge());
		student.setBirthday(studentForm.getBirthday());
		student.setFaculty(studentForm.getFaculty());
		student.setFirstName(studentForm.getFirstName());
		student.setLastName(studentForm.getLastName());
		repository.save(student);
	}

	public List<Student> getStudents() {
		Pageable pageable = new PageRequest(currrentPage, pageSize, new Sort("id")); // first_page=0
		Page<Student> page = repository.findAll(pageable);
		totalPages = page.getTotalPages();
		List<Student> list = page.getContent();
		return list;
	}

	public void previorus() {
		if (currrentPage <= 0) {
			currrentPage = 0;
		} else {
			currrentPage--;
		}
	}

	public void next() {
		if (currrentPage < totalPages - 1) {
			currrentPage++;
		}
	}

	private Student updateDataStudent(EditForm form, Student updateStudent) {
		if (!form.getAge().equals(""))
			updateStudent.setAge(form.getAge());
		if (!form.getBirthday().equals(""))
			updateStudent.setBirthday(form.getBirthday());
		if (!form.getFaculty().equals(""))
			updateStudent.setFaculty(form.getFaculty());
		if (!form.getFirstName().equals(""))
			updateStudent.setFirstName(form.getFirstName());
		if (!form.getLastName().equals(""))
			updateStudent.setLastName(form.getLastName());
		return updateStudent;
	}

}
