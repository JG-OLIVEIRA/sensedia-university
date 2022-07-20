package com.sensedia.university;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.functionalities.*;
import com.sensedia.university.functionalities.impl.*;

public class Application {

    public static void main(String[] args) throws InvalidInput {

        MenuFuncionality menu = new MenuFuncionalityImpl();

        AlunoFuncionality aluno = new AlunoFuncionalityImpl();
        CursoFuncionality curso = new CursoFuncionalityImpl();
        DisciplinaFuncionality disciplina = new DisciplinaFuncionalityImpl();
        DocenteFuncionality docente = new DocenteFuncionalityImpl();

        menu.showWelcomeMessage();

        while(true){
            Integer op = menu.showMenuOptions();

            if(op == 5)
                break;

            switch (op){
                case 1:
                    aluno.showAlunoOptions();
                    break;
                case 2:
                    docente.showDocenteOptions();
                    break;
                case 3:
                    curso.showCursoOptions();
                    break;
                case 4:
                    disciplina.showDisciplinaOptions();
                    break;
            }
        }

    }
}
