package com.mendonca.checkcar.entities.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String codigoEAN;
	private Double valor;
	@ManyToOne
	@JoinColumn(name = "id_fabricante_fk")
	private Fabricante fabricante;
	private Boolean ativo;
	
	
	public Produto() {
		
	}


	public Produto(Long id, String descricao, String codigoEAN, Double valor,Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigoEAN = codigoEAN;
		this.valor = valor;
		this.ativo = ativo;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
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


	public String getCodigoEAN() {
		return codigoEAN;
	}


	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Fabricante getFabricante() {
		return fabricante;
	}


	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	
	
}
