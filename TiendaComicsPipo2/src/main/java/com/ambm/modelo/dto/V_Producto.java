package com.ambm.modelo.dto;

public class V_Producto {
	
	private int id, fk_categoria;
	private String nombre;
	private double precio;
	private String categoria;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public V_Producto(int id, int fk_categoria, String nombre, double precio, String categoria) {
		super();
		this.id = id;
		this.fk_categoria = fk_categoria;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}
	public V_Producto() {
		super();
		this.id = 0;
		this.fk_categoria = 0;
		this.nombre = "";
		this.precio = 0.0;
		this.categoria = "";
	}


	
}
