package com.sensedia.university.exceptions;

public class InvalidOption extends Exception{

    @Override
    public String getMessage() {
        return  "A opção não existe";
    }
}
