<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ipartek.controlador.FormModificarProducto"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.modelo.dto.Categoria"%>
    
<%
    V_Producto producto = new V_Producto();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_VPROD)!=null){
	producto=(V_Producto)request.getAttribute(DAO_Constantes.ATR_LISTA_VPROD);
}

%>

<%
List<Categoria> listaCategorias = new ArrayList<Categoria>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_CAT)!=null){
 listaCategorias=(List<Categoria>)request.getAttribute(DAO_Constantes.ATR_LISTA_CAT);
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="FormModificarProducto">
	
		<label for="id">ID</label>
		<input type="text" id="id" name="id" value="<%= producto.getId() %>" required placeholder="Id del comic" readonly>
		
		<br>
	
		<label for="nombre">Titulo</label>
		<input type="text" id="nombre" name="nombre" value="<%= producto.getNombre() %>" required placeholder="Titulo del comic">
		
		<br>
		
		<!--  
		<label for="precio">Precio</label>
		<input type="number" step="0.01" id="precio" name="precio" required placeholder="Precio del comic">
		-->
		<label for="precio">Precio</label>
		<input type="text" id="precio" name="precio" value="<%= producto.getPrecio() %>"  placeholder="Precio del comic" pattern="\d+(\.\d{1,2})?$" required>
		
		<br>
		<label for="fk_categoria">Categoria</label>
		<select id="fk_categoria" name="fk_categoria">
		    <% for (Categoria elemento : listaCategorias) { %>
		        <option value="<%= elemento.getId() %>" <% if (elemento.getId() == producto.getFk_categoria()) { %> selected <% } %>>
		            <%= elemento.getCategoria() %>
		        </option>
		    <% } %>
		</select>

		
		<input type="submit" name="actualizar" value="Enviar">
	</form>

</body>
</html>