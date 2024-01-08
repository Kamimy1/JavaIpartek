package com.Ejemplo_JSON;

public class Coche {

	private String marca;
	private String modelo;
	private String matricula;
	private int numPuertas;
	private double peso;
	private boolean esElectrico;

	public Coche(String marca, String modelo, String matricula, int numPuertas, double peso, boolean esElectrico) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.numPuertas = numPuertas;
		this.peso = peso;
		this.esElectrico = esElectrico;
	}

	public Coche() {
		super();
		this.marca = "";
		this.modelo = "";
		this.matricula = "";
		this.numPuertas = 0;
		this.peso = 0.0;
		this.esElectrico = false;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean getEsElectrico() {
		return esElectrico;
	}

	public void setEsElectrico(boolean esElectrico) {
		this.esElectrico = esElectrico;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + ", numPuertas="
				+ numPuertas + ", peso=" + peso + ", esElectrico=" + esElectrico + "]";
	}

}
