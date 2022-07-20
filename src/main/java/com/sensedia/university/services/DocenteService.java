package com.sensedia.university.services;

import com.sensedia.university.models.Disciplina;
import com.sensedia.university.models.Docente;

import java.util.List;

public interface DocenteService {
    Docente createDocente(Docente docente);
    List<Docente> getAllDocente();
    void addDisciplina(Docente docente, Disciplina disciplina);
    Docente getDocenteByMatricula(String matricula);
}
