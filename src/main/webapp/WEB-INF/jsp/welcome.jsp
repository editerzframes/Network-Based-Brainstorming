<%@page import="com.nbsteam11.service.CreatedTopics"
import="com.nbsteam11.service.establishCon"
import="java.sql.Connection"
import="java.sql.DriverManager"
import="java.sql.ResultSet"
import="java.sql.SQLException"
import="java.sql.Statement"
import="java.sql.Timestamp"
%>

<html>

<head>
<title>Welcome Screen</title>
</head>
<style>

body{
   background-color: #f7fcff;
    margin-top: 0px; 
    margin-bottom: 0px; 
    margin-left: 0px; 
    margin-right: 0px;
    padding: 0;
}

#main {
width:960px;
margin:50px auto;
font-family:raleway
}

#profile {
padding:50px;
border:1px dashed grey;
font-size:20px;
background-color:#DCE6F7
}
#logout {
float:right;
padding:5px;
border:dashed 1px gray
}
a {
text-decoration:none;
color:#6495ed
}


/*~~~~~~~~~~~~~~second Header~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
#top-text{
    background-color:#1c599a;
    border-top:5px solid #053364;
    border-bottom:28px solid #1c599a;
    margin-top: 0 auto;
    position:relative;
text-align: center;
    color: white;
}
.logo {
    width: 100px;
    height: 100px;
    content: src("https://i.ibb.co/GF5dFsS/ED.png");
}

.textheader2{
    padding-left: 250px;
}

.textheader2-1size{
    font-size: 30px;
}
.textheader2-2size{
    font-size: 20px; 
}


.floatLeft { float: left; 
margin-top: 13px;
margin-left: 50px;
margin-bottom: 20px}

.header2button {
  background-color: #053364;
  color: white;
  font-size: 12px;
    height: 30px;
    width: 100px;
    color: white;
    float: right;
}
.header2button-login{
     margin-top: 40px;
    margin-right: 20px;
}
.header2button-register{
     margin-top: 40px;
    margin-right: 120px;
}

.button {
  position: relative;
  background-color: #2bbbbb;
  border: none;
  font-size: 16px;
  color: #FFFFFF;
  padding: 20px;
    margin: 4px 2px;
  width: 200px;
  text-align: center;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

.button:after {
  content: "";
  background: #f1f1f1;
  display: block;
  position: absolute;
  padding-top: 300%;
  padding-left: 350%;
  margin-left: -20px !important;
  margin-top: -120%;
  opacity: 0;
  transition: all 0.8s
}

.button:active:after {
  padding: 0;
  margin: 0;
  opacity: 1;
  transition: 0s
}
.button:hover {
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
table {
  width:100%;
  margin-top:30px;
}
table, th, td {
  border: 2px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
  text-align: left;
}
th{
background-color:#2a5a8d;
}
</style>
<body>
   <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~SECOND HEADER~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  -->
  <div id="top-text">
    <img src="https://i.ibb.co/GF5dFsS/ED.png" class="floatLeft" alt="ED" width="100px" height="100px">
      
    <h1 class="textheader2 textheader2-1size" style="text-align:left">Project 2</h1>
    <h2 class="textheader2 textheader2-2size" style="text-align:left">Network Based Brainstorming</h2>
    </div>
<!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
 
<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
<div id="profile">
<b id="welcome">Welcome : <i>${name}</i></b>
<b id="logout"><a href="http://localhost:8080/index">Log Out</a></b>
</div>
    
<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

<table>
<tr><th>#</th><th>Topic</th><th>Submission Date</th><th>Submission Time</th><th>Client#</th><th>Status</th><th>Approve</th></tr>


<%
Connection conn = establishCon.estcon();

String topic_name = null;
String topic_des = null;
Timestamp topic_date = null;
Timestamp topic_time = null;
String client_no = null;
String status = null;
int id = 0;

String ret = "Select * from admin_topic where status='pending';";

Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(ret);

while (rs.next()) {
	topic_name = rs.getString("topic_name");
	topic_des = rs.getString("topic_description");
	id = rs.getInt("topic_ID");
	topic_date = rs.getTimestamp("submission_date");
	topic_time = rs.getTimestamp("submission_time");
	client_no = rs.getString("client_no");
	status = rs.getString("status");
	%>
	   
   
<tr><td><%= id%></td><td><%= topic_name%></td><td><%= topic_date%></td><td><%= topic_time%></td><td><%= client_no%></td><td><%= status%></td><td><button onClick="updatefun()" id="<%= id%>">Approve</button><button style="margin-left:10px" onClick="updatefun2()" id="<%= id%>">Dis-Approve</button></td></tr>

	<% } %>
</table>


<button class="button" style="margin-bottom:30px" onClick="alertbox()">Sessions</button>

<script>
function alertbox(){
	
     window.location = "http://localhost:8080/sessionAdmin";
}

function updatefun(){
	var txt;
    var e = window.event,
     btn = e.target || e.srcElement;
    window.location = "http://localhost:8080/approveAdminTopic?value=" + btn.id;

}
function updatefun2(){
	var txt;
    var e = window.event,
     btn = e.target || e.srcElement;
    window.location = "http://localhost:8080/disapproveAdminTopic?value=" + btn.id;
}
</script>
</body>
</html>