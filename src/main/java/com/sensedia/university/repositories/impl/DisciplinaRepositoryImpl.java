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

            while(result.next()){
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

                disciplina.setId(result.getInt("ID"));
                disciplina.setNome(result.getString("NOME"));
                disciplina.setTurno(result.getString("TURNO"));
                disciplina.setSala(result.getInt("SALA"));

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

            while(result.next()){
                disciplina.setId(result.getInt("ID"));
                disciplina.setNome(result.getString("NOME"));
                disciplina.setTurno(result.getString("TURNO"));
                disciplina.setSala(result.getInt("SALA"));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplina;
    }

    @Override
    public Disciplina getDisciplinaByNome(String nome) {
        Disciplina disciplina = new Disciplina();

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "SELECT * FROM disciplina WHERE nome = ?";

            PreparedStatement myStat = connection.prepareStatement(query);

            myStat.setString(1, nome);

            myStat.execute();

            ResultSet result = myStat.getResultSet();

            while(result.next()){
                disciplina.setId(result.getInt("ID"));
                disciplina.setNome(result.getString("NOME"));
                disciplina.setTurno(result.getString("TURNO"));
                disciplina.setSala(result.getInt("SALA"));
            }

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return disciplina;
    }

    @Override
    public Disciplina updateDisciplinaById(Disciplina disciplina) {

        try(Connection connection = ConnectionFactory.createConnection()){

            String query = "UPDATE disciplina set nome = ?, turno = ?, sala = ? WHERE id = ?";

            PreparedStatement myStat = connection.prepareStatement(query);

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
