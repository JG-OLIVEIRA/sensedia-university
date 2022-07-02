package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Docente;
import com.sensedia.university.repositories.DocenteRepository;

import java.sql.*;

public class DocenteRepositoryImpl implements DocenteRepository {

    @Override
    public Docente createDocente(Docente docente) {

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO docente (NOME, SOBRENOME, MATRICULA, ANO) values (?, ?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            System.out.println(docente.getSobrenome());

            myStat.setString(1, docente.getNome());
            myStat.setString(2, docente.getSobrenome());
            myStat.setString(3, docente.getMatricula());
            myStat.setInt(4, docente.getAno());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                docente.setId(result.getInt(1));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return docente;
    }
}
