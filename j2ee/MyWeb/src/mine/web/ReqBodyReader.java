package mine.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReqBodyReader
 */
public class ReqBodyReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqBodyReader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameterNames().hasMoreElements());
		System.out.println(request.getAttributeNames().hasMoreElements());
		request.getAttribute("hiddenIp1");
		request.getParameter("hiddenIp1");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameterNames().hasMoreElements());
		System.out.println(request.getAttributeNames().hasMoreElements());
		request.getAttribute("hiddenIp1");
		request.getParameter("hiddenIp1");
		BufferedReader br = request.getReader();
		StringBuilder bodyData = new StringBuilder();
		String line = null;
		while((line = br.readLine()) != null){
			bodyData.append(line).append("\r\n");
		}
		System.out.println("Body Data:"+bodyData.toString());
		
		PrintWriter out = response.getWriter();
		out.write(bodyData.toString());
	}

}
