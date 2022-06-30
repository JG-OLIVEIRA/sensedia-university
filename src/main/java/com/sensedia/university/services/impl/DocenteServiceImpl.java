package com.sensedia.university.services.impl;

import com.sensedia.university.models.Docente;
import com.sensedia.university.repositories.DocenteRepository;
import com.sensedia.university.repositories.impl.DocenteRepositoryImpl;
import com.sensedia.university.services.DocenteService;
import com.sensedia.university.utils.Generation;

import java.util.Calendar;

public class DocenteServiceImpl implements DocenteService {
    DocenteRepository docenteRepository = new DocenteRepositoryImpl();

    @Override
    public Docente createDocente(Docente docente) {
        Calendar calendar = Calendar.getInstance();

        Integer ano = calendar.get(Calendar.YEAR) + 1;

        String matricula = Generation.getMatricula();

        docente.setAno(ano);
        docente.setMatricula(matricula);

        return docenteRepository.createDocente(docente);
    }
}
