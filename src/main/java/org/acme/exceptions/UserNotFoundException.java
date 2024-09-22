package org.acme.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);  // Passa a mensagem para a superclasse
    }
}
