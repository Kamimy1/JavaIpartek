package com.AMBM.modelo.dto;

public class Producto {

	private int id;
	private String titulo, tipo;
	private double precio;

	public Producto(int id, String titulo, String tipo, double precio) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.precio = precio;
	}

	public Producto(String titulo, String tipo, double precio) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.precio = precio;
	}

	public Producto() {
		super();
		this.id = 0;
		this.titulo = "";
		this.tipo = "";
		this.precio = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", precio=" + precio + "]";
	}

}
