package com.p02.modelo.dto;

public class Animal {
	
	int id, edad, fk_especie;
	String nombre;
	double peso;

	public Animal(int id, String nombre, double peso, int edad, int fk_especie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.fk_especie = fk_especie;
	}

	public Animal() {
		super();
		this.id = 0;
		this.nombre = "";
		this.peso = 0.0;
		this.edad = 0;
		this.fk_especie = 0;
	}

	public Animal(String nombre, double peso, int edad, int fk_especie) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.fk_especie = fk_especie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getFk_especie() {
		return fk_especie;
	}

	public void setFk_especie(int fk_especie) {
		this.fk_especie = fk_especie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", edad=" + edad + ", fk_especie=" + fk_especie + ", nombre=" + nombre + ", peso="
				+ peso + "]";
	}

}
