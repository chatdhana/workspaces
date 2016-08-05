package mine.spring.mvc.domain.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.Size;

import mine.spring.mvc.validation.groups.High;
import mine.spring.mvc.validation.groups.Low;
import mine.spring.mvc.validation.groups.Medium;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@GroupSequence({ ConstraintGroupingDto.class, High.class, Medium.class, Low.class })
public class ConstraintGroupingDto extends BaseDto {

    @Size(min = 8, groups = Medium.class)
    @Email(groups = Low.class)
    @NotEmpty(groups = High.class)
    String email;

    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
