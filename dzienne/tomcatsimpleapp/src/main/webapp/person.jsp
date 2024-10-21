<%@ page import="wfis.jee.tomcatsimpleapp.Person" %>
<jsp:useBean id="person" class="wfis.jee.tomcatsimpleapp.Person" scope="session">
  <jsp:setProperty name="person" property="name" param="name" ></jsp:setProperty>
  <jsp:setProperty name="person" property="surname" param="surname"></jsp:setProperty>
</jsp:useBean>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<table>
  <tr>
    <td>Imie:</td><td>${person.name}</td>
  </tr>
  <tr>
    <td>Nazwisko:</td><td>${person.surname}</td>
  </tr>
</table>
</body>
</html>
