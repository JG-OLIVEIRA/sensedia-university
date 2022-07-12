package com.sensedia.university.services;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.models.Disciplina;

import java.util.List;

public interface AlunoService {
    Aluno createAluno(Aluno aluno);
    List<Aluno> getAllAluno();
    Aluno getAlunoByMatricula(String matricula);
    List<Curso> getCursosByMatricula(String matricula);
    void addCurso(Aluno aluno, Curso curso);
    void addDisciplina(Aluno aluno, Disciplina disciplina);
}
