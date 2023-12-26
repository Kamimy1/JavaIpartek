package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class ModificarProducto
 */
@WebServlet("/FormModificarProducto")
public class FormModificarProducto extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormModificarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int id = 0;
		String idProducto = "";
		
		if(request.getParameter("id")!=null) {
			idProducto = request.getParameter("id");
			id = Integer.parseInt(idProducto);
		}else {
			System.out.println("Hay un error");
		}
		
		System.out.println("ID"+id);
		
		V_Producto producto = db.obtenerProductoPorId(con, id); 
		
		System.out.println(producto.getId());
		
		List<Categoria> listaCategorias = db.obtenerTodasCategorias(con);

		request.setAttribute(ATR_LISTA_VPROD, producto);
		request.setAttribute(ATR_LISTA_CAT, listaCategorias);
		
		
		
		if (request.getParameter("actualizar") != null) {
			id = Integer.parseInt(request.getParameter("id"));
            String nuevoNombre = request.getParameter("nombre");
            double nuevoPrecio = Double.parseDouble(request.getParameter("precio"));
            int nuevaCategoria = Integer.parseInt(request.getParameter("fk_categoria"));
            
            Producto prod = new Producto();
            
            prod.setId(id);
            prod.setNombre(nuevoNombre);
            prod.setPrecio(nuevoPrecio);
            prod.setFk_categoria(nuevaCategoria);
            
            boolean resultado = db.modificarProducto(con, prod);
            
            if(resultado) {
            	V_Producto productoActualizado = db.obtenerProductoPorId(con, id);
               
                request.setAttribute(ATR_LISTA_VPROD, productoActualizado);
                
                request.getRequestDispatcher(JSP_MODIFICAR_PRODUCTO).forward(request, response);
            }
            
        }

		request.getRequestDispatcher(JSP_MODIFICAR_PRODUCTO).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
