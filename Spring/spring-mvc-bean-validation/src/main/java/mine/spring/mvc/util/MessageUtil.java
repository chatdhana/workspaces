package mine.spring.mvc.util;

import java.util.List;
import java.util.Locale;

import mine.spring.mvc.domain.dto.AbstractResponse;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Component
public class MessageUtil implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public <T extends AbstractResponse> T addSuccessMessageToResponse(Class<T> clazz, Locale locale, String msgCode,
            String... msgArgs) throws Exception {
        T response = clazz.newInstance();
        String message = messageSource.getMessage(msgCode, msgArgs, locale);
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }

    public <T extends AbstractResponse> T addFailureMessageToResponse(Class<T> clazz, Locale locale, String msgCode,
            String... msgArgs) throws Exception {
        T response = clazz.newInstance();
        String message = messageSource.getMessage(msgCode, msgArgs, locale);
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public <T extends AbstractResponse> T addFailureMessagesToResponse(Class<T> clazz, Locale locale,
            List<ObjectError> errors, String msgCode, String... msgArgs) throws Exception {
        T response = clazz.newInstance();
        response.setSuccess(false);
        response.setMessage(messageSource.getMessage(msgCode, msgArgs, locale));
        for (ObjectError error : errors) {
            String message = null;
            for (String code : error.getCodes()) {
                try {
                    message = messageSource.getMessage(code, error.getArguments(), locale);
                    break;
                } catch (NoSuchMessageException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (message == null) {
                message = error.getDefaultMessage();
            }
            response.addDetailedMessage("validation."
                    + (error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName()), message);

        }
        return response;
    }
}
