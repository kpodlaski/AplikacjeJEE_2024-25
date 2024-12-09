
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Position" %>
<jsp:useBean id="dao" class="dao.jpa.DAO" scope="application">
</jsp:useBean>

<%-- <jsp:setProperty name="person" property="name" param="name" ></jsp:setProperty>
  <jsp:setProperty name="person" property="surname" param="surname"></jsp:setProperty>
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Positions</title>
</head>
<body>
<%
  String id = request.getParameter("id");
  List<Position> positions = new ArrayList<>();
  if (id != null){
    Position p = dao.getPosition(Integer.parseInt(id));
    if (p != null)
      positions.add(p);
  }
  else{
    positions = dao.getAllPositions();
  }
%>
<table>
<%
  for (Position p : positions){
%>
  <tr>
    <td>Nazwa:</td><td><%=p.getName()%></td>
  </tr>
<%
    }
%>
</table>
</body>
</html>
