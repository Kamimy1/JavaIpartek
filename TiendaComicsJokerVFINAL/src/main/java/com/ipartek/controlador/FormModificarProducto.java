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
import com.ipartek.modelo.dto.Categoria;
import com.ipartek.modelo.dto.Producto;
import com.ipartek.modelo.dto.V_Producto;

@WebServlet("/FormModificarProducto")
public class FormModificarProducto extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

	public FormModificarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		// 2 NO HACE FALTA

		// 3
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();

		// 4
		Producto prod=db.obtenerProductoPorId(con, id);
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);

		// 5
		db.desconectar(con);

		// 6
		request.setAttribute(ATR_PROD, prod);
		request.setAttribute(ATR_LISTA_CATEG, listaCategorias);

		// 7
		request.getRequestDispatcher(JSP_FRM_MODIFICAR).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
