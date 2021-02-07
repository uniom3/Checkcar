package com.mendonca.checkcar.entities;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;


	private String usuario;
	private String nome;
	private String senha;

 public Usuario(){

 }

	public Usuario(String usuario, String nome, String senha) {
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
