package mine.spring.mvc.validation.validators;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mine.spring.mvc.validation.constraints.Phone;

/**
 * Validates that a given character sequence is a valid phone number.
 * 
 * @author dhana
 *
 */
public class PhoneValidator implements ConstraintValidator<Phone, CharSequence> {

    String isoCountryCode;

    @Override
    public void initialize(Phone constraintAnnotation) {
        isoCountryCode = constraintAnnotation.isoCountryCode();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return validate(value.toString());
    }

    private boolean validate(String phoneNumber) {
        CountryWisePattern countryWisePattern = null;
        switch (isoCountryCode) {
        case "US":
            countryWisePattern = CountryWisePattern.US;
            break;
        case "IN":
        default:
            countryWisePattern = CountryWisePattern.IN;
        }

        Pattern pattern = Pattern.compile(countryWisePattern.value());
        return pattern.matcher(phoneNumber).matches();
    }

    private enum CountryWisePattern {
        IN("^$|((\\+*)((0[ -]+)*|(91[ -])*)(\\d{12}+|\\d{10}+))|\\d{5}([- ]*)\\d{6}"), US("");
        private CountryWisePattern(String pattern) {
            this.pattern = pattern;
        }

        public String value() {
            return pattern;
        }

        private String pattern;
    }

}
