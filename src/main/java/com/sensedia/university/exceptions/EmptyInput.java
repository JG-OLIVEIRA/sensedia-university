package com.sensedia.university.exceptions;

public class EmptyInput extends Exception {

    @Override
    public String getMessage() {
        return  "Foi passada uma opção vazia!";
    }
}
