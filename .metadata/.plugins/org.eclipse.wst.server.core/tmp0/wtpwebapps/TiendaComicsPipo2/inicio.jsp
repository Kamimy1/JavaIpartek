<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Insert title here</title>
</head>
<body>
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
                for(V_Producto elemento:listaProductos){
                %>
            <tr>
                <td><%=elemento.getId() %></td>
                <td><%=elemento.getNombre() %></td>
                <td><%=elemento.getPrecio() %></td>
                <td><%=elemento.getCategoria() %></td>
            </tr>
        <%   
         }
        %>

            <!-- Puedes agregar m�s filas seg�n sea necesario -->
        </tbody>
    </table>

</body>
</html>