package mine.interfaces.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class SimpleCompileTimeAnnotationProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		System.err.println("Processing Round...");
		super.processingEnv.getMessager().printMessage(Kind.NOTE , "Processing Annotation ....");
		for (TypeElement typeEelement : annotations) {
			System.out.println("####Annotation:"+typeEelement.toString());
			Set<? extends Element> annotedElemSet = roundEnv
					.getElementsAnnotatedWith(typeEelement);
			for (Element element : annotedElemSet) {
				System.out.println(element.toString());
			}
		}
		return false;
	}

}
