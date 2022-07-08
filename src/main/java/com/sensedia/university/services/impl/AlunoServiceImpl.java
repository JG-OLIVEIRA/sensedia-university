package com.sensedia.university.services.impl;

import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.impl.AlunoRepositoryImpl;
import com.sensedia.university.services.AlunoService;
import com.sensedia.university.utils.Generation;

import java.util.Calendar;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {
    AlunoRepositoryImpl alunoRepository = new AlunoRepositoryImpl();

    @Override
    public Aluno createAluno(Aluno aluno) {
        Calendar calendar = Calendar.getInstance();

        Integer ano = calendar.get(Calendar.YEAR) + 1;

        String matricula = Generation.getMatricula();

        aluno.setAno(ano);
        aluno.setMatricula(matricula);

        return alunoRepository.createAluno(aluno);
    }

    @Override
    public List<Aluno> getAllAluno() {
        return alunoRepository.getAllAluno();
    }

    @Override
    public Aluno getAlunoByMatricula(String matricula) {
        return alunoRepository.getAlunoByMatricula(matricula);
    }

    @Override
    public void addCurso(Aluno aluno, Curso curso) {
        Integer count = alunoRepository.getCountOfCursoByAluno(aluno);

        if(count > 2){
            System.out.println("");
            System.out.println("O aluno atingiu a contagem máxima de cursos (2)");
            System.out.println("");
        } else {
            alunoRepository.addCurso(aluno, curso);

            System.out.println("");
            System.out.println("Aluno " + aluno.getNome() + " incluido no curso de " + curso.getNome());
            System.out.println("");
        }

    }
}
