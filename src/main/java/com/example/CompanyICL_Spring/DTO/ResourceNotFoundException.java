package com.example.CompanyICL_Spring.DTO;

//Создание кастомного Exception
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }

}
