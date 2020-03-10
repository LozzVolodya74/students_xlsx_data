package students_xlsx_data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import students_xlsx_data.entity.Student;
import students_xlsx_data.form.DeleteStudentForm;
import students_xlsx_data.form.EditForm;
import students_xlsx_data.form.InputStudentForm;
import students_xlsx_data.service.Service;

@Controller
public class MainController {
	
	@Autowired
	private Service service;

	@RequestMapping(value = "/welcome")
	public String velcome(Model model) {
		model.addAttribute("students", service.getStudents());
		return "main-page";
	}

	@RequestMapping(value = "/prev")
	public String previorus() {
		service.previorus();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/next")
	public String next() {
		service.next();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	public String save(@ModelAttribute("InputStudentForm") InputStudentForm studentForm, Student student) {
		service.saveStudent(studentForm, student);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/upload")
	public String upload(Model model) {
		service.uploadService();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(@ModelAttribute("EditForm") EditForm form) {
		service.updateStudents(form);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/remove", method = { RequestMethod.POST })
	public String remove(@ModelAttribute("DeleteStudentForm") DeleteStudentForm form) {
		service.deleteStudents(form);
		return "redirect:/welcome";
	}

}
