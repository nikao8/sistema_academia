package br.com.academia.model.pessoas;

import br.com.academia.model.sistema.Academia;

public abstract class Usuario {

    private int id;
    private Academia academia;
    private String nome;
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(int id, Academia academia, String nome, String login, String senha) {
        this.id = id;
        this.academia = academia;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // METODOS GET AND SETTER

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
