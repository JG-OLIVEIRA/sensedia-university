package com.sensedia.university.services.impl;

import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.impl.DisciplinaRepositoryImpl;
import com.sensedia.university.services.DisciplinaService;

public class DisciplinaServiceImpl implements DisciplinaService {

    DisciplinaRepositoryImpl disciplinaRepository = new DisciplinaRepositoryImpl();

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        return disciplinaRepository.createDisciplina(disciplina);
    }
}
