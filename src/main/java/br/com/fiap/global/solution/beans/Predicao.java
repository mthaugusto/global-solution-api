package br.com.fiap.global.solution.beans;

import java.time.LocalDateTime;

public class Predicao {

    private int idPredicao;
    private int idDoenca;
    private int idCliente;
    private LocalDateTime dtClassificacao;
    private String dsPredicao;

    public Predicao() {
    }

    public Predicao(int idPredicao, int idDoenca, int idCliente, LocalDateTime dtClassificacao, String dsPredicao) {
        this.idPredicao = idPredicao;
        this.idDoenca = idDoenca;
        this.idCliente = idCliente;
        this.dtClassificacao = dtClassificacao;
        this.dsPredicao = dsPredicao;
    }

    // Getters e setters

    public int getIdPredicao() {
        return idPredicao;
    }

    public void setIdPredicao(int idPredicao) {
        this.idPredicao = idPredicao;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getDtClassificacao() {
        return dtClassificacao;
    }

    public void setDtClassificacao(LocalDateTime dtClassificacao) {
        this.dtClassificacao = dtClassificacao;
    }

    public String getDsPredicao() {
        return dsPredicao;
    }

    public void setDsPredicao(String dsPredicao) {
        this.dsPredicao = dsPredicao;
    }
}
