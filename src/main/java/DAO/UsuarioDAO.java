package DAO;

import database.ConnectionFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    
    public void salvar(Usuario usuario) {
        String sql = """
                INSERT INTO usuario (nome, email, senha, perfil)
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getPerfil());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Usuario buscarPorEmail(String email) {
        String sql = """
                SELECT idUsuario, nome, email, senha, perfil
                FROM usuario
                WHERE email = ?
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(rs.getInt("idUsuario"), rs.getString("nome"), rs.getString("email"), rs.getString("senha"), rs.getString("perfil"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public boolean login(String email, String senha) {
        String sql = """
                SELECT idUsuario
                FROM usuario
                WHERE email = ? AND senha = ?
                """;

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                boolean encontrou = rs.next();


                return encontrou;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
