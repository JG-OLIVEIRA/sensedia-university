package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.Menu;


public class Application {

    public static void main(String[] args) throws InvalidInput {
        Menu menu = new Menu();

        Integer option;

        do {

            menu.showWelcomeMessage();
            menu.showInsertOptions();

            option = menu.inputInsertOptions();

            switch (option){
                case 1:
                    menu.createAluno();
                    break;
                case 2:
                    menu.createDocente();
                    break;
                case 3:
                    menu.createCurso();
                    break;
                case 4:
                    menu.createDisciplina();
                    break;
                case 5:
                    System.out.println("Saindo");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (option < 1 || option > 5);

    }
}
