package org.example.sus;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class ListarVeiculosController {
    @FXML
    private TableView<Veiculo> tableView;

    @FXML
    private TableColumn<Veiculo, String> tipoColumn;

    @FXML
    private TableColumn<Veiculo, String> placaColumn;

    @FXML
    private TableColumn<Veiculo, String> lugarColumn;

    @FXML
    public void initialize() {

        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        lugarColumn.setCellValueFactory(new PropertyValueFactory<>("lugar"));
        placaColumn.setCellValueFactory(new PropertyValueFactory<>("placa"));

        try {
            listarveiculos();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void listarveiculos() throws SQLException, ClassNotFoundException {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        List<Veiculo> listaVeiculos = veiculoDAO.listarVeiculos();

        ObservableList<Veiculo> observableVeiculos = FXCollections.observableArrayList(listaVeiculos);
        tableView.setItems(observableVeiculos);
    }

    public void voltarTela(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("veiculos.fxml")); // Substitua pelo caminho correto
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

