package mine.jobschldr.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ListenerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

	public static void main(String[] args) {

		try {

			// Get the Scheduler instance from the Factory
			Scheduler schdlr = StdSchedulerFactory.getDefaultScheduler();

			// Define the Job
			JobBuilder jobBldr = JobBuilder.newJob(MyQuartzJob.class);
			jobBldr.withDescription("My Quartz Job");
			jobBldr.withIdentity("MyQuartzJob", "Group1");
			JobDetail job = jobBldr.build();

			// Create the trigger
			Trigger trigger = TriggerBuilder.newTrigger().withIdentity("MyQuartzTrigger", "Group1").startNow()
					.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

			// Schedule the job using our trigger
			schdlr.scheduleJob(job, trigger);

			ListenerManager lstnrMgr = schdlr.getListenerManager();
			lstnrMgr.addJobListener(new MyJobListener());
			
			// Start the scheduler
			schdlr.start();
			
			// Pause the scheduler
			// schdlr.standby();

			// Allow some time for the job to be triggered and executed before calling shutdown.
			Thread.sleep(10000);

			// Shutdown the scheduler
			// schdlr.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
