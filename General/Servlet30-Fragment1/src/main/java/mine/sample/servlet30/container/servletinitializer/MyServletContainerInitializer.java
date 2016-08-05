package mine.sample.servlet30.container.servletinitializer;

import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;

@HandlesTypes({ HttpServlet.class, Filter.class, ServletContextListener.class })
public class MyServletContainerInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("Received a call from container on startup.");
		System.out.println(c);
	}

}
