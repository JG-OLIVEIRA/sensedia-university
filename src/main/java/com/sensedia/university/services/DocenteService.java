package com.sensedia.university.services;

import com.sensedia.university.models.Docente;

import javax.print.Doc;
import java.util.List;

public interface DocenteService {
    Docente createDocente(Docente docente);
    List<Docente> getAllDocente();
}
