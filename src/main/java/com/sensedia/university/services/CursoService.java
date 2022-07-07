package com.sensedia.university.services;

import com.sensedia.university.models.Curso;

import java.util.List;

public interface CursoService {
    Curso createCurso(Curso curso);
    Curso getCursoById(Integer id);
    List<Curso> getAllCurso();
}
