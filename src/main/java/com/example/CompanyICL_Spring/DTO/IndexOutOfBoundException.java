package com.example.CompanyICL_Spring.DTO;

//Создание кастомного Exception
public class IndexOutOfBoundException extends RuntimeException{
    public IndexOutOfBoundException(String message) {
        super(message);
    }

}
