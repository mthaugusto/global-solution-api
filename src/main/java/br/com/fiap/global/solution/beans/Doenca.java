package br.com.fiap.global.solution.beans;

public class Doenca {

    private int idDoenca;
    private String nomeDoenca;
    private String descricaoDoenca;

    public Doenca() {
    }

    public Doenca(int idDoenca, String nomeDoenca, String descricaoDoenca) {
        this.idDoenca = idDoenca;
        this.nomeDoenca = nomeDoenca;
        this.descricaoDoenca = descricaoDoenca;
    }

    // Getters e setters

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }

    public String getDescricaoDoenca() {
        return descricaoDoenca;
    }

    public void setDescricaoDoenca(String descricaoDoenca) {
        this.descricaoDoenca = descricaoDoenca;
    }
}
