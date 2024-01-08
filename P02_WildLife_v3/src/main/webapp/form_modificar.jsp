<%@page import="com.ipartek.modelo.dto.V_Animal"%>
<%@page import="com.ipartek.modelo.dto.Animal"%>
<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.dto.Especie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
List<Especie> listaEspecies = new ArrayList<Especie>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES)!=null){
	listaEspecies=(List<Especie>)request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES);
}

Animal ani= new Animal();
if(request.getAttribute(DAO_Constantes.ATR_ANIMAL_MODIFICAR)!=null){
	ani=(Animal)request.getAttribute(DAO_Constantes.ATR_ANIMAL_MODIFICAR);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plantilla</title>
<link rel="stylesheet" href="styles/styles.css">
<link rel="stylesheet" href="styles/styles_form_modificar.css">
</head>

<body>

	<%@ include file="includes/cabecera.jsp"%>

	<main>
		
		
		<form action="ModificarAnimal" method="get">
			<h2>Modificar</h2>
			<input type="hidden" id="id" name="id"  value="<%=ani.getId() %>" required><br>
			
			<label for="nombre">Nombre:</label>
			<input type="text" id="nombre" name="nombre"  value="<%=ani.getNombre() %>" required><br>
			
			<label for="peso">Peso (kg):</label>
			<input type="text" id="peso" name="peso" required value="<%=ani.getPeso() %>"  pattern="\d+(\.\d{1,2})?$"><br>
			
			<label for="edad">Edad (años):</label>
			<input type="text" id="edad" name="edad" required value="<%=ani.getEdad() %>"  pattern="^[0-9]+$"><br>

			<label for="fk_especie">Especie:</label>
			<select id="fk_especie" name="fk_especie" required>
				<%for(Especie elemento: listaEspecies){ %>
				<option value="<%=elemento.getId() %>" <%= ani.getFk_especie() == elemento.getId() ? "selected" : "" %> ><%= elemento.getEspecie() %></option>
				<%}%>
			</select><br>
			
			<input type="submit" value="Modificar">
		</form>

	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>