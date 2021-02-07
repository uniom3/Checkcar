package com.mendonca.checkcar.entities.enums;

public enum TipoCliente {
	
	
	PESSOAFISICA(01, "Cliente Física"),
	PESSOAJURIDICA(02, "Cliente Juridica");
		
	private Integer codigo;
	private String tipo;
	
	
	private TipoCliente(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	

}
