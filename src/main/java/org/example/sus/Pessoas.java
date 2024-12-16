package org.example.sus;


public class Pessoas {
    private int id;
    private String tipo;
    private String nome;
    private String cpf_cnpj;
    private String data_nascimento;
    private String telefone;

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoas(int id, String tipo, String nome, String cpf_cnpj, String nasc, String telefone) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.data_nascimento = nasc;
        this.telefone = telefone;
    }

    public Pessoas(String tipo, String nome, String cpf_cnpj, String nasc, String telefone) {
        this.tipo = tipo;
        this.nome = nome;
        this.cpf_cnpj = cpf_cnpj;
        this.data_nascimento = nasc;
        this.telefone = telefone;
    }
}
