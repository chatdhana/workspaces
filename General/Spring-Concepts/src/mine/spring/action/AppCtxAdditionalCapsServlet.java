package mine.spring.action;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;

import mine.spring.bean.SpringAppContextAware;

/**
 * Servlet implementation class AppCtxAdditionalCapsServlet
 */
public class AppCtxAdditionalCapsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppCtxAdditionalCapsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessageSource msgSrc = SpringAppContextAware.getAppContext();
		System.out.println(msgSrc.getMessage("res1.prop1", null, "No match found", null));
		System.out.println(msgSrc.getMessage("res2.prop2", new String[] { "arg1", "arg2" }, "No match found", Locale.US));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
