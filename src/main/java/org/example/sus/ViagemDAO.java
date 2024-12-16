package org.example.sus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViagemDAO {
    private List<Viagem> viagems = new ArrayList<>();

    public void AdicionarViagem(int id_pessoas, int id_veiculo, String dia, String hora, String embarque, String destino) throws SQLException, ClassNotFoundException {
        Viagem viagem = new Viagem(id_pessoas, id_veiculo, dia, hora, embarque, destino);
        viagems.add(viagem);


        String insertSQL = "INSERT INTO viagens (id_pessoas, id_veiculo,dia,hora, embarque,destino) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            insertStmt.setInt(1, id_pessoas);
            insertStmt.setInt(2, id_veiculo);
            insertStmt.setString(3, dia);
            insertStmt.setString(4, hora);
            insertStmt.setString(5, embarque);
            insertStmt.setString(6, destino);

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cadastro de viagem feito com sucesso!");
            } else {
                System.out.println("Falha ao cadastrar viagem.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarViagem(int id_pessoas, int id_veiculo, int id_viagem, String dia, String hora, String embarque, String destino) throws SQLException {
        String updateSQL = "UPDATE viagens SET id_pessoas = ?, id_veiculo = ?, dia = ?,  hora = ?, embarque = ?, destino = ? WHERE id_viagem = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            updateStmt.setInt(1, id_pessoas);
            updateStmt.setInt(2, id_veiculo);
            updateStmt.setString(3, dia);
            updateStmt.setString(4, hora);
            updateStmt.setString(5, embarque);
            updateStmt.setString(6, destino);
            updateStmt.setInt(7, id_viagem);

            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Viagem atualizado com sucesso.");
            } else {
                System.out.println("Nenhuma viagem encontrado com o ID especificado.");
            }
        }
    }

    public void excluirViagem(int id) {
        String deleteSQL = "DELETE FROM viagens WHERE id_viagem = ?";

        ConexaoDB conexaoDB = new ConexaoDB();
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, id);
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Viagem excluída com sucesso.");
            } else {
                System.out.println("Nenhums viagem encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir viagem: " + e.getMessage());
        }
    }

    public List<Viagem> listarviagem() throws SQLException {
        String selectSQL = "SELECT id_viagem, id_pessoas, id_veiculo, dia, hora, embarque, destino FROM viagens";
        List<Viagem> listaDeViagem = new ArrayList<>();

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
             ResultSet rs = selectStmt.executeQuery()) {

            while (rs.next()) {
                Viagem viagem = new Viagem(
                        rs.getInt("id_viagem"),
                        rs.getInt("id_pessoas"),
                        rs.getInt("id_veiculo"),
                        rs.getString("dia"),
                        rs.getString("hora"),
                        rs.getString("embarque"),
                        rs.getString("destino")
                );
                listaDeViagem.add(viagem);
            }
        }
        return listaDeViagem;


    }


}
