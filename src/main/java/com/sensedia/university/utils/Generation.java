package com.sensedia.university.utils;

import java.util.Calendar;
import java.util.Random;

import static java.lang.Math.round;

public class Generation {

    public static String getMatricula(){
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();

        Integer ano = calendar.get(Calendar.YEAR) + 1;
        String matricula = ano + String.valueOf(round(random.nextDouble() * 100000));

        return matricula;
    }
}
