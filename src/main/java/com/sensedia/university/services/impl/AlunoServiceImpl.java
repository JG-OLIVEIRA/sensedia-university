package com.sensedia.university.services.impl;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.repositories.impl.AlunoRepositoryImpl;
import com.sensedia.university.services.AlunoService;

import java.util.Calendar;
import java.util.Random;

import static java.lang.Math.round;

public class AlunoServiceImpl implements AlunoService {
    AlunoRepositoryImpl alunoRepository = new AlunoRepositoryImpl();

    @Override
    public Aluno createAluno(Aluno aluno) {
        Calendar calendar = Calendar.getInstance();
        Random random = new Random();

        Integer ano = calendar.get(Calendar.YEAR) + 1;
        String matricula = ano + String.valueOf(round(random.nextDouble() * 100000));

        aluno.setAno(ano);
        aluno.setMatricula(matricula);

        return alunoRepository.createAluno(aluno);
    }
}
