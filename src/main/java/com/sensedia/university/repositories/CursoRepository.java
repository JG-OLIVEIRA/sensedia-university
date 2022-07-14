package com.sensedia.university.repositories;

import com.sensedia.university.models.Curso;

import java.util.List;

public interface CursoRepository {
    Curso createCurso(Curso curso);
    Curso getCursoById(Integer id);
    Curso getCursoByName(String name);
    List<Curso> getAllCurso();
}
