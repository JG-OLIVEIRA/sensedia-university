package com.sensedia.university.repositories;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.models.Disciplina;

import java.util.List;

public interface AlunoRepository {
    Aluno createAluno(Aluno aluno);
    List<Aluno> getAllAluno();
    Integer getCountOfCursoByAluno(Aluno aluno);
    List<Curso> getCursosByMatricula(String matricula);
    Aluno getAlunoByMatricula(String matricula);
    void addCurso(Aluno aluno, Curso curso);
    void addDisciplina(Aluno aluno, Disciplina disciplina);
}
