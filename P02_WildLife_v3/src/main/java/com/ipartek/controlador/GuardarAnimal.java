package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO_Constantes;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Animal;
import com.ipartek.modelo.dto.Especie;
import com.ipartek.modelo.dto.V_Animal;

@WebServlet("/GuardarAnimal")
public class GuardarAnimal extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

	public GuardarAnimal() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1
		String nombre = "";
		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
		}

		double peso = 0.0;
		if (request.getParameter("peso") != null) {
			peso = Double.parseDouble(request.getParameter("peso"));
		}

		int edad = 0;
		if (request.getParameter("edad") != null) {
			edad = Integer.parseInt(request.getParameter("edad"));
		}

		int fk_especie = 0;
		if (request.getParameter("fk_especie") != null) {
			fk_especie = Integer.parseInt(request.getParameter("fk_especie"));
		}

		// 2
		Animal ani = new Animal(0, nombre, peso, edad, fk_especie);

		// 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4
		db.insertarAnimal(con,ani);	
		List<Especie> listaEspecies=db.seleccionarTodasEspecies(con);
		List<V_Animal> listaAnimales = db.obtenerAnimalesVista(con);
		
		// 5
		db.desconectar(con);
		
		//6
		request.setAttribute(ATR_LISTA_ESPECIES,listaEspecies);
		request.setAttribute(ATR_LISTA_V_ANIMALES,listaAnimales);
		
		//
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
