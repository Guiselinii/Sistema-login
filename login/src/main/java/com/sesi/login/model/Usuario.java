package com.sesi.login.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Usuario {
	
	@Column(nullable = false, unique = true)
	private String nomeUsuario;
	
	@Column(nullable = false)
	private String senha;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idUsuario;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinTable(name = "usuario_papeis",
			joinColumns = @JoinColumn (name="usuario_id"),
			inverseJoinColumns = @JoinColumn (name="papel_id")
			)
	
	private Set<Papel> papeis = new HashSet<>();
}
