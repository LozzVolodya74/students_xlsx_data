package students_xlsx_data.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import students_xlsx_data.exceptions.CustomGenericException;

@ControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(CustomGenericException.class)
	public String handleCustomException(CustomGenericException ex, Model model) {
		model.addAttribute("message", ex.getMsg());
        return "data-error";
    }
}
