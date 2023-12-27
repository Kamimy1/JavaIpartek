package com.p02.modelo.dto;

public class E_Animal {
	
	int id, edad, fk_especie;
	String nombre, especie;
	double peso;

	public E_Animal(int id, String nombre, double peso, int edad, int fk_especie, String especie) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.fk_especie = fk_especie;
		this.especie = especie;
	}

	public E_Animal() {
		super();
		this.id = 0;
		this.nombre = "";
		this.peso = 0.0;
		this.edad = 0;
		this.fk_especie = 0;
		this.especie = "";

	}

	public E_Animal(String nombre, double peso, int edad, int fk_especie, String especie) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.edad = edad;
		this.fk_especie = fk_especie;
		this.especie = especie;
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "E_Animal [id=" + id + ", edad=" + edad + ", fk_especie=" + fk_especie + ", nombre=" + nombre
				+ ", especie=" + especie + ", peso=" + peso + "]";
	}

}
