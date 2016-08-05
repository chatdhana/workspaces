package mine.spring.batch;

import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;

public class PersonSerializationStep implements Step {

	public void execute(StepExecution arg0) throws JobInterruptedException {

	}

	public String getName() {
		return null;
	}

	public int getStartLimit() {
		return 0;
	}

	public boolean isAllowStartIfComplete() {
		return false;
	}

}
