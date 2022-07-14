package com.sensedia.university.repositories.impl;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Curso;
import com.sensedia.university.repositories.CursoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryImpl implements CursoRepository {

    @Override
    public Curso createCurso(Curso curso) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO curso (NOME) values (?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setString(1, curso.getNome());

            myStat.executeUpdate();

            ResultSet result = myStat.getGeneratedKeys();

            if(result.next()){
                curso.setId(result.getInt(1));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return curso;
    }

    @Override
    public Curso getCursoById(Integer id) {
        Curso curso = new Curso();

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "SELECT * FROM curso WHERE id = ?";

            PreparedStatement myStat = connection.prepareStatement(query);

            myStat.setInt(1, id);

            myStat.execute();

            ResultSet result = myStat.getResultSet();

            if(result.next()){
                String nome = result.getString("NOME");
                curso.setNome(nome);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        curso.setId(id);

        return curso;
    }

    @Override
    public List<Curso> getAllCurso() {
        List<Curso> cursos = new ArrayList<>();

        try(Connection connection = ConnectionFactory.createConnection()){

            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM curso");

            ResultSet result = statement.getResultSet();

            while(result.next()){
                Curso curso = new Curso();

                Integer id = result.getInt("ID");
                String nome = result.getString("NOME");

                curso.setId(id);
                curso.setNome(nome);

                cursos.add(curso);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return cursos;
    }


}
