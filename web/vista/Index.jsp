<%-- 
    Document   : Index
    Created on : 02-jun-2020, 12:00:31
    Author     : JOZE RODRIGUEZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <table style="margin: auto;">
            <tr>
                <td>Codigo</td>
                <td>Documento</td>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Categoria</td>
                <td>Salario</td>
            </tr>
        <c:forEach var="p" items="${profesores}">
            
            <tr>
                <td>${p.getCodProfesor()}</td>
                <td>${p.docProfesor}</td>
                <td>${p.nomProfesor}</td>
                <td>${p.apeProfesor}</td>
                <td>${p.cateProfesor}</td>
                <td>${p.salarioProfesor}</td>
            </tr>
            
        </c:forEach>
        </table>
        
        <input type="button" value="btnRegistrar" id="btnRegistrar" name="btnRegistrar" onclick="window.location.href='vista/RegistrarProfesor.jsp'">
               <a href="vista/RegistrarProfesor.jsp">mmmm</a>
    </body> 
</html>
