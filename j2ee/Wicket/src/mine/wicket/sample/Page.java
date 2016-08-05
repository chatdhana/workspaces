package mine.wicket.sample;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;

public class Page extends WebPage {
	private static final long serialVersionUID = 1L;
	
	public Page() {
		add(new Label("titleId", "Wicket Test Page"));
		add(new Label("labelId", "Wicket Label:"));
		TextField<String> textField = new TextField<>("textId");
		textField.info("Feed Data Here");
		add(textField);
	}
}
