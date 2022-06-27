package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.CursoRepository;

import java.sql.*;

public class CursoRepositoryImpl implements CursoRepository {

    @Override
    public Curso createCurso(Curso curso) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO curso (ID, NOME) values (?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setInt(1,  curso.getId());
            myStat.setString(2, curso.getNome());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                curso.setId(result.getInt(1));
                curso.setNome(result.getString(2));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return curso;
    }
}
