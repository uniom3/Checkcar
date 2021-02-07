package com.mendonca.checkcar.entities.produto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TB_FAMILIA")
public class Familia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@ManyToMany
	private List<Fabricante> fabricante;
	
	public Familia() {
		
	}

	public Familia(Long id, String descricao, List<Fabricante> fabricante) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.fabricante = fabricante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Fabricante> getFabricante() {
		return fabricante;
	}

	public void setFabricante(List<Fabricante> fabricante) {
		this.fabricante = fabricante;
	}
	
	

}
