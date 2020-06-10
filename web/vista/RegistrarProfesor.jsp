<%-- 
    Document   : RegistrarProfesor
    Created on : 04-jun-2020, 16:44:22
    Author     : JOZE RODRIGUEZ
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en-US">
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html">
  <title>Formulario de registro</title>
  <meta name="author" content="Jake Rocheleau">
  <link rel="shortcut icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="icon" href="http://static.tmimgcdn.com/img/favicon.ico">
  <link rel="stylesheet" type="text/css" media="all" href="../css/styles.css">
  <link rel="stylesheet" type="text/css" media="all" href="../css/switchery.min.css">
  <script type="text/javascript" src="../js/switchery.min.js"></script>
</head>

<body>
  <div id="wrapper">
  
  <h1>Formulario de registro nuevo </h1>
  
  <form   action="../ControladorDB" method="get">
  <div class="col-2">
    <label>
      Nombre
      <input placeholder="Nombre del profesor" id="nombre" name="nombre" tabindex="1">
    </label>
  </div>
  <div class="col-2">
    <label>
      Apellido
      <input placeholder="Apellido del profesor" id="apellido" name="apellido" tabindex="2">
    </label>
  </div>
  
  <div class="col-3">
    <label>
      Documento profesor
      <input placeholder="numero de documento" id="documento" name="documento" tabindex="3" type="number" max="99999999999">
    </label>
  </div>
  <div class="col-3">
    <label>
      Categoria
      <input placeholder="Categoria profesor" id="categoria" name="categoria" tabindex="4" type="number" max="3" maxlength="1">
    </label>
  </div>
  
  
  <div class="col-3">
    <label>
      Salario
      <input placeholder="Salario de profesor" id="salario" name="salario" tabindex="6" type="number" min="0">
    </label>
  </div>
  
      <input type="hidden" value="RegistrarProfesor" name="instruccion">
  <div class="col-submit">
      <input type="submit"  value="Registrar Profesor">
   
  </div>
  
  </form>
  </div>
<script type="text/javascript">
var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));

elems.forEach(function(html) {
  var switchery = new Switchery(html);
});
</script>
</body>
</html>
