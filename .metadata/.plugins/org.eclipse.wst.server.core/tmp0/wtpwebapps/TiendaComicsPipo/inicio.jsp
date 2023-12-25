<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ambm.modelo.dto.V_Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
List<V_Producto> listaProductos = new ArrayList<V_Producto>();
if (request.getAttribute("atr_listaproductos") != null) {
	listaProductos = (List<V_Producto>) request.getAttribute("atr_listaproductos");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar</title>
</head>
<body>

	<form method="get" action="">
	
		<label for="bnombre">Titulo del comic</label>
		<input type="text" id="nombre" name="nombre" required placeholder="Nombre del comic"/>
		
		<br/>
		
		<!--  <label for="precio">Precio</label>
		<input type="number" step="0.01" id="precio" name="precio" required placeholder="Precio del comic"/> -->
		
		<label for="precio">Precio</label>
		<input type="text" id="precio" name="precio" required placeholder="Precio del comic" pattern="^\d+(\.\d{1,2})?$"/> 
		
		<br/>
		
		<label for="fk_categoria">Elige la categoría</label>

		<select name="fk_categoria" id="fk_categoria">
		  <option value="1">Comic Americano</option>
		  <option value="2">Tebeo</option>
		  <option value="3">Manga</option>
		  <option value="4">Novela grafica</option>
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
			</tr>
		</thead>
		<tbody>

			<%
			for (V_Producto elemento : listaProductos) {
			%>
			<tr>
				<td><%=elemento.getId()%></td>
				<td><%=elemento.getNombre()%></td>
				<td><%=elemento.getPrecio()%></td>
				<td><%=elemento.getCategoria()%></td>
			</tr>
			<%
			}
			%>

			<!-- Puedes agregar más filas según sea necesario -->
		</tbody>
	</table>


</body>
</html>