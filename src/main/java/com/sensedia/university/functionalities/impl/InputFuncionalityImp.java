package com.sensedia.university.functionalities.impl;

import com.sensedia.university.exceptions.EmptyInput;
import com.sensedia.university.exceptions.InvalidInput;
import com.sensedia.university.exceptions.InvalidOption;
import com.sensedia.university.functionalities.InputFuncionality;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.services.impl.AlunoServiceImpl;
import com.sensedia.university.utils.CheckIntegerInput;

import java.util.Scanner;

public class InputFuncionalityImp implements InputFuncionality {

    Scanner scanner = new Scanner(System.in);

    AlunoService alunoService = new AlunoServiceImpl();

    @Override
    public String inputString(Integer limit){
        String campo = scanner.nextLine();

        while(true){

            if(campo.isBlank()){
                System.out.println("Campo vazio, digite novamente: ");
                campo = scanner.nextLine();
            } else if (campo.length() > limit) {
                System.out.println("Campo limite de " + limit + " digite novamente: ");
                campo = scanner.nextLine();
            } else {
                break;
            }

        }

        return campo;
    }

    @Override
    public String inputMatricula(){
        Aluno aluno;
        String matricula;

        System.out.println("Entre com a matricula: ");
        matricula = scanner.next();

        aluno = alunoService.getAlunoByMatricula(matricula);

        while (aluno.getId() == null){
            System.out.println("Entre com uma matricula válida: ");
            matricula = scanner.nextLine();

            aluno = alunoService.getAlunoByMatricula(matricula);
        }

        return matricula;
    }

    @Override
    public Integer inputInteger() {

        while (true) {

            String input = scanner.nextLine();

            try {

                if (input.isEmpty()) {
                    throw new EmptyInput();
                }

                Integer inputInteger = CheckIntegerInput.verify(input);

                if(inputInteger < 0){
                    throw new InvalidInput();
                }

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

    @Override
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
