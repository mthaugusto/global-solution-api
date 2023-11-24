package br.com.fiap.global.solution.beans;

public class Sintoma {

    private int idSintoma;
    private int idDoenca;
    private String descricaoSintoma;
    
    public Sintoma() {
    	
    }
    
	public Sintoma(int idSintoma, int idDoenca, String descricaoSintoma) {
		super();
		this.idSintoma = idSintoma;
		this.idDoenca = idDoenca;
		this.descricaoSintoma = descricaoSintoma;
	}
	
	// Getters e setters
	
	public int getIdSintoma() {
		return idSintoma;
	}
	
	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}
	
	public int getIdDoenca() {
		return idDoenca;
	}
	
	public void setIdDoenca(int idDoenca) {
		this.idDoenca = idDoenca;
	}
	
	public String getDescricaoSintoma() {
		return descricaoSintoma;
	}
	
	public void setDescricaoSintoma(String descricaoSintoma) {
		this.descricaoSintoma = descricaoSintoma;
	}
}
