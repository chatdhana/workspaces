package mine.spring.mvc.domain.dto;

import mine.spring.mvc.validation.constraints.Phone;

public class PhoneValidationDto extends BaseDto {
    @Phone(isoCountryCode = "IN", message = "It should be India phone number")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
