package mine.spring.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;


public class LineItemReader implements ItemReader<Person> {

	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		return null;
	}

}
