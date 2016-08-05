package mine.spring.mvc.domain.dto;

import javax.validation.constraints.AssertTrue;

import mine.spring.mvc.validation.constraints.CompareFields;
import mine.spring.mvc.validation.constraints.CompareMode;

@CompareFields(fieldNames = { "fieldOne", "fieldTwo", "fieldThree" }, comparisonMode = CompareMode.EQUAL_IGNORE_CASE, message = "Fields are unequal")
public class EqualValidationDto extends BaseDto {
    String fieldOne;
    String fieldTwo;
    String fieldThree;

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    public String getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(String fieldThree) {
        this.fieldThree = fieldThree;
    }

    @AssertTrue(message = "Fields fieldOne and fieldTwo must be equal")
    private boolean isEqual() {
        return (fieldOne == null && fieldTwo == null) || (fieldOne.equals(fieldTwo));
    }

}
