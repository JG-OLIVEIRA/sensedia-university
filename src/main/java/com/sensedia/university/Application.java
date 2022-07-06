package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.Menu;

import java.io.IOException;


public class Application {

    public static void main(String[] args) throws InvalidInput {
        Menu menu = new Menu();

        menu.showWelcomeMessage();

        while(true){
            Integer op = menu.showMenuOptions();

            if(op == 5)
                break;

            switch (op){
                case 1:
                    menu.showAlunoOptions();
                case 2:
                    menu.showDocenteOptions();
                case 3:
                    menu.showCursoOptions();
                case 4:
                    menu.showDisciplinaOptions();
            }
        }

    }
}
