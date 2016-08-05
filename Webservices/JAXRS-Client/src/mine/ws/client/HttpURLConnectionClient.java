package mine.ws.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionClient {

	public static void main(String[] args) {
		invokeReq();
	}

	public static void invokeReq() {
		String protocol = "http";
		String host = "localhost";
		String port = "8080";
		String context = "JAXRS";
		String pathURI = "rest/rootres";
		StringBuilder urlStr = new StringBuilder();
		urlStr.append(protocol).append("://").append(host).append(":")
				.append(port).append("/").append(context).append("/")
				.append(pathURI);
		String bodyData = "100";
		StringBuilder responseData = new StringBuilder(); 
		try {
			URL url = new URL(urlStr.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setAllowUserInteraction(false);
			conn.setRequestMethod("GET");
			conn.connect();
//			conn.setDoOutput(true);
//			conn.setRequestProperty( "Content-type", "application/x-www-form-urlencoded" );
//			conn.setRequestProperty( "Content-length", Integer.toString(bodyData.length()));
//			PrintWriter writer = new PrintWriter(conn.getOutputStream());
//			writer.print(bodyData);
//			writer.flush();
//			writer.close();
			System.out.println("Waiting for response...");
			
			InputStream  rawInStream = conn.getInputStream();
			BufferedReader rdr = new BufferedReader(new InputStreamReader(rawInStream));
			String line;
			while ((line = rdr.readLine()) != null) {
				responseData.append(line);
				responseData.append("\r\n");
			}
			System.out.println("ServerData:" + responseData.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
