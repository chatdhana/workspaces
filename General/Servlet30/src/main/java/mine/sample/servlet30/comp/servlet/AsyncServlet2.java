package mine.sample.servlet30.comp.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AsyncServlet2
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/asyncServlet2" })
public class AsyncServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AsyncServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AsyncContext asyncCtx = request.startAsync();
		asyncCtx.addListener(new AsyncListener() {

			@Override
			public void onComplete(AsyncEvent asyncEvent) throws IOException {
				System.out.println("MyAsyncListener-->onComplete():" + asyncEvent.getAsyncContext().toString());
			}

			@Override
			public void onError(AsyncEvent asyncEvent) throws IOException {
			}

			@Override
			public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
				System.out.println("MyAsyncListener-->onStartAsync():" + asyncEvent.getAsyncContext().toString());
			}

			@Override
			public void onTimeout(AsyncEvent asyncEvent) throws IOException {
			}

		});

		asyncCtx.complete();

	}

}
