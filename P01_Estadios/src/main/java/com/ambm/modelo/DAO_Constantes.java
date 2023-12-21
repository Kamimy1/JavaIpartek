package com.ambm.modelo;

public interface DAO_Constantes {
	
	String BD_DRIVER = "com.mysql.jdbc.Driver";
	String BD = "bd_estadios_futbol";
	String CADENA_CONEXION = "jdbc:mysql://localhost:3306/" + BD;
	String USUARIO = "root";
	String PASS = "1234";

	
	String TABLA_ESTADIOS = "estadios";
	String ESTADIOS_ID = "id";
	String ESTADIOS_NOMBRE = "nombre";
	String ESTADIOS_AFORO = "aforo";
	String ESTADIOS_FECHA = "fechaConstruccion";
	String ESTADIOS_EQUIPO = "equipo";

}
