package com.sensedia.university.functionalities.impl;

import com.sensedia.university.functionalities.AlunoFuncionality;
import com.sensedia.university.functionalities.CursoFuncionality;
import com.sensedia.university.functionalities.DisciplinaFuncionality;
import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.CursoService;
import com.sensedia.university.services.DisciplinaService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.services.impl.CursoServiceImpl;
import com.sensedia.university.services.impl.DisciplinaServiceImpl;

import java.util.List;

public class AlunoFuncionalityImpl implements AlunoFuncionality {

    InputFuncionality input = new InputFuncionalityImp();

    AlunoService alunoService = new AlunoServiceImpl();
    CursoService cursoService = new CursoServiceImpl();
    DisciplinaService disciplinaService = new DisciplinaServiceImpl();

    DisciplinaFuncionality disciplinaFuncionality = new DisciplinaFuncionalityImpl();
    CursoFuncionality cursoFuncionality = new CursoFuncionalityImpl();

    @Override
    public void showAlunoOptions(){
        System.out.println("");
        System.out.println("Aluno");
        System.out.println("");

        System.out.println("");
        System.out.println("1 - Matricular um aluno");
        System.out.println("2 - Incluir um aluno em um curso");
        System.out.println("3 - Voltar ao menu");
        System.out.println("4 - Visualizar todos os alunos");
        System.out.println("5 - Visualizar todos os curso pela matricula do aluno");
        System.out.println("6 - Incluir um aluno em uma disciplina");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(6);

        Aluno aluno = new Aluno();

        switch (option) {
            case 1:
                createAluno(aluno);
                break;
            case 2:
                createAlunoCurso();
                break;
            case 3:
                break;
            case 4:
                showAllAlunos();
                break;
            case 5:
                String matricula = input.inputMatricula();
                cursoFuncionality.showCursosByMatricula(matricula);
                break;
            case 6:
                createAlunoDisciplina();
                break;
        }
    }

    @Override
    public void createAluno(Aluno aluno){
        System.out.println("");
        System.out.println("Matriculando um aluno...");
        System.out.println("");

        System.out.println("Nome:");
        String nome = input.inputString(25);
        System.out.println("Sobrenome:");
        String sobrenome = input.inputString(50);

        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);

        aluno = alunoService.createAluno(aluno);

        System.out.println(aluno);
    }

    @Override
    public void createAlunoCurso(){
        System.out.println("");
        System.out.println("Incluino um aluno em um curso...");
        System.out.println("");

        System.out.println("");
        cursoFuncionality.showAllCursos();
        System.out.println("");

        System.out.println("Entre com o id do curso: ");
        Integer id = input.inputInteger();

        Curso curso = cursoService.getCursoById(id);

        while(curso.getNome() == null){
            System.out.println("");
            System.out.println("Nenhum curso com o id = " + id + " encontrado!");
            System.out.println("");
            System.out.println("Entre com o id válido: ");
            id = input.inputInteger();
            curso = cursoService.getCursoById(id);
        }

        String matricula = input.inputMatricula();
        Aluno aluno = alunoService.getAlunoByMatricula(matricula);

        List<Curso> cursos = alunoService.getCursosByMatricula(matricula);

        if(cursos.get(0).getId().equals(curso.getId()) || cursos.get(1).getId().equals(curso.getId())){
            System.out.println("");
            System.out.println("Aluno já cadastrado no curso de " + curso.getNome());
            System.out.println("");
        }else if(cursos.size() == 2){
            System.out.println("");
            System.out.println("Limite de 2 cursos atingido! ");
            System.out.println("");
        }else{
            alunoService.addCurso(aluno, curso);
            System.out.println("Aluno incluido no curso de " + curso.getNome());
        }

    }

    @Override
    public void showAllAlunos(){
        System.out.println("");
        System.out.println("Alunos: ");
        System.out.println("");

        List<Aluno> alunos = alunoService.getAllAluno();

        if(alunos.isEmpty()){
            System.out.println("Nenhum aluno cadastrado!");
        } else {
            alunos.forEach(aluno -> System.out.println(aluno));
        }

        System.out.println("");
    }

    @Override
    public void createAlunoDisciplina(){
        System.out.println("");
        System.out.println("Incluindo um aluno em uma disciplina...");
        System.out.println("");

        System.out.println("");
        disciplinaFuncionality.showAllDisciplinas();
        System.out.println("");

        System.out.println("Entre com o id da disciplina: ");
        Integer id = input.inputInteger();

        Disciplina disciplina = disciplinaService.getDisciplinaById(id);

        while(disciplina.getNome() == null){
            System.out.println("");
            System.out.println("Nenhuma disciplina com o id = " + id + " encontrado!");
            System.out.println("");
            System.out.println("Entre com o id válido: ");
            id = input.inputInteger();
            disciplina = disciplinaService.getDisciplinaById(id);
        }

        String matricula = input.inputMatricula();
        Aluno aluno = alunoService.getAlunoByMatricula(matricula);

        alunoService.addDisciplina(aluno, disciplina);
    }

}
