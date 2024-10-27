<%@ page import="wfis.jee.simplewebapp.Car" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="car" class="wfis.jee.simplewebapp.Car" scope="session"/>
<jsp:setProperty name="car" property="brand" param="marka"/>
<jsp:setProperty name="car" property="year" param="rok"/>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<h2>
    <%
        for (int i=0; i<10; i++){
            out.write("Text "+ i +" <br/>");
        }
    %>
</h2>
Samochód ${car.brand} rok produkcji ${car.year}
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>