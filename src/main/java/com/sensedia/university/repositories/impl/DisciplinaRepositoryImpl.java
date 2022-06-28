package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.DisciplinaRepository;

import java.sql.*;

public class DisciplinaRepositoryImpl implements DisciplinaRepository {

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO disciplina (ID, NOME, SALA) values (?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setInt(1, disciplina.getId());
            myStat.setString(2, disciplina.getNome());
            myStat.setInt(3, disciplina.getSala());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                disciplina.setId(result.getInt(1));
                disciplina.setNome(result.getString(2));
                disciplina.setSala(result.getInt(3));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplina;
    }
}
