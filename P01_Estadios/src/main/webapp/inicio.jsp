<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.p02.modelo.dto.Estadio"%>
<%@page import="java.util.List"%>
<%
List<Estadio> listaEstadios = new ArrayList<Estadio>();
if (request.getAttribute("atr_listaestadios") != null) {
 listaEstadios = (List<Estadio>) request.getAttribute("atr_listaestadios");
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
                <th>Afroro</th>
                <th>Fecha Construccion</th>
                <th>Equipo</th>
            </tr>
        </thead>
        <tbody>
        
        <%
        for(Estadio elemento:listaEstadios){
        	
        
        %>
            <tr>
                <td><%=elemento.getId() %></td>
                <td><%=elemento.getNombre() %></td>
                <td><%=elemento.getAforo() %></td>
                <td><%=elemento.getFechaConstruccion() %></td>
                <td><%=elemento.getEquipo() %></td>
            </tr>
        <%   
         }
        %>

            <!-- Puedes agregar más filas según sea necesario -->
        </tbody>
    </table>


</body>
</html>