package mine.wicket.sample;

import org.apache.wicket.protocol.http.WebApplication;

public class Application extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return Page.class;
	}

}
