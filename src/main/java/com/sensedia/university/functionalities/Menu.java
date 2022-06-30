package com.sensedia.university.functionalities;

import com.sensedia.university.exceptions.InvalidInput;
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

    public void showInsertOptions(){
        System.out.println("Escolhas as opções abaixo: ");
        System.out.println("");
        System.out.println("1 - Matricular um aluno");
        System.out.println("2 - Matricular um docente");
        System.out.println("3 - Incluir um curso");
        System.out.println("4 - Incluir uma disciplina");
        System.out.println("");
    }

    public Integer inputInsertOptions(){
        System.out.println("");
        System.out.println("Digite a opção: ");

        String option;

        while (true){
            option = scanner.next();

            try {
                return CheckIntegerInput.verify(option);
            } catch (InvalidInput ex){
                System.out.println(ex.getMessage());
                System.out.println("");
                System.out.println("Digite uma opção válida:  ");
            }
        }

    }

    public void createAluno(){
        Aluno aluno = new Aluno();

        System.out.println("Nome:");
        String nome = scanner.next();
        System.out.println("Sobrenome:");
        String sobrenome = scanner.next();

        aluno.setNome(nome);
        aluno.setSobrenome(sobrenome);

        aluno = alunoService.createAluno(aluno);

        System.out.println(aluno);
    }

    public void createDocente(){
        Docente docente = new Docente();

        System.out.println("Nome:");
        String nome = scanner.next();
        System.out.println("Sobrenome:");
        String sobrenome = scanner.next();

        docente.setNome(nome);
        docente.setSobrenome(sobrenome);

        docente = docenteService.createDocente(docente);

        System.out.println(docente);
    }

    public void createCurso(){
        Curso curso = new Curso();

        System.out.println("Nome:");
        String nome = scanner.next();

        curso.setNome(nome);

        curso = cursoService.createCurso(curso);

        System.out.println(curso);
    }

    public void createDisciplina(){
        Disciplina disciplina = new Disciplina();

        System.out.println("Nome:");
        String nome = scanner.next();

        System.out.println("Turno:");
        String turno = scanner.next();

        System.out.println("Sala:");
        Integer sala = scanner.nextInt();

        disciplina.setNome(nome);
        disciplina.setTurno(turno);
        disciplina.setSala(sala);

        disciplina = disciplinaService.createDisciplina(disciplina);

        System.out.println(disciplina);
    }
}
