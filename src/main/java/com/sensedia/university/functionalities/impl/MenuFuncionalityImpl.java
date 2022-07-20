package com.sensedia.university.functionalities.impl;

import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.functionalities.MenuFuncionality;

public class MenuFuncionalityImpl implements MenuFuncionality {

    InputFuncionality input = new InputFuncionalityImp();

    @Override
    public void showWelcomeMessage(){
        System.out.println("");
        System.out.println("Bem vindo a Sensedia University");
        System.out.println("");
    }

    @Override
    public Integer showMenuOptions(){
        System.out.println("Escolhas as opções abaixo: ");
        System.out.println("");
        System.out.println("1 - Aluno");
        System.out.println("2 - Docente");
        System.out.println("3 - Curso");
        System.out.println("4 - Disciplina");
        System.out.println("5 - Sair da aplicação");
        System.out.println("");

        return input.inputIntegerWithRange(5);
    }

}
