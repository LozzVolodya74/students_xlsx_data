package students_xlsx_data.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import students_xlsx_data.entity.Student;

public interface StudentsRepository extends PagingAndSortingRepository<Student, Integer>{
	
	boolean exists(Integer id);
	
	List<Student> findAll(Sort sort);
	
	Student findOne(Integer id);
	
	void delete(Integer id);
	
	<S extends Student> S save (Student s);
		
}
