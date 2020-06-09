<%-- 
    Document   : Actualizar
    Created on : 07-jun-2020, 13:24:24
    Author     : JOZE RODRIGUEZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Formulario de Actualizaciòn</title>
  <meta name="author" content="Jake Rocheleau">
  <link rel="shortcut icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="css/styles.css">
  <link rel="stylesheet" type="text/css" media="all" href="css/switchery.min.css">
  <script type="text/javascript" src="js/switchery.min.js"></script>
</head>

<body>
  <div id="wrapper">
  
  <h1>Formulario de Actualizaciòn </h1>
  
  <form   action="ControladorDB" method="get">
  
      <div class="col-2">
    <label>
      Nombre
      <input value="${profesor.getNomProfesor()}" id="nombre" name="nombre" tabindex="1">
    </label>
  </div>
  <div class="col-2">
    <label>
      Apellido
      <input value="${profesor.getApeProfesor()}" id="apellido" name="apellido" tabindex="2">
    </label>
  </div>
  
  <div class="col-3">
    <label>
      Documento profesor
      <input value="${profesor.getDocProfesor()}" id="documento" name="documento" tabindex="3"  type="number" maxlength="10">
    </label>
  </div>
  <div class="col-3">
    <label>
      Categoria
      <input value="${profesor.getCateProfesor()}" id="categoria" name="categoria" tabindex="4" type="number" max="3" maxlength="1">
    </label>
  </div>
  
  
  <div class="col-3">
    <label>
      Salario
      <input value="${profesor.getSalarioProfesor()}" id="salario" name="salario" tabindex="6" type="number" min="0">
    </label>
  </div>
  
      <input type="hidden" value="ActualizarProfesor" name="instruccion">
      <input type="hidden" value="${profesor.getCodProfesor()}" name="CodigoProfesor">
      
  <div class="col-submit">
      <input type="submit"  value="Actualizar Profesor">
   
  </div>
  
  </form>
  </div>
    
    
    
  <!--  <%/* PrintWriter s=response.getWriter();
       String codProfesor=request.getParameter("cod");
       s.print(codProfesor);
    
    */%>
  -->  

<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

elems.forEach(function(html) {
  var switchery = new Switchery(html);
});
</script>
</body>
</html>
