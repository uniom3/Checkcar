package com.mendonca.checkcar.entities.produto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="TB_GRUPO")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	@OneToMany(mappedBy = "grupo")
	private List<Categoria> categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_familia_fk")
	private Familia familia;
	
	public Grupo() {
		
	}

	public Grupo(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	

}
