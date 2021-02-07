package com.mendonca.checkcar.entities.produto;

import com.mendonca.checkcar.entities.produto.Grupo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Descricao;
	@ManyToOne
	@JoinColumn(name = "id_grupo_fk")
	private Grupo grupo;
	
	public Categoria() {
		
	}

	public Categoria(Long id, String descricao, Grupo grupo) {
		super();
		this.id = id;
		Descricao = descricao;
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	

}
