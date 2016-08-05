package mine.json.jackson.treemodel;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ValueNode;

/**
 * Reads JSON string content from a file or URL.
 * 
 * Generates the tree of JsonNodes by passing the JSON content into ObjectMapper's readTree() method.
 * 
 * Iterates over nodes recursively and display the content (struct start, struct end, array start, array end, field name, value).
 * 
 * @author dhana
 * 
 */
public class TreeModelParser {

	public static void main(String[] args) {
		parse();
	}

	private static void parse() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(new File("./io/TreeModelParser-json-input.json"));
			System.out.println(rootNode.size()); // no of fields in this node (iff ObjectNode)

			System.out.println('{');
			handleNode(rootNode);
			System.out.println('}');

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void handleNode(JsonNode givenNode) {

		switch (givenNode.getNodeType()) {
		case OBJECT:
			for (Iterator<Entry<String, JsonNode>> iter = givenNode.fields(); iter.hasNext();) {
				Entry<String, JsonNode> nodeEntry = iter.next();

				if (nodeEntry.getValue().isContainerNode()) {
					System.out.println(nodeEntry.getKey() + " : {");
					handleNode(nodeEntry.getValue());
					System.out.println("}");
				} else {
					System.out.print(nodeEntry.getKey());
					handleNode(nodeEntry.getValue());
				}

			}
			break;
		case ARRAY:
			for (JsonNode node : givenNode) {
				System.out.print('[');
				handleNode(node);
				System.out.print("],");
			}
			break;
		case STRING:
			ValueNode valueNode = (ValueNode) givenNode;
			System.out.println(" :" + valueNode.textValue());
			break;
		case NUMBER:
			NumericNode numericNode = (NumericNode) givenNode;
			if (numericNode instanceof IntNode) {
				System.out.println(" : " + numericNode.asInt());
			} else if (numericNode instanceof LongNode) {
				System.out.println(" : " + numericNode.asLong());
			} else if (numericNode instanceof DoubleNode || numericNode instanceof FloatNode) {
				System.out.println(" : " + numericNode.asDouble());
			}

			break;
		case BOOLEAN:
			BooleanNode booleanNode = (BooleanNode) givenNode;
			System.out.println(booleanNode.asBoolean());
			break;
		case MISSING:
		case NULL:
		case POJO:
			break;
		default:
			break;
		}
	}
}
