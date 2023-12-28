package com.p02.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p02.modelo.DAO_Constantes;
import com.p02.modelo.DB_Helper;
import com.p02.modelo.dto.Animal;
import com.p02.modelo.dto.E_Animal;
import com.p02.modelo.dto.Especie;

/**
 * Servlet implementation class ModificarAnimal
 */
@WebServlet("/ModificarAnimal")
public class ModificarAnimal extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarAnimal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

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

		Animal anim = new Animal(id, nombre, peso, edad, fk_especie);

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		db.modificarAnimal(con, anim);
		List<E_Animal> listaEAnimales = db.obtenerTodosEAnimales(con);
		List<Especie> listaEspecies = db.obtenerTodasEspecies(con);

		db.desconectar(con);

		request.setAttribute(ATR_LISTA_EANIMALES, listaEAnimales);
		request.setAttribute(ATR_LISTA_ESPECIES, listaEspecies);

		request.getRequestDispatcher(JSP_INICIO).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
