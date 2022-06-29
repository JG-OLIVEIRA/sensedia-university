package com.sensedia.university.exceptions;

import java.util.InputMismatchException;

public class InvalidInput extends InputMismatchException {

    @Override
    public String getMessage() {
        return  "Foi passada uma string no lugar de um número";
    }
}