<%@page import="com.ipartek.modelo.dto.V_Animal"%>
<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="com.ipartek.modelo.dto.Especie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
List<Especie> listaEspecies = new ArrayList<Especie>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES)!=null){
	listaEspecies=(List<Especie>)request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES);
}

List<V_Animal> listaVAnimales = new ArrayList<V_Animal>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_V_ANIMALES)!=null){
	listaVAnimales=(List<V_Animal>)request.getAttribute(DAO_Constantes.ATR_LISTA_V_ANIMALES);
}


%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plantilla</title>
<link rel="stylesheet" href="styles/styles.css">
<link rel="stylesheet" href="styles/styles_index.css">
</head>

<body>

	<%@ include file="includes/cabecera.jsp"%>

	<main>
		
		<section>
			<form action="GuardarAnimal" method="get">
			
				<label for="nombre">Nombre:</label>
				<input type="text" id="nombre" name="nombre" required><br>
				
				<label for="peso">Peso (kg):</label>
				<input type="text" id="peso" name="peso" required pattern="\d+(\.\d{1,2})?$"><br>
				
				<label for="edad">Edad (años):</label>
				<input type="text" id="edad" name="edad" required pattern="^[0-9]+$"><br>
	
				<label for="fk_especie">Especie:</label>
				<select id="fk_especie" name="fk_especie" required>
					<%for(Especie elemento: listaEspecies){ %>
					<option value="<%=elemento.getId() %>"><%= elemento.getEspecie() %></option>
					<%}%>
				</select><br>
				
				<input type="submit" value="Registrar">
			</form>
	
			<form action="" method="get">
				<label for="texto">Buscar:</label>
				<input type="text" id="texto" name="texto" ><br>
				
				<label for="fk_especie">Especie:</label>
				<select id="fk_especie" name="fk_especie" required>
					<option value="0">elige una opcion</option>
					<%for(Especie elemento: listaEspecies){ %>
					<option value="<%=elemento.getId() %>"><%= elemento.getEspecie() %></option>
					<%}%>
				</select><br>
	
				<input type="submit" value="Buscar">
			</form>
		</section>
		
		
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Peso</th>
					<th>Edad</th>
					<th>Especie</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
	
				<%for(V_Animal elemento:listaVAnimales){%>
	
				<tr>
					<td><%=elemento.getId() %></td>
					<td><%=elemento.getNombre() %></td>
					<td><%=elemento.getPeso() %></td>
					<td><%=elemento.getEdad() %></td>
					<td><%=elemento.getEspecie() %></td>
					<td>
						<a href="BorrarAnimal?id=<%=elemento.getId() %>">Borrar</a> 
						<a href="FormModificarAnimal?id=<%=elemento.getId() %>">Modificar</a>
					</td>
	
				</tr>
	
				<%}%>
	
			</tbody>
		</table>
	
	
	
	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>