<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.10.2024
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="repo" class="wfis.jee.simplewebapp.CarRepo" scope="application"/>
<jsp:useBean id="c" class="wfis.jee.simplewebapp.Car" scope="request"/>
<jsp:setProperty name="c" property="brand" param="marka"/>
<jsp:setProperty name="c" property="year" param="rok"/>
<%
    if (c!=null && c.getBrand() != null && c.getBrand().length()>2){
        repo.addCar(c);
    }
%>

<html>
<head>
    <title>Nowy Samochód</title>
</head>
<body>
<form >
  Marka: <input type="text" id="marka" name="marka"><br>
  Rok Produkcji: <input type="text" id="rok" name="rok"><br>
  <input type="submit">
</form>
</body>
</html>
