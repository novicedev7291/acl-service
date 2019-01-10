package com.acl.management.acl.exception;

import lombok.Getter;

@Getter
public class AclException extends RuntimeException {
    private String messageKey;
    private String[] msgParams;

    public AclException(String messageKey, String message) {
        super(message);
        this.messageKey = messageKey;
    }

    public AclException(String message, Throwable cause) {
        super(message, cause);
    }

    public AclException(String messageKey, String...msgParams){
        super(messageKey);
        this.messageKey = messageKey;
        this.msgParams = msgParams;
    }

    public AclException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
