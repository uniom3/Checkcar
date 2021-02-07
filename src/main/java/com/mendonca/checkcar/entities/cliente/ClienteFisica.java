package com.mendonca.checkcar.entities.cliente;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_CLIENTEFISICA")
public class ClienteFisica extends Cliente {

	private static final long serialVersionUID = 1L;
	
	
	@Column(unique = true)
	@NotNull
	private String cpf;
	private String rg;
	private String orgaoEmissorRG;
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	@Column(name = "dataEmissao", columnDefinition = "DATE")
	private LocalDate dataEmissao;

	public ClienteFisica() {

	}

	public ClienteFisica(String cpf, String rg, String orgaoEmissorRG, LocalDate dataEmissao) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.orgaoEmissorRG = orgaoEmissorRG;
		this.dataEmissao = dataEmissao;
	}
	
	

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissorRG() {
		return orgaoEmissorRG;
	}

	public void setOrgaoEmissorRG(String orgaoEmissorRG) {
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

}
