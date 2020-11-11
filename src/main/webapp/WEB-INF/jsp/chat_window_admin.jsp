<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.nbsteam11.service.AdminTopics"%>
<%@ page import="com.nbsteam11.main.Server"%>
<%@ page import="com.nbsteam11.main.Client"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHAT WINDOW</title>
</head>
<body>
<textarea rows="20" cols="30"> </textarea>
<input type = "submit" name = "submit" value = "SEND">
</body>
</html>
 <%

 String size = request.getParameter("value");
 
   
   String[] arguments = new String[] {"123"};
  
   if(size.equals("admin")){
	   Server.main(arguments);
   }
   else{
	   Client.main(arguments);
   } 
  
%>