package com.mendonca.checkcar.entities.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_CLIENTEJURIDICA")
public class ClienteJuridica extends Cliente {

	private static final long serialVersionUID = 1L;
	

	
	@Column(unique = true)
	@NotNull
	private String cnpj;
	private String InscricaoMunicipal;
	private String InscricaoEstadual;
	private String razaoSocial;
	
	
	public ClienteJuridica() {
		
	}

	public ClienteJuridica( String cnpj, String inscricaoEstadual,String InscricaoMunicipal, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.InscricaoEstadual = inscricaoEstadual;
		this.InscricaoMunicipal =InscricaoMunicipal;
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return InscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		InscricaoEstadual = inscricaoEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getInscricaoMunicipal() {
		return InscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		InscricaoMunicipal = inscricaoMunicipal;
	}
	
	

}
