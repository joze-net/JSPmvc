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
                <td>Accion</td>
            </tr>
        <c:forEach var="p" items="${profesores}">
            
            <c:url var="linkTemporal" value="ControladorDB"><!-- de esta manera usamos tags para enviar datos por medio de una url tmporal-->
                
                <c:param name="instruccion" value="CargarDatos"></c:param>
                <c:param name="codigoProfesor" value="${p.getCodProfesor()}"></c:param>
                
            </c:url>
            
            <tr>
                <td>${p.getCodProfesor()}</td>
                <td>${p.docProfesor}</td>
                <td>${p.nomProfesor}</td>
                <td>${p.apeProfesor}</td>
                <td>${p.cateProfesor}</td>
                <td>${p.salarioProfesor}</td>
                <td><a href="${linkTemporal}">Actualizar</a></td>                                             
             <!--   <td><a href="vista/Actualizar.jsp?cod=${p.getCodProfesor()}">Actualizar</a></td>   asi se puede tambien enviar el codigo a la pagina-->
                
            </tr>
            
        </c:forEach>
            
            <tr>
                <td>
                    <input type="button" value="btnRegistrar"  name="btnRegistrar" onclick="window.location.href='vista/RegistrarProfesor.jsp'">
                </td>
            </tr>
            
        </table>
        
        
              
    </body> 
</html>
