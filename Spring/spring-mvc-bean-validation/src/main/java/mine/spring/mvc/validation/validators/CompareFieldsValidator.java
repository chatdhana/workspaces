package mine.spring.mvc.validation.validators;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mine.spring.mvc.validation.constraints.CompareFields;
import mine.spring.mvc.validation.constraints.CompareMode;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Validates the given fields for equivalent or unique.
 * 
 * @author dhana
 *
 */
public class CompareFieldsValidator implements ConstraintValidator<CompareFields, Object> {
    String[] fieldNames;
    CompareMode compareMode;

    @Override
    public void initialize(CompareFields constraintAnnotation) {
        this.fieldNames = constraintAnnotation.fieldNames();
        this.compareMode = constraintAnnotation.comparisonMode();
    }

    @Override
    public boolean isValid(Object bean, ConstraintValidatorContext context) {
        if (!validate(bean)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(getCustomMessage()).addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean validate(Object bean) {
        boolean ignoreCase = false;
        List<Object> fieldValues = getFieldValues(bean);
        if (compareMode == CompareMode.EQUAL_IGNORE_CASE || compareMode == CompareMode.NOT_EQUAL_IGNORE_CASE) {
            ignoreCase = true;
        }

        List<Object> finalFieldValues = null;
        if (fieldValues.size() > 0) {
            finalFieldValues = new ArrayList<Object>(fieldValues.size());
            if (ignoreCase) {
                for (Object fieldValue : fieldValues) {
                    if (fieldValue != null && fieldValue instanceof CharSequence) {
                        finalFieldValues.add(fieldValue.toString().toLowerCase());
                    } else {
                        finalFieldValues.add(fieldValue);
                    }
                }
            } else {
                finalFieldValues.addAll(fieldValues);
            }
        }

        Set<Object> uniqueFields = new HashSet<Object>(finalFieldValues);

        switch (compareMode) {
        case EQUAL:
        case EQUAL_IGNORE_CASE:
            return uniqueFields.size() == 1;
        case NOT_EQUAL:
        case NOT_EQUAL_IGNORE_CASE:
            return uniqueFields.size() == fieldValues.size();
        default:
            break;
        }

        return false;
    }

    private String getCustomMessage() {
        StringBuilder message = new StringBuilder("Fields [");
        boolean firstField = true;
        for (String field : fieldNames) {
            if (!firstField) {
                message.append(", ");
            } else {
                firstField = false;
            }
            message.append(field);
        }

        message.append("] must be ");
        switch (compareMode) {
        case EQUAL:
        case EQUAL_IGNORE_CASE:
            message.append(" equal");
            break;
        case NOT_EQUAL:
        case NOT_EQUAL_IGNORE_CASE:
            message.append(" unequal");
            break;
        default:
            break;
        }

        return message.toString();
    }

    private List<Object> getFieldValues(Object bean) {
        List<Object> fieldValues = new ArrayList<Object>(fieldNames.length);
        for (String fieldName : fieldNames) {
            Object fieldValue = null;
            try {
                fieldValue = BeanUtils.getProperty(bean, fieldName);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
            fieldValues.add(fieldValue);
        }
        return fieldValues;
    }
}
