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


@WebServlet("/Inicio")
public class Inicio extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
       

    public Inicio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1 recepcion de parametros
		
		//2 maquetar a dto
		
		//3 conectar a la BD
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		
		//4 realizacion de la funcionalidad
		List<V_Producto> listaVProducto = db.obtenerTodosVProductos(con);
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);
	
		//5 cerrar la conexion
		db.desconectar(con);
		
		//6 la mochila
		request.setAttribute(ATR_LISTA_VPROD, listaVProducto);
		request.setAttribute(ATR_LISTA_CAT, listaCategorias);
		
		//7
		request.getRequestDispatcher(JSP_INICIO).forward(request, response);
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
