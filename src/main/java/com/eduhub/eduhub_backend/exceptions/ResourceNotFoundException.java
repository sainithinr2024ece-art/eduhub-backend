package com.eduhub.eduhub_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resource,String field,int error){
        super(String.format("%s not found with %s:%s",resource,field,error));
    }
}
