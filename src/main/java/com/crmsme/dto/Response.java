package com.crmsme.dto;

import com.crmsme.enums.ResponseStatus;
import com.crmsme.global.ValidationError;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.web.ErrorResponse;

import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private ResponseStatus status;
    private T data;
    private String message;
    private String errorCode;
    private String errorDetails;

    private ValidationError error;
    private String uriPath;




    public ValidationError getError() {
        return error;
    }

    public void setError(ValidationError error) {
        this.error = error;
    }

    public boolean success() {
        return Objects.nonNull(this.status) && this.status == ResponseStatus.SUCCESS;
    }

    public Response(ResponseStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean hasData() {
        return Objects.nonNull(this.data);
    }

    public static <T> Response.ResponseBuilder<T> builder() {
        return new Response.ResponseBuilder();
    }

    public ResponseStatus getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorDetails() {
        return this.errorDetails;
    }

    public String getUriPath() {
        return this.uriPath;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Response)) {
            return false;
        } else {
            Response<?> other = (Response)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                label62: {
                    Object this$errorCode = this.getErrorCode();
                    Object other$errorCode = other.getErrorCode();
                    if (this$errorCode == null) {
                        if (other$errorCode == null) {
                            break label62;
                        }
                    } else if (this$errorCode.equals(other$errorCode)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$errorDetails = this.getErrorDetails();
                    Object other$errorDetails = other.getErrorDetails();
                    if (this$errorDetails == null) {
                        if (other$errorDetails == null) {
                            break label55;
                        }
                    } else if (this$errorDetails.equals(other$errorDetails)) {
                        break label55;
                    }

                    return false;
                }

                Object this$uriPath = this.getUriPath();
                Object other$uriPath = other.getUriPath();
                if (this$uriPath == null) {
                    if (other$uriPath != null) {
                        return false;
                    }
                } else if (!this$uriPath.equals(other$uriPath)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Response;
    }
//
//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $status = this.getStatus();
//        int result = result * 59 + ($status == null ? 43 : $status.hashCode());
//        Object $message = this.getMessage();
//        result = result * 59 + ($message == null ? 43 : $message.hashCode());
//        Object $data = this.getData();
//        result = result * 59 + ($data == null ? 43 : $data.hashCode());
//        Object $errorCode = this.getErrorCode();
//        result = result * 59 + ($errorCode == null ? 43 : $errorCode.hashCode());
//        Object $errorDetails = this.getErrorDetails();
//        result = result * 59 + ($errorDetails == null ? 43 : $errorDetails.hashCode());
//        Object $uriPath = this.getUriPath();
//        result = result * 59 + ($uriPath == null ? 43 : $uriPath.hashCode());
//        return result;
//    }

    public String toString() {
        return "Response(status=" + this.getStatus() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", errorCode=" + this.getErrorCode() + ", errorDetails=" + this.getErrorDetails() + ", uriPath=" + this.getUriPath() + ")";
    }

    public Response() {
    }

    public Response(ResponseStatus status, String message, T data, String errorCode, String errorDetails, String uriPath, ValidationError error) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.errorCode = errorCode;
        this.errorDetails = errorDetails;
        this.uriPath = uriPath;
        this.error = error;
    }

    public static class ResponseBuilder<T> {
        private ResponseStatus status;
        private String message;
        private T data;
        private String errorCode;
        private String errorDetails;
        private String uriPath;

        private ValidationError error;

        ResponseBuilder() {
        }

        public Response.ResponseBuilder<T> status(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public Response.ResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Response.ResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Response.ResponseBuilder<T> errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Response.ResponseBuilder<T> error(ValidationError error) {
            this.error = error;
            return this;
        }

        public Response.ResponseBuilder<T> errorDetails(String errorDetails) {
            this.errorDetails = errorDetails;
            return this;
        }

        public Response.ResponseBuilder<T> uriPath(String uriPath) {
            this.uriPath = uriPath;
            return this;
        }

        public Response<T> build() {
            return new Response(this.status, this.message, this.data, this.errorCode, this.errorDetails, this.uriPath,this.error);
        }

        public String toString() {
            return "Response.ResponseBuilder(status=" + this.status + ", message=" + this.message + ", data=" + this.data + ", errorCode=" + this.errorCode + ", errorDetails=" + this.errorDetails + ", uriPath=" + this.uriPath + ", error="+this.error+")";
        }
    }
}