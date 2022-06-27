package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Docente;
import com.sensedia.university.repositories.DocenteRepository;

import java.sql.*;

public class DocenteRepositoryImpl implements DocenteRepository {

    @Override
    public Docente createDocente(Docente docente) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO docente (ID, NOME, SOBRENOME, MATRICULA, ANO) values (?, ?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setInt(1, docente.getId());
            myStat.setString(2, docente.getNome());
            myStat.setString(3, docente.getSobrenome());
            myStat.setString(4, docente.getMatricula());
            myStat.setInt(5, docente.getAno());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                docente.setId(result.getInt(1));
                docente.setNome(result.getString(2));
                docente.setSobrenome(result.getString(3));
                docente.setMatricula(result.getString(4));
                docente.setAno(result.getInt(5));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return docente;
    }
}
