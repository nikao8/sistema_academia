package br.com.academia.model.pessoas;

import br.com.academia.model.sistema.Academia;

import java.util.ArrayList;

public class Instrutor extends Usuario{
    private ArrayList<Aluno> alunos;
    private double salario;

    public Instrutor() {
    }

    public Instrutor(int id, Academia academia, String nome, String login, String senha, ArrayList<Aluno> alunos, double salario) {
        super(id, academia, nome, login, senha);
        this.alunos = alunos;
        this.salario = salario;
    }

    public Instrutor(int id, Academia academia, String nome, String login, String senha, double salario) {
        super(id, academia,nome, login, senha);
        this.salario = salario;
    }


    public void addAluno(Aluno a){
        alunos.add(a);
    }


    // METODOS GETTER E SETTER

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


}
