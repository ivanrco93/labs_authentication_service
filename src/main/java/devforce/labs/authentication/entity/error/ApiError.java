package devforce.labs.authentication.entity.error;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {
    private ErrorType errorType;
    private String message;
    private LocalDateTime timestamp;

    private Map<String, String> details;

    public ApiError(ErrorType errorType, String message, LocalDateTime timestamp, Map<String, String> details) {
        this.errorType = errorType;
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return errorType == apiError.errorType && message.equals(apiError.message);
    }

    @Override
    public int hashCode(){
        int result = errorType.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "errorType=" + errorType +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", details=" + details +
                '}';
    }
}
