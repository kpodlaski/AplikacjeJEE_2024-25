<%@ page import="wfis.jee.simplewebapp.Car" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.10.2024
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="repo" class="wfis.jee.simplewebapp.CarRepo" scope="application"/>
<jsp:useBean id="c" class="wfis.jee.simplewebapp.Car" scope="request"/>
<html>
<head>
    <title>Samochody</title>
</head>
<body>
<table>
    <tr><td>Marka</td><td>Rok produkcji</td></tr>
<%
    String brand = request.getParameter("brand");
    if (brand == null) {
        for (Car ct : repo.getAll() ) {
            out.write("<tr>");
            out.write("<td>" + ct.getBrand() + "</td>");
            out.write("<td>" + ct.getYear() + "</td>");
            out.write("</tr>");
        }
    }
%>
</table>
</body>
</html>
