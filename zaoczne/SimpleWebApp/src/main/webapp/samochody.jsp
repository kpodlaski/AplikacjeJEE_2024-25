<%@ page import="wfis.jee.simplewebapp.Car" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.10.2024
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="car" class="wfis.jee.simplewebapp.Car" scope="session"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! wfis.jee.simplewebapp.Car c = new Car(); %>
<% c.setBrand("XYZ"); %>
Samochód ${car.brand} rok produkcji ${car.year} </>br>
S2 ${c.brand}
</body>
</html>
