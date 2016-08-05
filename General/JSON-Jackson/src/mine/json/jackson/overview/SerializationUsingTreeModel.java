package mine.json.jackson.overview;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SerializationUsingTreeModel {

	public static void main(String[] args) {
		serialize();
	}

	private static void serialize() {
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory jsonFactory = new JsonFactory(); // To generate JSON generator (writer) or parser (reader)
		JsonNodeFactory nodeFactory = JsonNodeFactory.instance; // To build JSON nodes
		try {
			JsonGenerator jsonGen = jsonFactory.createGenerator(new File(
					"./io/SerializationUsingTreeModel-json-out-treemodel.json"), JsonEncoding.UTF8);

			ObjectNode rootNode = nodeFactory.objectNode();
			rootNode.putPOJO("rootKey", "value"/*Utility.buildPersonalLoanObject()*/);

			mapper.writeTree(jsonGen, rootNode);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
