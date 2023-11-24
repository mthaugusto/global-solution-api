package br.com.fiap.global.solution.beans;

public class Imagem {

    private int idImagem;
    private int idDoenca;
    private byte[] imagem;

    public Imagem() {
    }

    public Imagem(int idImagem, int idDoenca, byte[] imagem) {
        this.idImagem = idImagem;
        this.idDoenca = idDoenca;
        this.imagem = imagem;
    }

    // Getters e setters

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public int getIdDoenca() {
        return idDoenca;
    }

    public void setIdDoenca(int idDoenca) {
        this.idDoenca = idDoenca;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
