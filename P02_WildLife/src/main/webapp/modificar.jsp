<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.p02.modelo.DAO_Constantes"%>
<%@page import="com.p02.modelo.dto.Animal"%>
<%@page import="com.p02.modelo.dto.Especie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>    
<%
Animal anim= new Animal();
if(request.getAttribute(DAO_Constantes.ATR_ANIMAL)!=null){
	anim=(Animal)request.getAttribute(DAO_Constantes.ATR_ANIMAL);
}

List<Especie> listaEspecies = new ArrayList<Especie>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES)!=null){
	listaEspecies=(List<Especie>)request.getAttribute(DAO_Constantes.ATR_LISTA_ESPECIES);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/style.css">
<title>Modificar Animal</title>
</head>
<body>

<form method="post" action="ModificarAnimal">
	
		<label for="id">Id</label>
		<input type="text" id="id" name="id" required readonly value="<%= anim.getId()%>">
		
		<br>

		<label for="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre" required value="<%= anim.getNombre()%>">
		
		<br>
		
		<label for="peso">Peso</label>
		<input type="text" id="peso" name="peso" required value="<%= anim.getPeso()%>" placeholder="Peso del animal" pattern="\d+(\.\d{1,2})?$" >
		
		<label for="edad">Edad</label>
		<input type="text" id="edad" name="edad" required value="<%= anim.getEdad()%>"  placeholder="Edad del animal" pattern="^\d+$" >
		
		<br>
		<label for="fk_especie">Especie</label>
		<select id="fk_especie" name="fk_especie">
		<%for(Especie elemento:listaEspecies){ %>
			<option value="<%=elemento.getId()%>"<%= anim.getFk_especie() == elemento.getId() ? "selected" : "" %>><%=elemento.getEspecie()%></option>
		<%} %>	
		</select>
		
		<input type="submit" value="Enviar">
</form>

</body>
</html>