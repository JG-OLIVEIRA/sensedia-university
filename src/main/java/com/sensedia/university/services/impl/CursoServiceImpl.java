package com.sensedia.university.services.impl;

import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.impl.CursoRepositoryImpl;
import com.sensedia.university.services.CursoService;

public class CursoServiceImpl implements CursoService {

    CursoRepositoryImpl cursoRepository = new CursoRepositoryImpl();

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.createCurso(curso);
    }
}
