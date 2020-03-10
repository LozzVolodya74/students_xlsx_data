package students_xlsx_data.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		WebApplicationContext ctx = createWebApplicationContext(container);
		registerSpringMVCDispatcherServlet(container, ctx);
	}

	private void registerSpringMVCDispatcherServlet(ServletContext container, WebApplicationContext ctx) {
		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

	private WebApplicationContext createWebApplicationContext(ServletContext container) {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.scan("students_xlsx_data.config");
		ctx.setServletContext(container);
		ctx.refresh();
		return ctx;
	}

}
