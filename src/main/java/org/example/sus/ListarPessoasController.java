package org.example.sus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ListarPessoasController {

    @FXML
    private TableView<Pessoas> tableView;

    @FXML
    private TableColumn<Pessoas, String> tipoColumn;

    @FXML
    private TableColumn<Pessoas, Integer> idColumn;

    @FXML
    private TableColumn<Pessoas, String> nomeColumn;

    @FXML
    private TableColumn<Pessoas, String> cpfColumn;

    @FXML
    private TableColumn<Pessoas, String> nascimentoColumn;

    @FXML
    private TableColumn<Pessoas, String> telefoneColumn;

    @FXML
    public void initialize() {
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfColumn.setCellValueFactory(new PropertyValueFactory<>("cpf_cnpj"));
        nascimentoColumn.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
        telefoneColumn.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        try {
            listarpessoas();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void listarpessoas() throws SQLException, ClassNotFoundException {
        PessoasDAO pessoasDAO = new PessoasDAO();
        List<Pessoas> listaPessoas = pessoasDAO.listarpessoas();

        ObservableList<Pessoas> observablePessoas = FXCollections.observableArrayList(listaPessoas);
        tableView.setItems(observablePessoas);
    }

    public void voltar(ActionEvent event) {
        try {
            // Carregar a tela anterior
            Parent root = FXMLLoader.load(getClass().getResource("pessoas.fxml")); // Substitua "telaAnterior.fxml" pelo nome correto do FXML da tela anterior.

            // Obter o palco atual
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Trocar a cena
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao voltar: " + e.getMessage());
        }
    }
}
