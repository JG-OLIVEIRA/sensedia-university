package com.sensedia.university.utils;

import com.sensedia.university.exceptions.InvalidInput;

public class CheckIntegerInput{

    public static Integer verify(String numero) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            throw new InvalidInput();
        }
    }
}