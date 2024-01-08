<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.p02.modelo.DAO_Constantes"%>
<%@page import="com.p02.modelo.dto.E_Animal"%>
<%@page import="com.p02.modelo.dto.Especie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
List<E_Animal> listaEAnimal = new ArrayList<E_Animal>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_EANIMALES)!=null){
	listaEAnimal=(List<E_Animal>)request.getAttribute(DAO_Constantes.ATR_LISTA_EANIMALES);
}

List<Especie> listaEspecies = new ArrayList<Especie>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES)!=null){
	listaEspecies=(List<Especie>)request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES);
}

%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<meta charset="ISO-8859-1">
<title>Wild Life</title>
</head>
<body>

	<form method="post" action="InsertarAnimal">
	
		<label for="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre" required placeholder="Nombre del animal">
		
		<br>
		
		<label for="peso">Peso</label>
		<input type="text" id="peso" name="peso" required placeholder="Peso del animal" pattern="\d+(\.\d{1,2})?$" >
		
		<label for="edad">Edad</label>
		<input type="text" id="edad" name="edad" required placeholder="Edad del animal" pattern="^\d+$" >
		
		<br>
		<label for="fk_especie">Especie</label>
		<select id="fk_especie" name="fk_especie">
		<%for(Especie elemento:listaEspecies){ %>
			<option value="<%=elemento.getId()%>"><%=elemento.getEspecie()%></option>
		<%} %>	
		</select>
		
		<input type="submit" value="Enviar">
	</form>

	<table border="1">
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

			<%
			for (E_Animal elemento : listaEAnimal) {
			%>
			<tr>
				<td><%=elemento.getId()%></td>
				<td><%=elemento.getNombre()%></td>
				<td><%=elemento.getPeso()%> KG</td>
				<td><%=elemento.getEdad()%> Años</td>
				<td><%=elemento.getEspecie()%></td>
				<td>
					<a href="BorrarAnimal?id=<%=elemento.getId() %>">Borrar </a>
					&nbsp; 
					<a href="FormModificarAnimal?id=<%=elemento.getId() %>">Modificar </a>
				</td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	
	<br>
	
	<form method="get" action="Ficheros">
    	<button type="submit">Ficheros</button>
  	</form>
</body>
</html>