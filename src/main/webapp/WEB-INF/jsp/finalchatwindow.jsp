<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.nbsteam11.service.AdminTopics"%>
<%@ page import="com.nbsteam11.main.Server"%>
<%@ page import="com.nbsteam11.main.Client"%>
 
 <%

 String size = request.getParameter("value");
 AdminTopics.startTop(size);
 String role = request.getParameter("role");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHAT WINDOW</title>
</head>
<body>
<textarea rows="20" cols="30"> </textarea>
<input type = "submit" name = "submit" value = "SEND">
<button onClick="updatefun()" id="<%= role%>">Start Brainstorming!!</button>


 <script>

 function updatefun(){
 	var txt;
     var e = window.event,
      btn = e.target || e.srcElement;
     window.location = "http://localhost:8080/chat_window_admin?value=" + btn.id;

 }
 </script> 
 

</body>
</html>