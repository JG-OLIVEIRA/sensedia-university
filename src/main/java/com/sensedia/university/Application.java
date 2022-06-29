package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.Menu;


public class Application {

    public static void main(String[] args) throws InvalidInput {
        Menu menu = new Menu();

        menu.showWelcomeMessage();
        menu.showInsertOptions();

        Integer option = menu.inputInsertOptions();

        switch (option){
            case 1:
                menu.createAluno();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}
