package org.scope.models;

import org.springframework.stereotype.Component;

@Component
public class Cat {
    private String message = "May";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
