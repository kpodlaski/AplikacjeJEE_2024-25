<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.10.2024
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="company" class="wfis.jee.tomcatsimpleapp.Company" scope="application"/>
<jsp:useBean id="person" class="wfis.jee.tomcatsimpleapp.Person" scope="request">
</jsp:useBean>
<jsp:setProperty name="person" property="name" param="name" ></jsp:setProperty>
<jsp:setProperty name="person" property="surname" param="surname"></jsp:setProperty>

<html>
<head>
    <title>Dodaj osobę</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String sname = request.getParameter("surname");
    if (name != null && sname!= null){
        company.addPerson(person);
    }
%>
<form>
    Imie: <input type="text" name="name" id="name"><br/>
    Nazwisko: <input type="text" name="surname" id="surname"><br/>
    <input type="submit">
</form>
</body>
</html>
