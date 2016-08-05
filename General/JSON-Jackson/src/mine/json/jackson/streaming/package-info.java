/**
 * Streaming Parser and Generator (StAX based)
 * 
 * Use the JsonParser (Reader) to parse the JSON stream. It provides the JSON elements as tokens.
 * 
 * Use the JsonGenerator (Writer) to generate the JSON from string, integer, boolean etc.
 * 
 * Jackson provides a low level API to parse JSON string. The API provides token for each JSON object.
 * For example, the start of JSON '{' is the first object that the parser provides. The key value pair is another single object.
 * The client code can use the tokens and get the JSON properties or build a java object out of it if required.
 * This low level API is extremely powerful but needs a lot of coding. For most cases, Jackson's tree traversing and data binding
 * capability should be explored instead.
 * 
 */

/**
 * @author dhana
 *
 */
package mine.json.jackson.streaming;