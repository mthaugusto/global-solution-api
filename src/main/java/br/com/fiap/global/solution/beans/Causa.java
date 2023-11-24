package br.com.fiap.global.solution.beans;

public class Causa {

    private int idCausa;
    private int idDoenca;
    private String descricaoCausa;
    
    public Causa() {
    	
    }
    
	public Causa(int idCausa, int idDoenca, String descricaoCausa) {
		super();
		this.idCausa = idCausa;
		this.idDoenca = idDoenca;
		this.descricaoCausa = descricaoCausa;
	}
	
	// Getters e setters
	
	public int getIdCausa() {
		return idCausa;
	}
	
	public void setIdCausa(int idCausa) {
		this.idCausa = idCausa;
	}
	
	public int getIdDoenca() {
		return idDoenca;
	}
	
	public void setIdDoenca(int idDoenca) {
		this.idDoenca = idDoenca;
	}
	
	public String getDescricaoCausa() {
		return descricaoCausa;
	}
	
	public void setDescricaoCausa(String descricaoCausa) {
		this.descricaoCausa = descricaoCausa;
	}


}