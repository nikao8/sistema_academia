package br.com.academia.model.fichas;

import br.com.academia.model.e.ETipoFicha;
import br.com.academia.model.pessoas.Aluno;
import br.com.academia.model.pessoas.Instrutor;

import java.util.ArrayList;
import java.util.Date;

public class Ficha {
    private int id;
    private Aluno aluno;
    private Instrutor instrutor;
    private ETipoFicha tipoFicha;
    private ArrayList<Exercicio> exercicios;
    private Date dataCriacao;

    public Ficha() {
    }

    public Ficha(int id, Aluno aluno, Instrutor instrutor, ETipoFicha tipoFicha, ArrayList<Exercicio> exercicios, Date dataCriacao) {
        this.id = id;
        this.aluno = aluno;
        this.instrutor = instrutor;
        this.tipoFicha = tipoFicha;
        this.exercicios = exercicios;
        this.dataCriacao = dataCriacao;
    }

    // METODOS GETTER E SETTER


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public ETipoFicha getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(ETipoFicha tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    public ArrayList<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
