package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Cria conexões com o MySQL.
 *
 * As credenciais NÃO ficam no código. Elas são lidas do arquivo "db.properties",
 * na pasta onde a aplicação é executada (a raiz do projeto, no NetBeans).
 * Esse arquivo é ignorado pelo Git. Use "db.properties.example" como modelo.
 */
public class ConnectionFactory {

    private static final String ARQUIVO_CONFIG = "db.properties";

    private static final Properties CONFIG = carregarConfig();

    private static Properties carregarConfig() {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(ARQUIVO_CONFIG)) {
            props.load(in);
        } catch (IOException e) {
            System.err.println("Arquivo " + ARQUIVO_CONFIG + " não encontrado. "
                    + "Copie db.properties.example para db.properties e preencha seus dados.");
        }
        return props;
    }

    public static Connection getConnection() throws SQLException {
        String url = CONFIG.getProperty("db.url", "jdbc:mysql://localhost:3306/domuscontroldb");
        String user = CONFIG.getProperty("db.user", "root");
        String password = CONFIG.getProperty("db.password", "");
        return DriverManager.getConnection(url, user, password);
    }
}
