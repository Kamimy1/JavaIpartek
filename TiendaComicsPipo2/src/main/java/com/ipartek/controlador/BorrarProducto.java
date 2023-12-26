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
import com.ipartek.modelo.dto.V_Producto;

/**
 * Servlet implementation class BorrarProducto
 */
@WebServlet("/BorrarProducto")
public class BorrarProducto extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

	public BorrarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int id = 0;
		
		if(request.getParameter("id")!=null) {
			String idProducto = request.getParameter("id");
			id = Integer.parseInt(idProducto);
		}else {
			System.out.println("Hay un error");
		}
		
		
		db.borrarProducto(con, id);

		List<V_Producto> listaVProducto = db.obtenerTodosVProductos(con);

		// 5 desconectar
		db.desconectar(con);

		// 6 mochila
		request.setAttribute(ATR_LISTA_VPROD, listaVProducto);

		// 7 redireccion
		request.getRequestDispatcher(JSP_INICIO).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
