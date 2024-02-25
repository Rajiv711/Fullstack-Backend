package com.CRUDproject.FullstackBackend.Exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Culd not found the user with the id "+id);
    }
}
