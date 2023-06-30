package br.com.academia.model.sistema;

import br.com.academia.model.pessoas.Admin;
import br.com.academia.model.pessoas.Aluno;
import br.com.academia.model.pessoas.Instrutor;

import java.util.ArrayList;

public class Academia {
    private int id;
    private String nome;
    private String cnpj;
    private ArrayList<Instrutor> instrutores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Admin> administradores;

    public Academia() {
    }

    public Academia(int id, String nome, String cnpj, ArrayList<Instrutor> instrutores, ArrayList<Aluno> alunos, ArrayList<Admin> administradores) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.instrutores = instrutores;
        this.alunos = alunos;
        this.administradores = administradores;
    }

    public Academia(int id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void addInstrutor(Instrutor i){
        instrutores.add(i);
    }

    public void addAluno(Aluno a){
        alunos.add(a);
    }

    public void addAdmin(Admin ad){
        administradores.add(ad);
    }

    // METODOS GETTER E SETTER

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(ArrayList<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<Admin> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Admin> administradores) {
        this.administradores = administradores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
