package com.sensedia.university.functionalities;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.exceptions.InvalidOption;
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
import com.sensedia.university.utils.CheckIntegerInput;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    AlunoService alunoService = new AlunoServiceImpl();
    DocenteService docenteService = new DocenteServiceImpl();
    CursoService cursoService = new CursoServiceImpl();
    DisciplinaService disciplinaService = new DisciplinaServiceImpl();

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

        return inputInteger(5);
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
        System.out.println("");

        Integer option = inputInteger(5);

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
                String matricula = inputMatricula();
                showCursosByMatricula(matricula);
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

        Integer option = inputInteger(3);

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

        Integer option = inputInteger(3);

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

        Integer option = inputInteger(3);

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
        docenteService.getAllDocente().forEach(docente -> System.out.println(docente));
        System.out.println("");
    }

    public void showAllCursos(){
        System.out.println("");
        System.out.println("Cursos: ");
        System.out.println("");
        cursoService.getAllCurso().forEach(curso -> System.out.println(curso));
        System.out.println("");
    }

    public void showCursosByMatricula(String matricula){
        System.out.println("");
        System.out.println("Cursos: ");
        System.out.println("");
        alunoService.getCursosByMatricula(matricula).forEach(curso -> System.out.println(curso));
        System.out.println("");
    }

    public void showAllAlunos(){
        System.out.println("");
        System.out.println("Alunos: ");
        System.out.println("");
        alunoService.getAllAluno().forEach(aluno -> System.out.println(aluno));
        System.out.println("");
    }

    public void showAllDisciplinas(){
        System.out.println("");
        System.out.println("Disciplinas: ");
        System.out.println("");
        disciplinaService.getAllDisciplina().forEach(disciplina -> System.out.println(disciplina));
        System.out.println("");
    }

    public Integer inputInteger(Integer maxRange){
        System.out.println("");
        System.out.println("Digite a opção: ");

        String input;

        while (true){

            input = scanner.nextLine();

            try {

                Integer inputInteger = CheckIntegerInput.verify(input);

                if(inputInteger > maxRange || inputInteger < 1){
                    throw new InvalidOption();
                }

                return inputInteger;

            } catch (InvalidInput | InvalidOption ex) {
                System.out.println(ex.getMessage());
                System.out.println("");
                System.out.println("Digite uma opção válida:  ");
            }

        }

    }

    public String inputMatricula(){
        Aluno aluno;
        String matricula;

        System.out.println("Entre com a matricula: ");
        matricula = scanner.next();

        aluno = alunoService.getAlunoByMatricula(matricula);

        while (aluno.getId() == null){
            System.out.println("Entre com uma matricula válida: ");
            matricula = scanner.next();

            aluno = alunoService.getAlunoByMatricula(matricula);
        }

        scanner.nextLine();

        return matricula;
    }

    public void createAluno(){
        Aluno aluno = new Aluno();

        System.out.println("");
        System.out.println("Matriculando um aluno...");
        System.out.println("");
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        System.out.println("Sobrenome:");
        String sobrenome = scanner.nextLine();

        scanner.nextLine();

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
        String nome = scanner.nextLine();
        System.out.println("Sobrenome:");
        String sobrenome = scanner.nextLine();

        scanner.nextLine();

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
        String nome = scanner.nextLine();

        curso.setNome(nome);

        curso = cursoService.createCurso(curso);

        scanner.nextLine();

        System.out.println(curso);
    }

    public void createDisciplina(){
        Disciplina disciplina = new Disciplina();

        System.out.println("");
        System.out.println("Incluino uma disciplina...");
        System.out.println("");
        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Turno:");
        String turno = scanner.next();

        System.out.println("Sala:");
        Integer sala = scanner.nextInt();

        scanner.nextLine();

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
        Integer id = scanner.nextInt();

        String matricula = inputMatricula();
        Aluno aluno = alunoService.getAlunoByMatricula(matricula);

        scanner.nextLine();

        Curso curso = cursoService.getCursoById(id);

        alunoService.addCurso(aluno, curso);
    }
}
