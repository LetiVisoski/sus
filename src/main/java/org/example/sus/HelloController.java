package org.example.sus;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class HelloController {
    @FXML
    Label labelTipo = new Label();

    @FXML
    Label labelNome = new Label();

    @FXML
    Label labelCpf = new Label();

    @FXML
    Label labelNasc = new Label();

    @FXML
    Label labelTelefone = new Label();

    @FXML
    private TextField idviagemTextField;

    @FXML
    private TextField nascimentoTextField;

    @FXML
    private TextField idpessoaTextField;

    @FXML
    private ChoiceBox<String> tipoChoiceBox;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField idveiculoTextField;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField nascTextField;

    @FXML
    private TextField telefoneTextField;

    @FXML
    private TextField idViagemTextField;

    @FXML
    private TextField idmotoristaTextField;


    @FXML
    private TextField diaTextField;

    @FXML
    private TextField motoristTextField;

    @FXML
    private TextField veiculoTextField;

    @FXML
    private TextField horaTextField;

    @FXML
    private TextField embarqueTextField;

    @FXML
    private TextField destinoTextField;

    @FXML
    private TextField tipoTextField;


    @FXML
    private TextField placaTextField;


    @FXML
    private TextField lugarTextField;

    @FXML
    private TextField senhaTextField;
    @FXML
    private TextField userTextField;



    private final String usuario = "allane";
    private final String senha = "123allane";



    @FXML
    public void avanca(ActionEvent event) {
        String nomeUsuario = userTextField.getText();
        String senhaUsuario = senhaTextField.getText();


        if (nomeUsuario.isEmpty() || senhaUsuario.isEmpty()) {
            System.out.println("Favor preencher os campos.");
            return;
        }
        if (nomeUsuario.equals(usuario) && senhaUsuario.equals(senha)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
                Parent root = fxmlLoader.load();


                Stage novaJanela = new Stage();
                novaJanela.setScene(new Scene(root));
                novaJanela.show();


                // Fecha a janela atual
                ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();


            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Erro ao carregar a segunda.fxml: " + e.getMessage());
            }
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
        }

    }


    @FXML
    public void pessoas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pessoas.fxml"));
            Parent root = fxmlLoader.load();

            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

            System.err.println("Erro ao carregar a pessoas.fxml: " + e.getMessage());
        }
    }

    @FXML
    public void adicionarPessoa() throws SQLException, ClassNotFoundException {
        String tipo = tipoChoiceBox.getValue();
        String nome = nomeTextField.getText();
        String cpf = cpfTextField.getText();
        String datanasc = nascTextField.getText();
        String telefone = telefoneTextField.getText();


        if (tipo.isEmpty() || nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        PessoasDAO pessoasDAO = new PessoasDAO();
        pessoasDAO.inserirPessoas(tipo, nome, cpf, datanasc, telefone);

        nomeTextField.clear();
        cpfTextField.clear();
        nascTextField.clear();
        telefoneTextField.clear();
    }

    @FXML
    public void cadastrarPessoa(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CadastroPessoas.fxml"));
            Parent root = fxmlLoader.load();

            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

            System.err.println("Erro ao carregar a CadastroPessoas.fxml: " + e.getMessage());
        }
    }

    public void listarPessoa(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarpessoas.fxml"));
            Parent root = fxmlLoader.load();

            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void atualizarPessoa(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atualizarpessoas.fxml"));
            Parent root = fxmlLoader.load();

            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void atualizarPessoas(ActionEvent event) {


        int id = Integer.parseInt(idpessoaTextField.getText());
        String nome = nomeTextField.getText();
        String cpfCnpj = cpfTextField.getText();
        String dataNascimento = nascimentoTextField.getText();
        String telefone = telefoneTextField.getText();

        if (id == 0 || nome.isEmpty() || cpfCnpj.isEmpty() ||
                dataNascimento.isEmpty() || telefone.isEmpty()) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        try {
            PessoasDAO pessoasDAO = new PessoasDAO();
            pessoasDAO.atualizarPessoas(id, nome, cpfCnpj, dataNascimento, telefone);

            idpessoaTextField.clear();
            nomeTextField.clear();
            cpfTextField.clear();
            nascimentoTextField.clear();
            telefoneTextField.clear();

            System.out.println("Pessoa atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao atualizar a pessoa: " + e.getMessage());
        }
    }

    @FXML
    public void buscarPessoa(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (idpessoaTextField.getText().isEmpty()) {
            System.out.println("Por favor, insira o ID da pessoa a ser atualizada.");
            return;
        }

        try {
            int id = Integer.parseInt(idpessoaTextField.getText());


            PessoasDAO pessoasDAO = new PessoasDAO();
            pessoasDAO.buscarPessoas(id);

            idpessoaTextField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um ID válido.");
        }
    }


    @FXML
    public void excluirPessoa(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excluirpessoas.fxml"));
            Parent root = fxmlLoader.load();

            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

            System.err.println("Erro ao carregar a excluirpessoas.fxml: " + e.getMessage());
        }
    }


    @FXML
    public void excluirPessoas(ActionEvent event) {

        if (idpessoaTextField.getText().isEmpty()) {
            System.out.println("Por favor, insira o ID da pessoa a ser excluída.");
            return;
        }

        try {
            int id = Integer.parseInt(idpessoaTextField.getText());


            PessoasDAO pessoasDAO = new PessoasDAO();
            pessoasDAO.excluiPessoas(id);

            idpessoaTextField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um ID válido.");
        }
    }


    @FXML
    public void veiculos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("veiculos.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public void adicionarViagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastrarviagem.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void listarViagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    private VeiculoDAO veiculoDAO = new VeiculoDAO();

    public void AdicionarVeiculo(ActionEvent event) throws SQLException, ClassNotFoundException {

        String tipo = tipoTextField.getText();
        String placa = placaTextField.getText();
        int lugar = Integer.parseInt(lugarTextField.getText());


        if (tipo.isEmpty() || placa.isEmpty() || lugar == 0) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        try {
            veiculoDAO.AdicionarVeiculo(tipo, placa, lugar);
            System.out.println("Veiculo adicionado");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar veículo: " + e.getMessage());
        }

        tipoTextField.clear();
        placaTextField.clear();
        lugarTextField.clear();

    }

    @FXML
    public void atualizarVeiculo(ActionEvent event) {

        String tipo = tipoTextField.getText();
        String placa = placaTextField.getText();
        String lugar = lugarTextField.getText();
        int id = Integer.parseInt(idveiculoTextField.getText());


        if (tipo.isEmpty() || placa.isEmpty() || lugar.isEmpty() || id == 0) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        try {
            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.atualizarVeiculo(tipo, placa, lugar, id);


            tipoTextField.clear();
            placaTextField.clear();
            lugarTextField.clear();
            idveiculoTextField.clear();

            System.out.println("Veiculo atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao atualizar a veiculo: " + e.getMessage());
        }
    }

    @FXML
    public void excluirVeiculos(ActionEvent event) {

        if (idveiculoTextField.getText().isEmpty()) {
            System.out.println("Por favor, insira o ID do veiculo a ser excluída.");
            return;
        }

        try {
            int id = Integer.parseInt(idveiculoTextField.getText());


            VeiculoDAO veiculoDAO = new VeiculoDAO();
            veiculoDAO.excluirVeiculo(id);

            idveiculoTextField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um ID válido.");
        }
    }

    public void excluirViagens(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excluirviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    @FXML
    public void viagens(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void AdicionarViagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastroviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    @FXML
    public void atualizarViagem(ActionEvent event) {


        int id_pessoas = Integer.parseInt(idmotoristaTextField.getText());
        int id_veiculo = Integer.parseInt(idveiculoTextField.getText());
        String dia = diaTextField.getText();
        String hora = horaTextField.getText();
        String embarque = embarqueTextField.getText();
        String destino = destinoTextField.getText();
        int id_viagem = Integer.parseInt(idViagemTextField.getText());


        if (id_pessoas == 0 || id_veiculo == 0 || dia.isEmpty() || hora.isEmpty() || embarque.isEmpty() || destino.isEmpty() || id_viagem == 0) {
            System.out.println("Por favor, preencha todos os campos.");
            return;
        }

        try {
            ViagemDAO viagemDAO = new ViagemDAO();
            viagemDAO.atualizarViagem(id_pessoas, id_veiculo, id_viagem, dia, hora, embarque, destino);


            idmotoristaTextField.clear();
            idveiculoTextField.clear();
            diaTextField.clear();
            horaTextField.clear();
            embarqueTextField.clear();
            destinoTextField.clear();
            idViagemTextField.clear();

            System.out.println("Viagem atualizada com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao atualizar a viagem: " + e.getMessage());
        }
    }

    @FXML
    public void excluirViagem(ActionEvent event) {

        if (idviagemTextField.getText().isEmpty()) {
            System.out.println("Por favor, insira o ID da viagem a ser excluída.");
            return;
        }

        try {
            int id = Integer.parseInt(idviagemTextField.getText());


            ViagemDAO viagemDAO = new ViagemDAO();
            viagemDAO.excluirViagem(id);

            idviagemTextField.clear();

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um ID válido.");
        }
    }

    public void ListarViagem(ActionEvent event) {
        //viagens.fmxl
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    public void criarViagem(ActionEvent event) throws SQLException, ClassNotFoundException {


        int motorista = Integer.parseInt(motoristTextField.getText());
        int veiculo = Integer.parseInt(veiculoTextField.getText());
        String data = diaTextField.getText();
        String hora = horaTextField.getText();
        String embarque = embarqueTextField.getText();
        String destino = destinoTextField.getText();

        if (motorista == 0 || veiculo == 0 || data.isEmpty() || hora.isEmpty() || embarque.isEmpty() || destino.isEmpty()) {
            System.out.println("´Por favor, preencha todos os campos.");
            return;
        }
        ViagemDAO viagemDAO = new ViagemDAO();
        viagemDAO.AdicionarViagem(motorista, veiculo, data, embarque, hora, destino);

        motoristTextField.clear();
        veiculoTextField.clear();
        diaTextField.clear();
        embarqueTextField.clear();
        horaTextField.clear();
        destinoTextField.clear();
    }


    public void adicionarPessoaV(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pacientesviagem.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }


    public void atualizarViagens(ActionEvent event) { //veiculos
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atualizarviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    public void ExcluirViagem(ActionEvent event) { //viagens
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excluirviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void AtualizarViagem(ActionEvent event) { //viagens
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atualizarviagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pessoas.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void voltarViagem(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viagens.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void voltarVeiculo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("veiculos.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void voltarTela(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaInicial.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void adicionarVeiculo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastrarveiculo.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void listarVeiculo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listarveiculos.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void excluirVeiculo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("excluirveiculos.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void atualizarVeiculos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("atualizarveiculos.fxml"));
            Parent root = fxmlLoader.load();
            Stage novaJanela = new Stage();
            novaJanela.setScene(new Scene(root));
            novaJanela.show();

            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}












