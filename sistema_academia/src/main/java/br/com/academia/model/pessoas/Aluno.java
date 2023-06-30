package br.com.academia.model.pessoas;

import br.com.academia.model.fichas.Ficha;
import br.com.academia.model.sistema.Academia;
import br.com.academia.model.sistema.Matricula;

import java.util.ArrayList;

public class Aluno extends Usuario{
    private ArrayList<Ficha> fichas;
    private Matricula matricula;
    private Instrutor instrutor;

    public Aluno() {
    }

    public Aluno(int id, Academia academia, String nome, String login, String senha) {
        super(id, academia, nome, login, senha);
    }

    public Aluno(int id, Academia academia, String nome, String login, String senha, Matricula matricula, Instrutor instrutor) {
        super(id, academia, nome, login, senha);
        this.matricula = matricula;
        this.instrutor = instrutor;
    }

    public Aluno(int id, Academia academia, String nome, String login, String senha, Instrutor instrutor) {
        super(id, academia, nome, login, senha);
        this.instrutor = instrutor;
    }

    public void addFicha(Ficha f){
        fichas.add(f);
    }

    // METODOS GETTER E SETTER

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }
}
