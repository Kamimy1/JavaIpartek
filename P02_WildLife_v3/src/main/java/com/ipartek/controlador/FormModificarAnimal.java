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


@WebServlet("/FormModificarAnimal")
public class FormModificarAnimal extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public FormModificarAnimal() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = 0;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
	
		Animal ani= db.obtenerAnimalPorId(con, id);
		List<Especie> listaEspecies = db.seleccionarTodasEspecies(con);
	

		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_ESPECIES,listaEspecies);
		request.setAttribute(ATR_ANIMAL_MODIFICAR, ani);
	

		request.getRequestDispatcher(JSP_FORM_MOD).forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
