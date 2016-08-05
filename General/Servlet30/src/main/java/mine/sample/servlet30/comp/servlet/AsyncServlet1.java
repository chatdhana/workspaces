package mine.sample.servlet30.comp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value = "/asyncServlet1", asyncSupported = true)
public class AsyncServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {
		AsyncContext asyncCtx = req.startAsync();
		System.out.println("Default Timeout:" + asyncCtx.getTimeout());
		asyncCtx.setTimeout(20000);
		System.out.println("New Custom Timeout:" + asyncCtx.getTimeout());
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new TimetakingCommand(asyncCtx));
		PrintWriter out = resp.getWriter();
		out.write("Server Managed Request Thread has done it's work.");
		System.out.println("Server Managed Request Thread has done it's work.");
	}
}

class TimetakingCommand implements Runnable {
	private AsyncContext asyncCtx;

	public TimetakingCommand(AsyncContext asyncCtx) {
		this.asyncCtx = asyncCtx;
	}

	@Override
	public void run() {
		System.out.println("Started executing timetaking process.");
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		PrintWriter out = null;
		try {
			out = asyncCtx.getResponse().getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.write("Local Thread has done it's work too.");
		this.asyncCtx.complete();

		System.out.println("Completed executing timetaking process.");
	}
}
