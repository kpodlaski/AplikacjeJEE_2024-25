<%@ page import="wfis.jee.tomcatsimpleapp.Person" %>
<jsp:useBean id="company" class="wfis.jee.tomcatsimpleapp.Company" scope="application">
<jsp:useBean id="person" class="wfis.jee.tomcatsimpleapp.Person" scope="request">
</jsp:useBean>

<%-- <jsp:setProperty name="person" property="name" param="name" ></jsp:setProperty>
  <jsp:setProperty name="person" property="surname" param="surname"></jsp:setProperty>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>
<%
  String id = request.getParameter("id");
  if (id != null){
    Person p = company.getPersonById(Integer.parseInt(id));
    person.copyFrom(p);
  }
%>
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
