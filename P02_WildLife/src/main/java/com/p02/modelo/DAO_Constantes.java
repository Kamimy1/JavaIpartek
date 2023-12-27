package com.p02.modelo;

public interface DAO_Constantes {
	
	String BD_DRIVER = "com.mysql.jdbc.Driver";
	String BD = "bd_wild_life";
	String CADENA_CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";

	String TABLA_ANIMALES = "animales";
	String ANIMALES_ID = "id";
	String ANIMALES_NOMBRE = "nombre";
	String ANIMALES_PESO = "peso";
	String ANIMALES_EDAD = "edad";
	String ANIMALES_FK_ESPECIE = "FK_especie";

	String TABLA_ESPECIES = "especies";
	String ESPECIES_ID = "id";
	String ESPECIES_ESPECIE = "especie";
	
	String E_ANIMALES_ID = "id";
	String E_ANIMALES_NOMBRE = "nombre";
	String E_ANIMALES_PESO = "peso";
	String E_ANIMALES_EDAD = "edad";
	String E_ANIMALES_FK_ESPECIE = "FK_especie";
	String E_ANIMALES_ESPECIE = "especie";
	
	String JSP_INICIO = "inicio.jsp";
	
	String ATR_LISTA_EANIMALES = "atr_lista_eanimales";
	
	String SP_OBTENER_TODOS_ANIMALES_ESPECIE = "call bd_wild_life.sp_obtener_todos_animales_especie();";


}
