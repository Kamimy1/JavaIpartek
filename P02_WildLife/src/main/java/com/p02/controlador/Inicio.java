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
import com.p02.modelo.dto.E_Animal;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DB_Helper db = new DB_Helper();
		Connection con = db.contectar();

		List<E_Animal> listEAnimal = db.obtenerTodosEAnimales(con);
		
		System.out.println(listEAnimal);

		db.desconectar(con);

		request.setAttribute(ATR_LISTA_EANIMALES, listEAnimal);
	
		request.getRequestDispatcher(JSP_INICIO).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
