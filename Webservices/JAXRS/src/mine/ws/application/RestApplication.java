package mine.ws.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import mine.ws.resource.ContentNegotiationResource;
import mine.ws.resource.ContextInfoResource;
import mine.ws.resource.HelloWorldResource;
import mine.ws.resource.HttpMethodsResource;
import mine.ws.resource.ParametersResource;
import mine.ws.resource.ProducesConsumesResource;
import mine.ws.resource.ResRepresentationResource;
import mine.ws.resource.ReturnTypeResource;
import mine.ws.resource.RootResource;
import mine.ws.resource.SubResource;

/**
 * JAX-RS Application sub class.
 * 
 * Provides list of available resources/providers to JAX-RS runtime.
 * 
 * @author 1352755
 *
 */
public class RestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resourceClasses = new HashSet<Class<?>>();
		resourceClasses.add(HelloWorldResource.class);
		resourceClasses.add(RootResource.class);
		resourceClasses.add(SubResource.class);
		resourceClasses.add(HttpMethodsResource.class);
		resourceClasses.add(ParametersResource.class);
		resourceClasses.add(ProducesConsumesResource.class);
		resourceClasses.add(ResRepresentationResource.class);
		resourceClasses.add(ContentNegotiationResource.class);
		resourceClasses.add(ContextInfoResource.class);		
		resourceClasses.add(ReturnTypeResource.class);
		return resourceClasses;
	}

	@Override
	public Set<Object> getSingletons() {
		return super.getSingletons();
	}

}
