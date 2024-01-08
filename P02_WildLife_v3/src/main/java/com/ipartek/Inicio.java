package com.ipartek;

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

@WebServlet("/Inicio")
public class Inicio extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

	public Inicio() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// rellenar con los 7 pasos

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		List<Especie> listaEspecies = db.seleccionarTodasEspecies(con);
		List<V_Animal> listaAnimales = db.obtenerAnimalesVista(con);

		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_ESPECIES,listaEspecies);
		request.setAttribute(ATR_LISTA_V_ANIMALES,listaAnimales);

		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
