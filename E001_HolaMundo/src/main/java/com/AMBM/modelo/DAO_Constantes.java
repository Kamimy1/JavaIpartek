package com.AMBM.modelo;

public interface DAO_Constantes {

	String DB = "bd_comics";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + DB;
	String USUARIO = "root";
	String CONTRASENA = "1234";

	String JSP_COMICS = "comics.jsp";
	String JSP_MANGAS = "manga.jsp";
	String JSP_TEBEOS = "tebeo.jsp";

	String TABLA_PRODUCTOS = "productos";
	String PRODUCTOS_ID = "id";
	String PRODUCTOS_TITULO = "titulo";
	String PRODUCTOS_PRECIO = "precio";
	String PRODUCTOS_TIPO = "tipo";

}
