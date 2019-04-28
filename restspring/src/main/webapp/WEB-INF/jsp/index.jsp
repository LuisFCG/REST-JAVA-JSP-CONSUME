<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP</title>

</head>
<body>
<form action="datoconsultado" method="post">
Ingrese su nombre:
<input type="text" name="name" size="20">
<br>
<input type="submit" value="enviar">
</form>

<h2>Nombre: ${name}</h2>
<h2>Mensaje: ${message}</h2>

</body>
</html>