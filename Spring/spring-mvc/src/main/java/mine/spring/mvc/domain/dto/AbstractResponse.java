package mine.spring.mvc.domain.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractResponse {
    boolean success;
    String message;
    Map<String, String> detailedMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void initDetailedMessage() {
        if (this.detailedMessage == null) {
            this.detailedMessage = new LinkedHashMap<String, String>();
        }
    }

    public Map<String, String> getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(Map<String, String> detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    public void addDetailedMessage(String code, String message) {
        initDetailedMessage();
        this.detailedMessage.put(code, message);
    }
}
