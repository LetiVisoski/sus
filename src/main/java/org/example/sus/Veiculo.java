package org.example.sus;


public class Veiculo {
    private int id;
    private String tipo;
    private String placa;
    private int lugar;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String modelo) {
        this.tipo = modelo;
    }


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public int getLugar() {
        return lugar;
    }


    public void setLugar(int lugares) {
        this.lugar = lugares;
    }


    public Veiculo(String tipo, String placa, int lugar) {
        this.tipo = tipo;
        this.placa = placa;
        this.lugar = lugar;
    }

    public Veiculo(int id, String tipo, String placa, int lugar) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.lugar = lugar;
    }
}
