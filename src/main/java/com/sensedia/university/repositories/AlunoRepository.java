package com.sensedia.university.repositories;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;

import java.util.List;

public interface AlunoRepository {
    Aluno createAluno(Aluno aluno);
    List<Aluno> getAllAluno();
    Integer getCountOfCursoByAluno(Aluno aluno);
    Aluno getAlunoByMatricula(String matricula);
    void addCurso(Aluno aluno, Curso curso);
}
