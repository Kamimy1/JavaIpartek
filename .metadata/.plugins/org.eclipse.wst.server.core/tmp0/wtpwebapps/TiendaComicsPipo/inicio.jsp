<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.ambm.modelo.dto.Producto"%>
<%@page import="java.util.List"%>
<%
List<Producto> listaProductos = new ArrayList<Producto>();
if (request.getAttribute("atr_listaproductos") != null) {
 listaProductos = (List<Producto>) request.getAttribute("atr_listaproductos");
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>FK_Categor�a</th>
            </tr>
        </thead>
        <tbody>
        
        <%
        for(Producto elemento:listaProductos){
        	
        
        %>
            <tr>
                <td><%=elemento.getId() %></td>
                <td><%=elemento.getNombre() %></td>
                <td><%=elemento.getPrecio() %></td>
                <td><%=elemento.getFk_categoria() %></td>
            </tr>
        <%   
         }
        %>

            <!-- Puedes agregar m�s filas seg�n sea necesario -->
        </tbody>
    </table>


</body>
</html>