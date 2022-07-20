package com.sensedia.university.functionalities;

import com.sensedia.university.models.Curso;

public interface CursoFuncionality {
    void showCursoOptions();
    void createCurso(Curso curso);
    void showAllCursos();
    void showCursosByMatricula(String matricula);
}
