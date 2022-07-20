package com.sensedia.university.functionalities.impl;

import com.sensedia.university.functionalities.DisciplinaFuncionality;
import com.sensedia.university.functionalities.DocenteFuncionality;
import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.models.Docente;
import com.sensedia.university.services.DisciplinaService;
import com.sensedia.university.services.DocenteService;
import com.sensedia.university.services.impl.DisciplinaServiceImpl;
import com.sensedia.university.services.impl.DocenteServiceImpl;

import java.util.List;

public class DocenteFuncionalityImpl implements DocenteFuncionality {

    InputFuncionality input = new InputFuncionalityImp();

    DocenteService docenteService = new DocenteServiceImpl();
    DisciplinaService disciplinaService = new DisciplinaServiceImpl();
    DisciplinaFuncionality disciplinaFuncionality = new DisciplinaFuncionalityImpl();

    @Override
    public void showDocenteOptions(){
        System.out.println("");
        System.out.println("Docente");
        System.out.println("");
        System.out.println("1 - Matricular um docente");
        System.out.println("2 - Voltar ao menu");
        System.out.println("3 - Mostrar todos os docentes");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(3);

        Docente docente = new Docente();

        switch (option) {
            case 1:
                createDocente(docente);
                break;
            case 2:
                break;
            case 3:
                showAllDocentes();
                break;
        }
    }

    @Override
    public void createDocente(Docente docente){
        System.out.println("");
        System.out.println("Matriculando um docente...");
        System.out.println("");

        System.out.println("Nome:");
        String nome = input.inputString(25);
        System.out.println("Sobrenome:");
        String sobrenome = input.inputString(50);

        docente.setNome(nome);
        docente.setSobrenome(sobrenome);

        docente = docenteService.createDocente(docente);

        System.out.println(docente);
    }

    @Override
    public void createDocenteDisciplina(){
        System.out.println("");
        System.out.println("Incluino um docente em uma disciplina...");
        System.out.println("");

        System.out.println("");
        disciplinaFuncionality.showAllDisciplinas();
        System.out.println("");

        System.out.println("Entre com o id da disciplina: ");
        Integer id = input.inputInteger();

        String matricula = input.inputMatricula();
        Docente docente = docenteService.getDocenteByMatricula(matricula);

        Disciplina disciplina = disciplinaService.getDisciplinaById(id);

        docenteService.addDisciplina(docente, disciplina);
    }

    @Override
    public void showAllDocentes(){
        System.out.println("");
        System.out.println("Docentes: ");
        System.out.println("");

        List<Docente> docentes = docenteService.getAllDocente();

        if(docentes.isEmpty()){
            System.out.println("Nenhum docente cadastrado!");
        } else {
            docentes.forEach(docente -> System.out.println(docente));
        }

        System.out.println("");
    }

}
