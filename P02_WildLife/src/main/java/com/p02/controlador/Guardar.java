package com.p02.controlador;

import java.io.FileWriter;
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
 * Servlet implementation class Guardar
 */
@WebServlet("/Guardar")
public class Guardar extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guardar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<E_Animal> listEAnimal = db.obtenerTodosEAnimales(con);
		
		try (FileWriter fileWriter = new FileWriter("D:\\JavaIpartek\\P02_WildLife\\Fichero.csv")) {
		    StringBuilder sb = new StringBuilder();
		    sb.append("ID;Nombre;Peso;Edad;Especie\n");

		    for (E_Animal animal : listEAnimal) {
		        sb.append(animal.getId()).append(";")
		          .append(animal.getNombre()).append(";")
		          .append(animal.getPeso()).append("KG;")
		          .append(animal.getEdad()).append("Años;")
		          .append(animal.getEspecie()).append("\n");
		    }

		    fileWriter.write(sb.toString());
		} catch (IOException e) {
		    e.printStackTrace();
		}

		
		db.desconectar(con);
		
		request.getRequestDispatcher(JSP_FICHEROS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
