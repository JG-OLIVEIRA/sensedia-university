package com.sensedia.university.repositories.impl;

import com.sensedia.university.factory.ConnectionFactory;
import com.sensedia.university.models.Disciplina;
import com.sensedia.university.repositories.DisciplinaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepositoryImpl implements DisciplinaRepository {

    @Override
    public Disciplina createDisciplina(Disciplina disciplina) {
        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "INSERT INTO disciplina (NOME, TURNO, SALA) values (?, ?, ?)";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setString(1, disciplina.getNome());
            myStat.setString(2, disciplina.getTurno());
            myStat.setInt(3, disciplina.getSala());

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

    @Override
    public List<Disciplina> getAllDisciplina() {
        List<Disciplina> disciplinas = new ArrayList<>();

        try(Connection connection = ConnectionFactory.createConnection()){

            Statement statement = connection.createStatement();

            statement.execute("SELECT * FROM disciplina");

            ResultSet result = statement.getResultSet();

            while(result.next()){
                Disciplina disciplina = new Disciplina();

                Integer id = result.getInt("ID");
                String nome = result.getString("NOME");
                String turno = result.getString("TURNO");
                Integer sala = result.getInt("SALA");

                disciplina.setId(id);
                disciplina.setNome(nome);
                disciplina.setTurno(turno);
                disciplina.setSala(sala);

                disciplinas.add(disciplina);
            }



        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplinas;
    }

    @Override
    public Disciplina getDisciplinaById(Integer id) {
        Disciplina disciplina = new Disciplina();

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "SELECT * FROM disciplina WHERE id = ?";

            PreparedStatement myStat = connection.prepareStatement(query);

            myStat.setInt(1, id);

            myStat.execute();

            ResultSet result = myStat.getResultSet();

            if(result.next()){
                String nome = result.getString("NOME");
                String turno = result.getString("TURNO");
                Integer sala = result.getInt("SALA");
                disciplina.setNome(nome);
                disciplina.setTurno(turno);
                disciplina.setSala(sala);
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        disciplina.setId(id);

        return disciplina;
    }

    @Override
    public Disciplina updateDisciplinaById(Disciplina disciplina) {

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "UPDATE SET disciplina (NOME, TURNO, SALA) values (?, ?, ?) WHERE id = ?";

            PreparedStatement myStat = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            myStat.setString(1, disciplina.getNome());
            myStat.setString(2, disciplina.getTurno());
            myStat.setInt(3, disciplina.getSala());
            myStat.setInt(4, disciplina.getId());

            myStat.executeUpdate();

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplina;
    }
}
