package org.example.sus;

public class Viagem {
    private int id_pessoas;
    private int id_veiculo;
    private int id_viagem;
    private String dia;
    private String hora;
    private String embarque;
    private String destino;

    public Viagem(int idPessoas, int idVeiculo, String dia, String hora, String embarque, String destino) {
    }

    public int getId_pessoas() {
        return id_pessoas;
    }

    public void setId_pessoas(int id_pessoas) {
        this.id_pessoas = id_pessoas;
    }

    public int getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(int id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEmbarque() {
        return embarque;
    }

    public void setEmbarque(String embarque) {
        this.embarque = embarque;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Viagem(int id_pessoas, int id_veiculo, int id_viagem, String dia, String hora, String embarque, String destino) {
        this.id_pessoas = id_pessoas;
        this.id_veiculo = id_veiculo;
        this.id_viagem = id_viagem;
        this.dia = dia;
        this.hora = hora;
        this.embarque = embarque;
        this.destino = destino;
    }

}