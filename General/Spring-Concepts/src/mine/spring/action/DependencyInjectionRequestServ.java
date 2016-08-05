package mine.spring.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mine.spring.bean.SpringAppContextAware;
import mine.spring.bean.di.PrototypeBeanInjectionAppCtxAware;
import mine.spring.bean.di.PrototypeBeanInjectionLookupMethod;
import mine.spring.bean.di.PrototypeBeanInjectionReplacedMethod;

/**
 * Servlet implementation class DependencyInjectionRequestServ
 */
public class DependencyInjectionRequestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyInjectionRequestServ() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		System.out.println("PrototypeBeanInjection:Implementing the ApplicationContextAware (Tightly couples Spring with application bean)");
		PrototypeBeanInjectionAppCtxAware singleton = (PrototypeBeanInjectionAppCtxAware) SpringAppContextAware.getAppContext().getBean("singletonBeanAppCtxAware");
		singleton.usageMethod();
		//
		/*System.out.println("PrototypeBeanInjection: Lookup method");
		PrototypeBeanInjectionLookupMethod lookupMethod = (PrototypeBeanInjectionLookupMethod) SpringAppContextAware.getAppContext().getBean("prototypeBeanInjectionMethodInjection");
		lookupMethod.usageMethod();*/
		//
		//
		System.out.println("PrototypeBeanInjection: Lookup method");
		PrototypeBeanInjectionReplacedMethod replacedMethod = (PrototypeBeanInjectionReplacedMethod) SpringAppContextAware.getAppContext().getBean("prototypeBeanInjectionReplacedMethod");
		replacedMethod.usageMethod();
		//
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
