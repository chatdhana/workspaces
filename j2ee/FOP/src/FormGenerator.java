import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.afp.goca.GraphicsSetPatternSymbol;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;

public class FormGenerator {

	public static void main(String[] args) {

		try {
			new FormGenerator().genPDF();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void genPDF() throws Exception {
		
		
		//GraphicsSetPatternSymbol pattern = new GraphicsSetPatternSymbol(new Byte(""));
		
		// Step 1: Construct a FopFactory
		// (reuse if you plan to render multiple documents!)
		FopFactory fopFactory = FopFactory.newInstance();

		// Step 2: Set up output stream.
		// Note: Using BufferedOutputStream for performance reasons (helpful
		// with FileOutputStreams).
		OutputStream out = new BufferedOutputStream(new FileOutputStream(
				new File("./io/out.pdf")));

		try {
			// Step 3: Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

			// Step 4: Setup JAXP using identity transformer
			TransformerFactory factory = TransformerFactory.newInstance();

			// with XSLT:
			Source xslt = new StreamSource(new File("./io/inXSL.xsl"));
			Transformer transformer = factory.newTransformer(xslt);

			// Step 5: Setup input and output for XSLT transformation
			// Setup input stream
			Source src = new StreamSource(new File("./io/inXML.xml"));

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Step 6: Start XSLT transformation and FOP processing
			transformer.transform(src, res);

		} finally {
			// Clean-up
			out.close();
		}
	}

}
