package org.scope.models;


import org.springframework.stereotype.Component;

@Component
public class Dog {
    private String message = "Woof";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
