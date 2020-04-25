<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin + "/hello";
    var servletURL2 = window.location.origin + "/twoButtons";
    var servletURL3 = window.location.origin + "/assign6";
    var servletURL4 = window.location.origin + "/file";
    var servletURL5 = window.location.origin + "/attributeServlet";
    var servletURL6 = window.location.origin + "/echo";
  </script>
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>Hello Heroku! I am JSP</h2>
<strong>Current Time is</strong>: <%=new Date() %>
<button onclick="window.location.assign(servletURL);"> Try the servlet </button>
<button onclick="window.location.assign(servletURL2);"> Try the next servlet </button>
<button onclick="window.location.assign(servletURL3);"> Try the assign6 servlet </button>
<button onclick="window.location.assign(servletURL4);"> Try the in-class exercise (4/14) persistence file servlet </button>
<button onclick="window.location.assign(servletURL5);"> Try the attribute servlet </button>
<button onclick="window.location.assign(servletURL6);"> Try the echo page </button>
    
</body>
</html>
