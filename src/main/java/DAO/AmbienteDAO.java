package DAO;

import database.ConnectionFactory;
import model.Ambiente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class AmbienteDAO {

    public void salvar(Ambiente ambiente) {
        String sql = "INSERT INTO ambiente(nome) VALUES (?)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, ambiente.getNome());
            stmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ambiente> listarTodos() {
        List<Ambiente> ambientes = new ArrayList<>();

        String sql = "SELECT idAmbiente, nome FROM ambiente ORDER BY nome";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Ambiente ambiente = new Ambiente(
                        rs.getInt("idAmbiente"),
                        rs.getString("nome")
                );

                ambientes.add(ambiente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ambientes;
    }
}