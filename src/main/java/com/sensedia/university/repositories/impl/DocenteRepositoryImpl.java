package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Aluno;
import com.sensedia.university.models.Docente;
import com.sensedia.university.repositories.DocenteRepository;

import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Docente> getAllDocente() {
        List<Docente> docentes = new ArrayList<>();

        try(Connection connection = ConnectionFactory.createConnection()){

            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM docente");

            ResultSet result = statement.getResultSet();

            while(result.next()){
                Docente docente = new Docente();

                Integer id = result.getInt("ID");
                String nome = result.getString("NOME");
                String sobrenome = result.getString("SOBRENOME");
                String matricula = result.getString("MATRICULA");
                Integer ano = result.getInt("ANO");

                docente.setId(id);
                docente.setNome(nome);
                docente.setSobrenome(sobrenome);
                docente.setMatricula(matricula);
                docente.setAno(ano);

                docentes.add(docente);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return docentes;
    }


}
