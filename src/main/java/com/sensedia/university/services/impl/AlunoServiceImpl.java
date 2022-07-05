package com.sensedia.university.services.impl;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.impl.AlunoRepositoryImpl;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.utils.Generation;

import java.util.Calendar;

public class AlunoServiceImpl implements AlunoService {
    AlunoRepositoryImpl alunoRepository = new AlunoRepositoryImpl();

    @Override
    public Aluno createAluno(Aluno aluno) {
        Calendar calendar = Calendar.getInstance();

        Integer ano = calendar.get(Calendar.YEAR) + 1;

        String matricula = Generation.getMatricula();

        aluno.setAno(ano);
        aluno.setMatricula(matricula);

        return alunoRepository.createAluno(aluno);
    }

    @Override
    public Aluno getAlunoByMatricula(String matricula) {
        return alunoRepository.getAlunoByMatricula(matricula);
    }

    @Override
    public void addCurso(Aluno aluno, Curso curso) {
        alunoRepository.addCurso(aluno, curso);
    }
}
