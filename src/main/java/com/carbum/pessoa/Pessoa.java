package com.carbum.pessoa;

public class Pessoa {
    private Integer idpessoa;
    private String nome;
    private String emailLogin;
    private String senha;
    private String CPF;
    private float avaliacao;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Integer idpessoa, String nome, String cpf, String emailLogin, String senha, String telefone) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.CPF = cpf;
        this.emailLogin = emailLogin;
        this.senha = senha;
        this.avaliacao = 0;
        this.telefone = telefone;
    }

    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }

    public void setIdPessoa(Integer idpessoa) {
        this.idpessoa =  idpessoa;
    }

    public Integer getIdPessoa() {
        return idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
