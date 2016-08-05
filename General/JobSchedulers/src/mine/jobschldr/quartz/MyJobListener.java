package mine.jobschldr.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MyJobListener implements JobListener {

	@Override
	public String getName() {
		return "MyJobListener";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		System.out.println("A job about to be executed:" + context.getJobDetail().getDescription());
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.out.println("Vetoed:" + context.getJobDetail().getDescription());
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		System.out.println("A job was executed:" + context.getJobDetail().getDescription());
	}

}
