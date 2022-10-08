package devforce.labs.authentication.entity.error;

import java.time.LocalDateTime;

public class ApiError {
    private ErrorType errorType;
    private String message;
    private LocalDateTime timestamp;

    public ApiError(ErrorType errorType, String message, LocalDateTime timestamp) {
        this.errorType = errorType;
        this.message = message;
        this.timestamp = timestamp;
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
                '}';
    }
}
