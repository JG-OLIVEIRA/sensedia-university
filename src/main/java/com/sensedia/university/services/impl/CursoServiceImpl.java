package com.sensedia.university.services.impl;

import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.impl.CursoRepositoryImpl;
import com.sensedia.university.services.CursoService;

import java.sql.SQLException;
import java.util.List;

public class CursoServiceImpl implements CursoService {

    CursoRepositoryImpl cursoRepository = new CursoRepositoryImpl();

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.createCurso(curso);
    }

    @Override
    public Curso getCursoById(Integer id) {
        return cursoRepository.getCursoById(id);
    }

    @Override
    public List<Curso> getAllCurso() {
        return cursoRepository.getAllCurso();
    }

}
