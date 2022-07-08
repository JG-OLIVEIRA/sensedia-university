package com.sensedia.university.repositories;

import com.sensedia.university.models.Docente;

import java.util.List;

public interface DocenteRepository {

    Docente createDocente(Docente docente);
    List<Docente> getAllDocente();
}
