package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.Menu;


public class Application {

    public static void main(String[] args) throws InvalidInput {
        Menu menu = new Menu();

        Integer option, alunoOption, docenteOption, cursoOption, discipĺinaOption;

        do {

            menu.showWelcomeMessage();
            menu.showMainOptions();

            option = menu.inputOptions();

            switch (option){
                case 1:
                    menu.showAlunoOptions();
                    alunoOption = menu.inputOptions();

                    switch (alunoOption){
                        case 1:
                            menu.createAluno();
                        case 2:
                            menu.showCursosOptions();
                            menu.createAlunoCurso();
                    }

                    break;
                case 2:
                    menu.showDocenteOptions();
                    docenteOption = menu.inputOptions();

                    switch (docenteOption){
                        case 1:
                            menu.createDocente();
                    }

                    break;
                case 3:
                    menu.showCursoOptions();
                    cursoOption = menu.inputOptions();

                    switch (cursoOption){
                        case 1:
                            menu.createCurso();
                    }

                    break;
                case 4:
                    menu.showDisciplinaOptions();
                    discipĺinaOption = menu.inputOptions();

                    switch (discipĺinaOption){
                        case 1:
                            menu.createDisciplina();
                    }

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
