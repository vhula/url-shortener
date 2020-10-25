<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shorten URL</title>
</head>
<body>
<h1>url <% out.println(request.getParameter("url-to-shorten")); %></h1>
<br/>
<h1>shortened url <a href="<% out.println(request.getAttribute("shortened-url")); %>"><% out.println(request.getAttribute("shortened-url")); %></a> </h1>
</body>
</html>
