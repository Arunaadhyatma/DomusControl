package DAO;

import database.ConnectionFactory;
import model.Ambiente;
import model.Dispositivo;
import model.TipoDispositivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DispositivoDAO {

    public void salvar(Dispositivo dispositivo) {
        String sql = """
                INSERT INTO dispositivo
                (nome, tipo, estado, idAmbiente_FK)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, dispositivo.getNome());
            stmt.setString(2, dispositivo.getTipo().name());
            stmt.setString(3, dispositivo.getEstado());
            stmt.setInt(4, dispositivo.getAmbiente().getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Dispositivo> listarTodos() {
        List<Dispositivo> dispositivos = new ArrayList<>();

        String sql = """
                SELECT
                    d.idDispositivo,
                    d.nome AS nomeDispositivo,
                    d.tipo,
                    d.estado,
                    a.idAmbiente,
                    a.nome AS nomeAmbiente
                FROM dispositivo d
                LEFT JOIN ambiente a
                    ON d.idAmbiente_FK = a.idAmbiente
                ORDER BY d.idDispositivo
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Ambiente ambiente = new Ambiente(
                    rs.getInt("idAmbiente"),
                    rs.getString("nomeAmbiente")
                );

                Dispositivo dispositivo = new Dispositivo(
                    rs.getInt("idDispositivo"),
                    rs.getString("nomeDispositivo"),
                    TipoDispositivo.valueOf(rs.getString("tipo")),
                    ambiente,
                    rs.getString("estado")
                );

                dispositivos.add(dispositivo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dispositivos;
    }

    public void atualizarEstado(int idDispositivo, String estado) {
        String sql = """
                UPDATE dispositivo
                SET estado = ?
                WHERE idDispositivo = ?
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, estado);
            stmt.setInt(2, idDispositivo);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int idDispositivo) {
        String sql = """
                DELETE FROM dispositivo
                WHERE idDispositivo = ?
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, idDispositivo);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}