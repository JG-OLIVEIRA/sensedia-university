package com.sensedia.university.functionalities.impl;

import com.sensedia.university.functionalities.CursoFuncionality;
import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.models.Curso;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.CursoService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.services.impl.CursoServiceImpl;

import java.util.List;

public class CursoFuncionalityImpl implements CursoFuncionality {

    InputFuncionality input = new InputFuncionalityImp();

    CursoService cursoService = new CursoServiceImpl();

    AlunoService alunoService = new AlunoServiceImpl();

    @Override
    public void showCursoOptions(){
        System.out.println("");
        System.out.println("Curso");
        System.out.println("");

        System.out.println("");
        System.out.println("1 - Incluir curso");
        System.out.println("2 - Visualizar todos os curso");
        System.out.println("3 - Voltar ao menu");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(3);

        Curso curso = new Curso();

        switch (option) {
            case 1:
                createCurso(curso);
                break;
            case 2:
                showAllCursos();
                break;
            case 3:
                break;
        }

    }

    @Override
    public void createCurso(Curso curso){
        System.out.println("");
        System.out.println("Incluindo um curso...");
        System.out.println("");

        System.out.println("Nome:");
        String nome = input.inputString(50);

        while(true){

            if(cursoService.getCursoByNome(nome).getId() != null){
                System.out.println("O curso já existe. Digite um novo! ");
                System.out.println("Nome:");
                nome = input.inputString(50);
            } else {
                break;
            }

        }

        curso.setNome(nome);

        cursoService.createCurso(curso);

        System.out.println(curso);
    }

    @Override
    public void showAllCursos(){
        System.out.println("");
        System.out.println("Cursos: ");
        System.out.println("");

        List<Curso> cursos = cursoService.getAllCurso();

        if(cursos.isEmpty()){
            System.out.println("Nenhum curso cadastrado!");
        } else {
            cursos.forEach(curso -> System.out.println(curso));
        }

        System.out.println("");
    }

    @Override
    public void showCursosByMatricula(String matricula){
        System.out.println("");
        System.out.println("Cursos: ");
        System.out.println("");

        List<Curso> cursos = alunoService.getCursosByMatricula(matricula);

        if(cursos.isEmpty()){
            System.out.println("Nenhum curso cadastrado!");
        } else {
            cursos.forEach(curso -> System.out.println(curso));
        }

        System.out.println("");
    }

}
