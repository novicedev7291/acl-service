package com.acl.management.acl.handler;

import com.acl.management.acl.exception.AclException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ExceptionHandler {
    @Autowired
    private MessageSource source;

    public AclException getException(String message){
        return new AclException(message, message);
    }

    public AclException getException(String key, Object...params){
        return new AclException(key, source.getMessage(key, params, Locale.getDefault()));
    }

    public AclException getException(String message, Throwable cause){
        return new AclException(message, cause);
    }
}
