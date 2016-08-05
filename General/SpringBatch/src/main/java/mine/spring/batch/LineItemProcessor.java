package mine.spring.batch;

import org.springframework.batch.item.ItemProcessor;

public class LineItemProcessor implements ItemProcessor<Person, Person> {

	public Person process(Person item) throws Exception {
		return null;
	}

}
