package com.sensedia.university.services.impl;

import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.impl.DisciplinaRepositoryImpl;
import com.sensedia.university.services.DisciplinaService;

import java.util.List;

public class DisciplinaServiceImpl implements DisciplinaService {

    DisciplinaRepositoryImpl disciplinaRepository = new DisciplinaRepositoryImpl();

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        return disciplinaRepository.createDisciplina(disciplina);
    }

    @Override
    public List<Disciplina> getAllDisciplina() {
        return disciplinaRepository.getAllDisciplina();
    }

    @Override
    public Disciplina getDisciplinaById(Integer id) {
        return disciplinaRepository.getDisciplinaById(id);
    }

    @Override
    public Disciplina updateDisciplinaById(Disciplina disciplina) {
        return disciplinaRepository.updateDisciplinaById(disciplina);
    }
}
