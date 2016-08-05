package mine.sample.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContextClass = new AnnotationConfigWebApplicationContext();
		rootContextClass.register(MvcConfiguration.class);

		servletContext.addListener(new ContextLoaderListener(rootContextClass));

		AnnotationConfigWebApplicationContext dispatcherContextClass = new AnnotationConfigWebApplicationContext();
		dispatcherContextClass.register(MvcConfiguration.class);

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServet", new DispatcherServlet(
				dispatcherContextClass));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
