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


@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
       
 
    public InsertarProducto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 recibir parametros
		String nombre="";
		if (request.getParameter("nombre")!=null) {
			nombre=request.getParameter("nombre");
		}
		
		double precio=0.0;
		if(request.getParameter("precio")!=null){
			precio= Double.parseDouble(request.getParameter("precio"))        ;
		}
		
		int fk_categoria=0;
		if (request.getParameter("fk_categoria")!=null) {
			fk_categoria=Integer.parseInt(request.getParameter("fk_categoria"));
		}

		//2 maquetarlos
		Producto prod = new Producto(0, nombre, precio, fk_categoria);
		
		//3 conectar a la BD
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		
		//4 funcionalidad
		db.insertarProducto(con,prod);
		
		List<V_Producto> listaVProducto = db.obtenerTodosVProductos(con);
		List<Categoria> listaCategorias =db.obtenerTodasCategorias(con);
		
		//5 desconectar
		db.desconectar(con);
		
		//6 mochila
		request.setAttribute(ATR_LISTA_VPROD, listaVProducto);
		request.setAttribute(ATR_LISTA_CATEG, listaCategorias);
		
		//7 redireccion
		request.getRequestDispatcher(JSP_INICIO).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
