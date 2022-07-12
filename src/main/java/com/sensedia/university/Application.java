package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.Menu;

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
                    break;
                case 2:
                    menu.showDocenteOptions();
                    break;
                case 3:
                    menu.showCursoOptions();
                    break;
                case 4:
                    menu.showDisciplinaOptions();
                    break;
            }
        }

    }
}
