package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.DisciplinaRepository;

import java.sql.*;

public class DisciplinaRepositoryImpl implements DisciplinaRepository {

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO disciplina (NOME, SALA) values (?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setString(1, disciplina.getNome());
            myStat.setInt(2, disciplina.getSala());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                disciplina.setId(result.getInt(1));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplina;
    }
}
