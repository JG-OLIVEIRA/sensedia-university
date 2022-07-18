package com.sensedia.university.functionalities;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.models.Docente;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.CursoService;
import com.sensedia.university.services.DisciplinaService;
import com.sensedia.university.services.DocenteService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.services.impl.CursoServiceImpl;
import com.sensedia.university.services.impl.DisciplinaServiceImpl;
import com.sensedia.university.services.impl.DocenteServiceImpl;

import java.util.List;

public class Menu {

    AlunoService alunoService = new AlunoServiceImpl();
    DocenteService docenteService = new DocenteServiceImpl();
    CursoService cursoService = new CursoServiceImpl();
    DisciplinaService disciplinaService = new DisciplinaServiceImpl();

    Input input = new Input();

    public void showWelcomeMessage(){
        System.out.println("");
        System.out.println("Bem vindo a Sensedia University");
        System.out.println("");
    }

    public Integer showMenuOptions(){
        System.out.println("Escolhas as opções abaixo: ");
        System.out.println("");
        System.out.println("1 - Aluno");
        System.out.println("2 - Docente");
        System.out.println("3 - Curso");
        System.out.println("4 - Disciplina");
        System.out.println("5 - Sair da aplicação");
        System.out.println("");

        return input.inputIntegerWithRange(5);
    }

    public void showAlunoOptions(){
        System.out.println("");
        System.out.println("Aluno");
        System.out.println("");
        System.out.println("1 - Matricular um aluno");
        System.out.println("2 - Incluir um aluno em um curso");
        System.out.println("3 - Voltar ao menu");
        System.out.println("4 - Visualizar todos os alunos");
        System.out.println("5 - Visualizar todos os curso pela matricula do aluno");
        System.out.println("6 - Incluir um aluno em uma disciplina");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(6);

        switch (option) {
            case 1:
                createAluno();
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
                showCursosByMatricula(matricula);
                break;
            case 6:
                createAlunoDisciplina();
                break;
        }
    }

    public void showDocenteOptions(){
        System.out.println("");
        System.out.println("Docente");
        System.out.println("");
        System.out.println("1 - Matricular um docente");
        System.out.println("2 - Voltar ao menu");
        System.out.println("3 - Mostrar todos os docentes");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(3);

        switch (option) {
            case 1:
                createDocente();
                break;
            case 2:
                break;
            case 3:
                showAllDocentes();
                break;
        }
    }

    public void showCursoOptions(){
        System.out.println("");
        System.out.println("Curso");
        System.out.println("");
        System.out.println("1 - Incluir curso");
        System.out.println("2 - Visualizar todos os curso");
        System.out.println("3 - Voltar ao menu");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(3);

        switch (option) {
            case 1:
                createCurso();
                break;
            case 2:
                showAllCursos();
                break;
            case 3:
                showMenuOptions();
                break;
        }

    }

    public void showDisciplinaOptions(){
        System.out.println("");
        System.out.println("Disciplina");
        System.out.println("");
        System.out.println("1 - Incluir disciplina");
        System.out.println("2 - Voltar ao menu");
        System.out.println("3 - Visualizar disciplinas");
        System.out.println("");

        Integer option = input.inputIntegerWithRange(3);

        switch (option) {
            case 1:
                createDisciplina();
                break;
            case 2:
                break;
            case 3:
                showAllDisciplinas();
                break;
        }

    }

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

    public void createAluno(){
        Aluno aluno = new Aluno();

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

    public void createDocente(){
        Docente docente = new Docente();

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

    public void createCurso(){
        Curso curso = new Curso();

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

    public void createDisciplina(){
        Disciplina disciplina = new Disciplina();

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

    public void createAlunoCurso(){
        System.out.println("");
        System.out.println("Incluino um aluno em um curso...");
        System.out.println("");

        showAllCursos();
        System.out.println("");

        System.out.println("Entre com o id do curso: ");
        Integer id = input.inputInteger();

        String matricula = input.inputMatricula();
        Aluno aluno = alunoService.getAlunoByMatricula(matricula);

        Curso curso = cursoService.getCursoById(id);

        alunoService.addCurso(aluno, curso);
    }

    public void createAlunoDisciplina(){
        System.out.println("");
        System.out.println("Incluino um aluno em um curso...");
        System.out.println("");

        showAllDisciplinas();
        System.out.println("");

        System.out.println("Entre com o id da disciplina: ");
        Integer id = input.inputInteger();

        String matricula = input.inputMatricula();
        Aluno aluno = alunoService.getAlunoByMatricula(matricula);

        Disciplina disciplina = disciplinaService.getDisciplinaById(id);

        alunoService.addDisciplina(aluno, disciplina);
    }

}
