package mine.sample.servlet30.comp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nonBlockingIOServlet1")
public class NonBlockingIOServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NonBlockingIOServlet1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletInputStream servletInStream = request.getInputStream();
		/*servletInStream.setReadListener(new ReadListener() {
			@Override
			public void onError(Throwable arg0) {
			}

			@Override
			public void onDataAvailable() throws IOException {
			}

			@Override
			public void onAllDataRead() throws IOException {
			}
		});*/
	}

}
