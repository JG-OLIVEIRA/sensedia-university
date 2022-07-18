package com.sensedia.university.functionalities;

import com.sensedia.university.exceptions.EmptyInput;
import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.exceptions.InvalidOption;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.utils.CheckIntegerInput;

import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    AlunoService alunoService = new AlunoServiceImpl();

    public String inputString(){
        String campo = scanner.nextLine();

        while(campo.isBlank()){
            System.out.println("Campo vazio, digite novamente: ");
            campo = scanner.nextLine();
        }

        return campo;
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

        return matricula;
    }

    public Integer inputInteger() {
        System.out.println("");
        System.out.println("Digite a opção: ");

        while (true) {

            String input = scanner.next();

            try {

                if (input.isEmpty()) {
                    throw new EmptyInput();
                }

                Integer inputInteger = CheckIntegerInput.verify(input);

                return inputInteger;

            } catch (InvalidInput | EmptyInput ex) {

                if (ex.getClass() == EmptyInput.class) {
                    System.out.println("Campo vazio!");
                } else {
                    System.out.println("Digite uma opção válida:  ");
                }

            }

        }

    }

    public Integer inputIntegerWithRange(Integer maxRange){
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

}
