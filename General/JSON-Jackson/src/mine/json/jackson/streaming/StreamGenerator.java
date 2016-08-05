package mine.json.jackson.streaming;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * Generates the JSON string content using JsonGenerator created from jsonFactoroy.
 * 
 * Follows StAX - Cursor API
 * 
 * @author dhana
 * 
 */
public class StreamGenerator {

	public static void main(String[] args) {
		generate();
		System.out.println("StreamGenerator - Written JSON string content into a flat file.");
	}

	private static void generate() {
		JsonFactory jsonFactory = new JsonFactory(); // Factory to create JSON generator (Writer)
		JsonGenerator jsonGen = null;
		try {
			jsonGen = jsonFactory.createGenerator(new File("./io/StreamGenerator-json-output.json"), JsonEncoding.UTF8);

			{
				jsonGen.writeStartObject();
				jsonGen.writeFieldName("prop1");
				jsonGen.writeString("value1");
				jsonGen.writeFieldName("prop2");
				{
					jsonGen.writeStartArray();
					jsonGen.writeString("component1");
					jsonGen.writeString("component2");
					jsonGen.writeEndArray();
				}
				jsonGen.writeEndObject();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (jsonGen != null)
					jsonGen.close();
			} catch (IOException e) {
			}
		}

	}
}
