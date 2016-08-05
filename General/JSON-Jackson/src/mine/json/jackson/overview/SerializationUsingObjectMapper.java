package mine.json.jackson.overview;

import java.io.File;
import java.io.IOException;

import mine.json.jackson.bean.Applicant;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class SerializationUsingObjectMapper {

	public static void main(String[] args) {
		serialize();
	}

	private static void serialize() {
		ObjectMapper mapperDefault = new ObjectMapper();
		ObjectMapper mapperCustom = new ObjectMapper();
		try {
			mapperDefault.writeValue(new File("./io/SerializationUsingObjectMapper-json-out-default.json"),
					Utility.buildPersonalLoanObject());

			mapperCustom.enable(SerializationFeature.INDENT_OUTPUT);
			mapperCustom.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
			mapperCustom.setSerializationInclusion(Include.NON_EMPTY);
			mapperCustom.setDateFormat(Utility.getDefaultDateFormat());
			mapperCustom.setPropertyNamingStrategy(new PropertyNamingStrategy() {

				private static final long serialVersionUID = 1L;

				@Override
				public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
					if (field.getFullName().equals("mine.json.jackson.bean.Applicant#relationToPrimary")) {
						return "relationshipToPrimary";
					}
					return super.nameForField(config, field, defaultName);
				}

				@Override
				public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
					if (method.getFullName().equals("mine.json.jackson.bean.Applicant#getRelationToPrimary(0 params")
							|| method.getAnnotated().getDeclaringClass().equals(Applicant.class)
							&& defaultName.equals("relationToPrimary")) {
						return "relationshipToPrimary";
					}
					return super.nameForGetterMethod(config, method, defaultName);
				}
			});
			mapperCustom.writeValue(new File("./io/SerializationUsingObjectMapper-json-out-custom.json"),
					Utility.buildPersonalLoanObject());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
