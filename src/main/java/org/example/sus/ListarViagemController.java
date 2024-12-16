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

public class ListarViagemController {
    @FXML
    private TableView<Viagem> tableView;
    @FXML
    private TableColumn<Viagem, Integer> id_viagemColumn;

    @FXML
    private TableColumn<Viagem, Integer> motoristaColumn;

    @FXML
    private TableColumn<Viagem, Integer> veiculoColumn;

    @FXML
    private TableColumn<Viagem, String> dataColumn;

    @FXML
    private TableColumn<Viagem, String> horaColumn;

    @FXML
    private TableColumn<Viagem, String> embarqueColumn;

    @FXML
    private TableColumn<Viagem, String> destinoColumn;

    @FXML
    public void initialize() {
        id_viagemColumn.setCellValueFactory(new PropertyValueFactory<>("id_viagem"));
        motoristaColumn.setCellValueFactory(new PropertyValueFactory<>("id_pessoas"));
        veiculoColumn.setCellValueFactory(new PropertyValueFactory<>("id_veiculo"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("dia"));
        horaColumn.setCellValueFactory(new PropertyValueFactory<>("hora"));
        embarqueColumn.setCellValueFactory(new PropertyValueFactory<>("embarque"));
        destinoColumn.setCellValueFactory(new PropertyValueFactory<>("destino"));

        try {
            listarviagem();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void listarviagem() throws SQLException, ClassNotFoundException {
        ViagemDAO viagemDAO = new ViagemDAO();
        List<Viagem> listaViagem = viagemDAO.listarviagem();

        ObservableList<Viagem> observableViagems = FXCollections.observableArrayList(listaViagem);
        tableView.setItems(observableViagems);
    }

    public void voltar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viagens.fxml")); // Substitua pelo caminho correto
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }}
}
