package mine.spring.mvc.validation.validators;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import mine.spring.mvc.domain.dto.PhoneValidationDto;

public class StandaloneValidator {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        PhoneValidationDto dto = new PhoneValidationDto();
        dto.setPhone("18140");
        Set<ConstraintViolation<PhoneValidationDto>> violations = validator.validate(dto);
        for (ConstraintViolation<PhoneValidationDto> violation : violations) {
            System.out.println("Msg:" + violation.getMessage());
            System.out.println("Msg Template:" + violation.getMessageTemplate());
            System.out.println("Invalid Value:" + violation.getInvalidValue());
            System.out.println("Path:" + violation.getPropertyPath());
        }
    }
}
