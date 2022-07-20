package com.sensedia.university.services.impl;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.AlunoRepository;
import com.sensedia.university.repositories.impl.AlunoRepositoryImpl;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.utils.Generation;

import java.util.Calendar;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {
    AlunoRepository alunoRepository = new AlunoRepositoryImpl();

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
    public List<Aluno> getAllAluno() {
        return alunoRepository.getAllAluno();
    }

    @Override
    public Aluno getAlunoByMatricula(String matricula) {
        return alunoRepository.getAlunoByMatricula(matricula);
    }

    @Override
    public List<Curso> getCursosByMatricula(String matricula) {
        return alunoRepository.getCursosByMatricula(matricula);
    }

    @Override
    public void addCurso(Aluno aluno, Curso curso) {
        alunoRepository.addCurso(aluno, curso);
    }

    @Override
    public void addDisciplina(Aluno aluno, Disciplina disciplina) {
        alunoRepository.addDisciplina(aluno, disciplina);
    }
}
