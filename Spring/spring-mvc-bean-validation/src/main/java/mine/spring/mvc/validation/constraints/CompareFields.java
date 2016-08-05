package mine.spring.mvc.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import mine.spring.mvc.validation.validators.CompareFieldsValidator;

/**
 * Validates the given fields for equivalent or unique.
 * 
 * @author dhana
 *
 */
@Documented
@Retention(RUNTIME)
@Constraint(validatedBy = { CompareFieldsValidator.class })
@Target({ TYPE, ANNOTATION_TYPE })
public @interface CompareFields {
    String[] fieldNames();

    CompareMode comparisonMode() default CompareMode.EQUAL;

    String message() default "{mine.spring.mvc.constraint.Equal.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
