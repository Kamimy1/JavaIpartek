package com.Ejemplo_JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class EjemploGSON
 */
@WebServlet("/EjemploGSON")
public class EjemploGSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EjemploGSON() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Coche coche1 = new Coche("Pontiac","Firebird trans am 1992" , "KITT" ,2 ,2600,false );
		Coche coche2 = new Coche("DMC","DeLorean" , "Outatime" ,2 ,1990,true );
		Coche coche3 = new Coche("Volkswagen","Beetle" , "1234" ,4 ,800 ,false );
		
		Gson gson= new Gson();
		
		List<Coche> listaCoches = new ArrayList<Coche>();
		
		listaCoches.add(coche1);
		listaCoches.add(coche2);
		listaCoches.add(coche3);

		String coche1enJSON = gson.toJson(listaCoches);
		
		System.out.println(coche1enJSON);
		
		String jsonCoche="{\"marca\":\"WAYNE INDUSTRIES\",\"modelo\":\"Batmovil\",\"matricula\":\"i am the night\",\"numPuertas\":2,\"peso\":6600.0,\"esElectrico\":false}";

		System.out.println(jsonCoche);
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
