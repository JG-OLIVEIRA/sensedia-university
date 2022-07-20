package com.sensedia.university.functionalities.impl;

import com.sensedia.university.functionalities.DisciplinaFuncionality;
import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.services.DisciplinaService;
import com.sensedia.university.services.impl.DisciplinaServiceImpl;

import java.util.List;

public class DisciplinaFuncionalityImpl implements DisciplinaFuncionality {

    InputFuncionality input = new InputFuncionalityImp();

    DisciplinaService disciplinaService = new DisciplinaServiceImpl();

    @Override
    public void showDisciplinaOptions(){
        System.out.println("");
        System.out.println("Disciplina");
        System.out.println("");

        System.out.println("");
        System.out.println("1 - Incluir disciplina");
        System.out.println("2 - Voltar ao menu");
        System.out.println("3 - Visualizar disciplinas");
        System.out.println("4 - Atualizar uma disciplina");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(4);

        Disciplina disciplina = new Disciplina();

        switch (option) {
            case 1:
                createDisciplina(disciplina);
                break;
            case 2:
                break;
            case 3:
                showAllDisciplinas();
                break;
            case 4:
                updateDisciplina();
                break;
        }

    }

    @Override
    public void createDisciplina(Disciplina disciplina){
        System.out.println("");
        System.out.println("Incluino uma disciplina...");
        System.out.println("");

        System.out.println("Nome:");
        String nome = input.inputString(100);

        System.out.println("Turno:");
        String turno = input.inputString(2);

        System.out.println("Sala:");
        Integer sala = input.inputInteger();

        disciplina.setNome(nome);
        disciplina.setTurno(turno);
        disciplina.setSala(sala);

        disciplina = disciplinaService.createDisciplina(disciplina);

        System.out.println(disciplina);
    }

    @Override
    public void updateDisciplina(){
        System.out.println("");
        System.out.println("Atualizando uma disciplina...");
        System.out.println("");

        System.out.println("");
        showAllDisciplinas();
        System.out.println("");

        System.out.println("Entre com o id da disciplina: ");
        Integer id = input.inputInteger();

        Disciplina disciplina = disciplinaService.getDisciplinaById(id);

        if(disciplina.getNome() == null){
            System.out.println("");
            System.out.println("Disciplina não encontrada!");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println(disciplina);
            System.out.println("");

            System.out.println("Nome:");
            String nome = input.inputString(100);

            System.out.println("Turno:");
            String turno = input.inputString(2);

            System.out.println("Sala:");
            Integer sala = input.inputInteger();

            disciplina.setNome(nome);
            disciplina.setTurno(turno);
            disciplina.setSala(sala);

            disciplina = disciplinaService.updateDisciplinaById(disciplina);

            System.out.println("");
            System.out.println(disciplina);
            System.out.println("");
        }

    }

    @Override
    public void showAllDisciplinas(){
        System.out.println("");
        System.out.println("Disciplinas: ");
        System.out.println("");

        List<Disciplina> disciplinas = disciplinaService.getAllDisciplina();

        if(disciplinas.isEmpty()){
            System.out.println("Nenhuma disciplina cadastrada!");
        } else {
            disciplinas.forEach(disciplina -> System.out.println(disciplina));
        }

        System.out.println("");
    }

}
