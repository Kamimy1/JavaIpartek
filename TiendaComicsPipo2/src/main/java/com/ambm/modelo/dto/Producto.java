package com.ambm.modelo.dto;

public class Producto {

	private int id, fk_categoria;
	private String nombre;
	private double precio;

	public Producto(int id, int fk_categoria, String nombre, double precio) {
		super();
		this.id = id;
		this.fk_categoria = fk_categoria;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Producto() {
		super();
		this.id = 0;
		this.fk_categoria = 0;
		this.nombre = "";
		this.precio = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_categoria() {
		return fk_categoria;
	}

	public void setFk_categoria(int fk_categoria) {
		this.fk_categoria = fk_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", fk_categoria=" + fk_categoria + ", nombre=" + nombre + ", precio=" + precio
				+ "]";
	}

}
