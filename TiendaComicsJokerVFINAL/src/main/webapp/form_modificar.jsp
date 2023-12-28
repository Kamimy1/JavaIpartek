<%@page import="javax.lang.model.element.Element"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="com.ipartek.modelo.dto.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
Producto prod= new Producto();
if(request.getAttribute(DAO_Constantes.ATR_PROD)!=null){
	prod=(Producto)request.getAttribute(DAO_Constantes.ATR_PROD);
}


List<Categoria> listaCategorias = new ArrayList<Categoria>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_CATEG)!=null){
	listaCategorias=(List<Categoria>)request.getAttribute(DAO_Constantes.ATR_LISTA_CATEG);
}

%>   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="ModificarProducto">
	
		<label for="id">Id</label>
		<input type="text" id="id" name="id" required readonly value="<%= prod.getId()%>">
		
		<br>

		<label for="nombre">Titulo</label>
		<input type="text" id="nombre" name="nombre" required value="<%= prod.getNombre()%>">
		
		<br>
		
		<label for="precio">Precio</label>
		<input type="text" id="precio" name="precio"  value="<%= prod.getPrecio()%>" pattern="\d+(\.\d{1,2})?$" required>
		
		<br>
		
		<label for="fk_categoria">Categoria</label>
		<select id="fk_categoria" name="fk_categoria">
		<%for(Categoria elemento:listaCategorias){ %>
			<option value="<%=elemento.getId()%>" <%= prod.getFk_categoria() == elemento.getId() ? "selected" : "" %>  ><%=elemento.getCategoria()%></option>
		<%} %>	
		</select>
		
		<input type="submit" value="Enviar">
	</form>

</body>
</html>