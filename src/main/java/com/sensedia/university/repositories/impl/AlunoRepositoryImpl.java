package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.repositories.AlunoRepository;

import java.sql.*;

public class AlunoRepositoryImpl implements AlunoRepository {

    @Override
    public Aluno createAluno(Aluno aluno) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO aluno (ID, NOME, SOBRENOME, MATRICULA, ANO) values (?, ?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setInt(1,  aluno.getId());
            myStat.setString(2, aluno.getNome());
            myStat.setString(3, aluno.getSobrenome());
            myStat.setString(4, aluno.getMatricula());
            myStat.setInt(5, aluno.getAno());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                aluno.setId(result.getInt(1));
                aluno.setNome(result.getString(2));
                aluno.setSobrenome(result.getString(3));
                aluno.setMatricula(result.getString(4));
                aluno.setAno(result.getInt(result.getInt(5)));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return aluno;
    }
}
