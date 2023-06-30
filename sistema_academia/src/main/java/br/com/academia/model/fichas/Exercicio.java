package br.com.academia.model.fichas;

import br.com.academia.model.e.ETipoExercicio;

public class Exercicio {
    private int id;
    private Ficha ficha;
    private String nome;
    private int series;
    private int repeticoes;
    private double peso;
    private ETipoExercicio tipoExercicio;
    private String observacao;

    public Exercicio() {
    }

    public Exercicio(int id, String nome, int series, int repeticoes, double peso, ETipoExercicio tipoExercicio, String observacao, Ficha ficha) {
        this.id = id;
        this.ficha = ficha;
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.peso = peso;
        this.tipoExercicio = tipoExercicio;
        this.observacao = observacao;
    }

// METODOS GETTER E SETTER


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

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public ETipoExercicio getTipoExercicio() {
        return tipoExercicio;
    }

    public void setTipoExercicio(ETipoExercicio tipoExercicio) {
        this.tipoExercicio = tipoExercicio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }
}
