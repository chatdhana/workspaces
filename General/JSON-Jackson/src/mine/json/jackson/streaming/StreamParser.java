package mine.json.jackson.streaming;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/**
 * Parses the JSON string content using JsonParser created from JsonFactory.
 * 
 * Follows StAX - Event Iterator API
 * 
 * Client code can have full control over the tokens/events.
 * 
 * Each token/event is read by parser and checked for types.
 * 
 * Tokens are nothing but the JSON objects (start of object, start of array, field name, string value, true value, etc.)
 * 
 * @author dhana
 * 
 */
public class StreamParser {

	public static void main(String[] args) {
		parse();
		System.out.println("StreamParser Parsed the JSON content...");
	}

	private static void parse() {
		JsonFactory jsonFactory = new JsonFactory(); // Factory to create JSON parser (Reader)
		JsonParser jsonParser = null;
		try {

			jsonParser = jsonFactory.createParser(new File("./io/StreamingParser-json-input.json"));

			while (!jsonParser.isClosed()) { // Parse tokens till the end-of-input.
				JsonToken token = jsonParser.nextToken();

				if (token == null) {
					break;
				}

				switch (token) {
				case START_OBJECT:
					System.out.println('{');
					break;
				case START_ARRAY:
					System.out.print('[');
					break;
				case END_OBJECT:
					System.out.println("},");
					break;
				case END_ARRAY:
					System.out.print(']');
					break;
				case FIELD_NAME:
					System.out.print(jsonParser.getCurrentName() + " : ");
					break;
				case VALUE_STRING:
					System.out.println("\"" + jsonParser.getText() + "\",");
					break;
				case VALUE_NUMBER_INT:
				case VALUE_NUMBER_FLOAT:
				case VALUE_FALSE:
				case VALUE_TRUE:
					System.out.println(jsonParser.getText() + ',');
					break;
				case VALUE_NULL:
				case NOT_AVAILABLE:
					break;
				default:
					break;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (jsonParser != null)
					jsonParser.close();
			} catch (IOException e) {
			}
		}
	}
}
