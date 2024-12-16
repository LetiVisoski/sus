package org.example.sus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    private List<Pessoas> pessoas = new ArrayList<>();


    public void inserirPessoas(String tipo, String nome, String cpf_cnpj, String nasc, String telefone) throws SQLException, ClassNotFoundException {
        Pessoas pessoa = new Pessoas(tipo, nome, cpf_cnpj, nasc, telefone);
        pessoas.add(pessoa);

        String insertSQL = "INSERT INTO pessoas (nome, cpf_cnpj, data_nascimento, telefone, tipo) VALUES (?, ?, ?, ?, ?)";


        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {


            insertStmt.setString(1, pessoa.getNome());
            insertStmt.setString(2, pessoa.getCpf_cnpj());
            insertStmt.setString(3, pessoa.getData_nascimento());
            insertStmt.setString(4, pessoa.getTelefone());
            insertStmt.setString(5, pessoa.getTipo());


            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Seu cadastro foi um sucesso!");
            } else {
                System.out.println("Falha ao fazer o cadastro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoas> listarpessoas() throws SQLException, ClassNotFoundException {
        String selectSQL = "SELECT id_pessoas,nome, cpf_cnpj, data_nascimento, telefone, tipo FROM pessoas";
        List<Pessoas> pessoas = new ArrayList<>();

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                Pessoas pessoa = new Pessoas(
                        rs.getString("id_pessoas"),
                        rs.getString("nome"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone")
                );
                pessoas.add(pessoa);
            }
        }

        return pessoas;
    }

    public void buscarPessoas(int id) throws SQLException, ClassNotFoundException {
        String selectSQL = "SELECT tipo, nome , cpf_cnpj , data_nascimento , telefone ,  FROM id_pessoas";
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                Pessoas pessoa = new Pessoas(
                        rs.getString("id_pessoas"),
                        rs.getString("nome"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone")
                );
                pessoas.add(pessoa);
            }
        }
    }


    public void atualizarPessoas(int id, String nome, String cpf_cnpj, String datanasc, String telefone) throws SQLException {
        String updateSQL = "UPDATE pessoas SET  nome = ?, cpf_cnpj = ?, data_nascimento = ?, telefone = ? WHERE id_pessoas = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            updateStmt.setString(1, nome);
            updateStmt.setString(2, cpf_cnpj);
            updateStmt.setString(3, datanasc);
            updateStmt.setString(4, telefone);
            updateStmt.setInt(5, id);

            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Pessoa atualizada com sucesso.");
            } else {
                System.out.println("Nenhuma pessoa encontrada com o ID especificado.");
            }
        }
    }

    public void excluiPessoas(int id) {
        String deleteSQL = "DELETE FROM pessoas WHERE id_pessoas = ?";

        ConexaoDB conexaoDB = new ConexaoDB();
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, id);
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Pessoa excluído com sucesso.");
            } else {
                System.out.println("Nenhuma pessoa encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir pessoa: " + e.getMessage());
        }
    }

}


