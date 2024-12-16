package org.example.sus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VeiculoDAO {

    private List<Veiculo> veiculos = new ArrayList<>();

    public void AdicionarVeiculo(String tipo, String placa, int lugar) throws SQLException, ClassNotFoundException {
        Veiculo veiculo = new Veiculo(tipo, placa, lugar);
        veiculos.add(veiculo);


        String insertSQL = "INSERT INTO veiculo (tipo, placa, lugar) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
            insertStmt.setString(1, veiculo.getTipo());
            insertStmt.setString(2, veiculo.getPlaca());
            insertStmt.setInt(3, veiculo.getLugar());

            int rowsInserted = insertStmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cadastro de veículo feito com sucesso!");
            } else {
                System.out.println("Falha ao cadastrar veículo.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veiculo> listarVeiculos() throws SQLException {
        String selectSQL = ("SELECT  tipo, placa, lugar FROM veiculo");
        List<Veiculo> veiculos = new ArrayList<>();

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement selectStmt = conn.prepareStatement(selectSQL)) {

            ResultSet rs = selectStmt.executeQuery();

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                        rs.getString("tipo"),
                        rs.getString("placa"),
                        rs.getInt("lugar")
                );
                veiculos.add(veiculo);
            }
            return veiculos;
        }
    }

    public void atualizarVeiculo(String tipo, String placa, String lugar, int id) throws SQLException {
        String updateSQL = "UPDATE veiculo SET tipo = ? , placa = ?, lugar = ? WHERE id_veiculo = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

            updateStmt.setString(1, tipo);
            updateStmt.setString(2, placa);
            updateStmt.setString(3, lugar);
            updateStmt.setInt(4, id);


            int rowsUpdated = updateStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Veiculo atualizado com sucesso.");
            } else {
                System.out.println("Nenhum veiculo encontrado com o ID especificado.");
            }
        }
    }

    public void excluirVeiculo(int id) {
        String deleteSQL = "DELETE FROM veiculo WHERE id_veiculo = ?";

        ConexaoDB conexaoDB = new ConexaoDB();
        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL)) {

            deleteStmt.setInt(1, id);
            int rowsDeleted = deleteStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Veiculo excluído com sucesso.");
            } else {
                System.out.println("Nenhum veiculo encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir veiculo: " + e.getMessage());
        }
    }

}




