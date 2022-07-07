package com.sensedia.university.services;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.services.impl.AlunoServiceImpl;

import java.util.List;

public interface AlunoService {
    Aluno createAluno(Aluno aluno);
    List<Aluno> getAllAluno();
    Aluno getAlunoByMatricula(String matricula);
    void addCurso(Aluno aluno, Curso curso);
}
