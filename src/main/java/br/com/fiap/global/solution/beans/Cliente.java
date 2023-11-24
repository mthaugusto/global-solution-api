package br.com.fiap.global.solution.beans;
	
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import br.com.fiap.global.solution.data.ClienteDao;

public class Cliente {
	private int idCliente;
	private String nomeCliente;
	private String emailCliente;
	private String cpf;
    private String dataNascimento;
	private char generoCliente;
	private String numeroCelular;
	private String cep;
	private char possuiAlergia;
	private String descricaoAlergia;
	private char utilizaMedicamentos;
	private String descricaoMedicamentos;

	public Cliente() {
	}

	public Cliente(int idCliente, String nomeCliente, String emailCliente, String cpf, String dataNascimento,
			char generoCliente, String numeroCelular, String cep, char possuiAlergia, String descricaoAlergia,
			char utilizaMedicamentos, String descricaoMedicamentos) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.generoCliente = generoCliente;
		this.numeroCelular = numeroCelular;
		this.cep = cep;
		this.possuiAlergia = possuiAlergia;
		this.descricaoAlergia = descricaoAlergia;
		this.utilizaMedicamentos = utilizaMedicamentos;
		this.descricaoMedicamentos = descricaoMedicamentos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getGeneroCliente() {
		return generoCliente;
	}

	public void setGeneroCliente(char generoCliente) {
		this.generoCliente = generoCliente;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public char getPossuiAlergia() {
		return possuiAlergia;
	}

	public void setPossuiAlergia(char possuiAlergia) {
		this.possuiAlergia = possuiAlergia;
	}

	public String getDescricaoAlergia() {
		return descricaoAlergia;
	}

	public void setDescricaoAlergia(String descricaoAlergia) {
		this.descricaoAlergia = descricaoAlergia;
	}

	public char getUtilizaMedicamentos() {
		return utilizaMedicamentos;
	}

	public void setUtilizaMedicamentos(char utilizaMedicamentos) {
		this.utilizaMedicamentos = utilizaMedicamentos;
	}

	public String getDescricaoMedicamentos() {
		return descricaoMedicamentos;
	}

	public void setDescricaoMedicamentos(String descricaoMedicamentos) {
		this.descricaoMedicamentos = descricaoMedicamentos;
	}
	
}