package br.com.fiap.global.solution.beans;

public class Tratamento {

    private int idTratamento;
    private int idDoenca;
    private String descricaoTratamento;

    public Tratamento() {
    }

    public Tratamento(int idTratamento, int idDoenca, String descricaoTratamento) {
        this.idTratamento = idTratamento;
        this.idDoenca = idDoenca;
        this.descricaoTratamento = descricaoTratamento;
    }

    // Getters e setters

    public int getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(int idTratamento) {
        this.idTratamento = idTratamento;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public String getDescricaoTratamento() {
        return descricaoTratamento;
    }

    public void setDescricaoTratamento(String descricaoTratamento) {
        this.descricaoTratamento = descricaoTratamento;
    }
}
