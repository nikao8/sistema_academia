package br.com.academia.model.sistema;

import br.com.academia.model.financeiro.Pagamento;
import br.com.academia.model.pessoas.Aluno;

import java.util.ArrayList;
import java.util.Date;

public class Matricula {
    private int id;
    private Aluno aluno;
    private double mensalidade;
    private Date dataMatricula;
    private Date dataVencimento;

    private ArrayList<Pagamento> pagamentos;

    public Matricula() {
    }

    public Matricula(int id, Aluno aluno, double mensalidade, Date dataMatricula, Date dataVencimento, ArrayList<Pagamento> pagamentos) {
        this.id = id;
        this.aluno = aluno;
        this.mensalidade = mensalidade;
        this.dataMatricula = dataMatricula;
        this.dataVencimento = dataVencimento;
        this.pagamentos = pagamentos;
    }

    public Matricula(int id, Aluno aluno, double mensalidade, Date dataMatricula, Date dataVencimento) {
        this.id = id;
        this.aluno = aluno;
        this.mensalidade = mensalidade;
        this.dataMatricula = dataMatricula;
        this.dataVencimento = dataVencimento;
    }

    // METODOS GETTER E SETTER


    public ArrayList<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(ArrayList<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

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

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
