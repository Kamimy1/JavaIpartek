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
import com.p02.modelo.dto.Especie;

/**
 * Servlet implementation class FormModificarAnimal
 */
@WebServlet("/FormModificarAnimal")
public class FormModificarAnimal extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormModificarAnimal() {
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

		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		Animal anim = db.obtenerAnimalId(con, id);
		List<Especie> listaCategorias = db.obtenerTodasEspecies(con);

		db.desconectar(con);

		request.setAttribute(ATR_ANIMAL, anim);
		request.setAttribute(ATR_LISTA_ESPECIES, listaCategorias);

		request.getRequestDispatcher(JSP_FORM_MODIFICAR).forward(request, response);

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
