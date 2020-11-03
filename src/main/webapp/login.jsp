<%--
  Created by IntelliJ IDEA.
  User: levitrejo
  Date: 11/3/20
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Works but breaks easily if those fields are null, requires too much conditional logic to be useful, better to do this wish JSTL or a servlet--%>
<%--<%! String username, password; %>--%>
<%--<% username = request.getParameter("username"); %>--%>
<%--<% password = request.getParameter("password"); %>--%>
<%--<% if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("password")) { response.sendRedirect("/profile.jsp");}%>--%>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
    <h1>User Login</h1>
    <br>
    <form method="POST" action="login.jsp">
        <input type="text" name="username" placeholder="Enter your email address">
        <input type="password" name="password" placeholder="Enter your password">
        <button type="submit" name="submit">Login</button>
    </form>
    <br>
    <h1>Welcome To The Site!</h1>
    <p>Path: <%= request.getRequestURL() %></p>
    <p>EL param values: ${paramValues}</p>
    <p>Query String: <%= request.getQueryString() %></p>
    <p>EL header values: ${headerValues}</p>
    <p>"username" parameter: <%= request.getParameter("username") %></p>
    <p>"username" EL parameter: ${param.username}</p>
    <p>"password" parameter: <%= request.getParameter("password") %></p>
    <p>"password" EL parameter: ${param.password}</p>
    <p>"method" attribute: <%= request.getMethod() %></p>
    <p>User-Agent header: <%= request.getHeader("user-agent") %></p>
    <p>User-Agent EL header: ${header["user-agent"]}</p>
</body>
</html>
