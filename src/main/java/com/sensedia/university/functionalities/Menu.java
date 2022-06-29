package com.sensedia.university.functionalities;

import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.utils.CheckIntegerInput;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    AlunoService alunoService = new AlunoServiceImpl();

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

}
