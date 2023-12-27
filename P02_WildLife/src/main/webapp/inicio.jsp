<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.p02.modelo.DAO_Constantes"%>
<%@page import="com.p02.modelo.dto.E_Animal"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
List<E_Animal> listaEAnimal = new ArrayList<E_Animal>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_EANIMALES)!=null){
	listaEAnimal=(List<E_Animal>)request.getAttribute(DAO_Constantes.ATR_LISTA_EANIMALES);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Wild Life</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Peso</th>
				<th>Edad</th>
				<th>Especie</th>

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
				<td><a href="">
						Borrar </a> <a href="">
						Modificar </a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>