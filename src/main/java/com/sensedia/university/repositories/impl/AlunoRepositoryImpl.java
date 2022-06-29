package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Aluno;
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
}
