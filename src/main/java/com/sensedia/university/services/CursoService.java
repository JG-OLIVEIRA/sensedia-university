package com.sensedia.university.services;

import com.sensedia.university.models.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoService {
    Curso createCurso(Curso curso);
    Curso getCursoByNome(String nome);
    Curso getCursoById(Integer id);
    List<Curso> getAllCurso();
}
