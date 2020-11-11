<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.nbsteam11.service.CreatedTopics"%>

 <%

 String size = request.getParameter("value");
 
   CreatedTopics.submitOnServer(size);
   
   response.sendRedirect("http://localhost:8080/client");
%>