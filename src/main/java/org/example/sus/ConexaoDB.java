package org.example.sus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static final String URL = "jdbc:mysql://localhost:3306/sus";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    private static Connection conexao = null;

    ConexaoDB() {
        // Construtor privado para impedir a criação de instâncias diretas
    }

    public static Connection conectar() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
            } catch (SQLException e) {
                System.err.println("Erro ao estabelecer a conexão com o banco de dados.");
                throw e;
            }
        }
        return conexao;
    }

    public static void fecharConexao() throws SQLException {
        if (conexao != null && !conexao.isClosed()) {
            conexao.close();
            System.out.println("Conexão com o banco de dados fechada.");
        }
    }
}
