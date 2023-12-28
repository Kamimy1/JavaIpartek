<%@page import="com.ipartek.modelo.dto.Categoria"%>
<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
List<V_Producto> listaVProducto = new ArrayList<V_Producto>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_VPROD)!=null){
	listaVProducto=(List<V_Producto>)request.getAttribute(DAO_Constantes.ATR_LISTA_VPROD);
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


	<form method="post" action="InsertarProducto">
	
		<label for="nombre">Titulo</label>
		<input type="text" id="nombre" name="nombre" required placeholder="Titulo del comic">
		
		<br>
		
		<!--  
		<label for="precio">Precio</label>
		<input type="number" step="0.01" id="precio" name="precio" required placeholder="Precio del comic">
		-->
		<label for="precio">Precio</label>
		<input type="text" id="precio" name="precio"  placeholder="Precio del comic" pattern="\d+(\.\d{1,2})?$" required>
		
		<br>
		<label for="fk_categoria">Categoria</label>
		<select id="fk_categoria" name="fk_categoria">
		<%for(Categoria elemento:listaCategorias){ %>
			<option value="<%=elemento.getId()%>"><%=elemento.getCategoria()%></option>
		<%} %>	
		</select>
		
		<input type="submit" value="Enviar">
	</form>

	
	
	
	
	
	
	<table border="1">
	    <thead>
	        <tr>
	            <th>ID</th>
	            <th>Nombre</th>
	            <th>Precio</th>
	           
	            <th>Categoria</th>
	            <th>Opciones</th>
	        </tr>
	    </thead>
	    <tbody>
	    
	    <% for(V_Producto elemento:listaVProducto){%>
	        <tr>
	            <td><%=elemento.getId() %></td>
	            <td><%=elemento.getNombre() %></td>
	            <td><%=elemento.getPrecio() %> Euros</td>
	           
	            <td><%=elemento.getCategoria() %></td>
	            <td>
	            	<a href="BorrarProducto?id=<%=elemento.getId() %>">
	            	borrar
	            	</a> 
	            	
	            	
	            	<a href="FormModificarProducto?id=<%=elemento.getId() %>">
	            	Modificar
	            	</a>  
	            </td>
	        </tr>
	     <%}%>  
	        
	    </tbody>
	</table>
	

</body>
</html>




