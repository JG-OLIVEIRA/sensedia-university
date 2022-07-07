package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.AlunoRepository;

import java.sql.*;

public class AlunoRepositoryImpl implements AlunoRepository {

    @Override
    public Aluno createAluno(Aluno aluno) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO aluno (NOME, SOBRENOME, MATRICULA, ANO) values (?, ?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setString(1, aluno.getNome());
            myStat.setString(2, aluno.getSobrenome());
            myStat.setString(3, aluno.getMatricula());
            myStat.setInt(4, aluno.getAno());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                aluno.setId(result.getInt(1));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return aluno;
    }

    @Override
    public Aluno getAlunoByMatricula(String matricula){

        Aluno aluno = new Aluno();

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "SELECT * FROM aluno WHERE matricula = ?";

            PreparedStatement myStat = connection.prepareStatement(query);

            myStat.setString(1, matricula);

            myStat.execute();

            ResultSet result = myStat.getResultSet();

            if(result.next()){
                Integer id = result.getInt("ID");
                String nome = result.getString("NOME");
                String sobrenome = result.getString("SOBRENOME");
                Integer ano = result.getInt("ANO");

                aluno.setId(id);
                aluno.setNome(nome);
                aluno.setSobrenome(sobrenome);
                aluno.setAno(ano);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return aluno;
    }

    public void addCurso(Aluno aluno, Curso curso){
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO aluno_curso (ALUNO_ID, CURSO_ID) values (?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setInt(1, aluno.getId());
            myStat.setInt(2, curso.getId());

            myStat.execute();

        } catch (SQLException ex){
            ex.printStackTrace();
        }

    }
}
