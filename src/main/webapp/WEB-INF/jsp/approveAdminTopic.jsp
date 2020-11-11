<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.nbsteam11.service.AdminTopics"%>

 <%

 String size = request.getParameter("value");
 
   AdminTopics.removeTopic(size);
   response.sendRedirect("http://localhost:8080/welcome");
%>