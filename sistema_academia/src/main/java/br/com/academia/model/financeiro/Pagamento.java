package br.com.academia.model.financeiro;

import br.com.academia.model.e.ETipoPagamento;
import br.com.academia.model.sistema.Matricula;

import java.time.LocalDateTime;

public class Pagamento {

    private int id;
    private Matricula matricula;
    private LocalDateTime dataPagamento;
    private ETipoPagamento tipoPagamento;

    public Pagamento() {
    }

    public Pagamento(int id, Matricula matricula, LocalDateTime dataPagamento, ETipoPagamento tipoPagamento) {
        this.id = id;
        this.matricula = matricula;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    // METODOS GETTER E SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ETipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(ETipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
