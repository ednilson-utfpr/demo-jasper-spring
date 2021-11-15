package com.mballem.curso.jasper.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Produto extends Situacao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 40, nullable = false)
	private String nome;
	
	@Column(length = 3000, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Double valor; 

	@Column(nullable = false)
	private Integer estoque;

	@Column(length = 3000, nullable = false)
	private String imagem;

	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "id")
	private Categoria categoria;
}
