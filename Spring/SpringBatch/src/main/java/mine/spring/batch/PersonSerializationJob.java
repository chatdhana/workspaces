package mine.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;

public class PersonSerializationJob implements Job {

	public void execute(JobExecution arg0) {

	}

	public JobParametersIncrementer getJobParametersIncrementer() {
		return null;
	}

	public JobParametersValidator getJobParametersValidator() {
		return null;
	}

	public String getName() {
		return null;
	}

	public boolean isRestartable() {
		return false;
	}

}
