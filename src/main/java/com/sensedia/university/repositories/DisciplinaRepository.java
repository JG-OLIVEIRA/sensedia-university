package com.sensedia.university.repositories;

import com.sensedia.university.models.Disciplina;

import java.util.List;

public interface DisciplinaRepository {
    Disciplina createDisciplina(Disciplina disciplina);
    List<Disciplina> getAllDisciplina();
    Disciplina getDisciplinaById(Integer id);
}
