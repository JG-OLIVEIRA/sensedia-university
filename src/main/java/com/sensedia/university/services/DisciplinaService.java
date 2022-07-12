package com.sensedia.university.services;

import com.sensedia.university.models.Disciplina;

import java.util.List;

public interface DisciplinaService {
    Disciplina createDisciplina(Disciplina disciplina);
    List<Disciplina> getAllDisciplina();
    Disciplina getDisciplinaById(Integer id);
}
