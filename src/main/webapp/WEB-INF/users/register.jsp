<%--
  Created by IntelliJ IDEA.
  User: levitrejo
  Date: 11/10/20
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Register a New User" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Register a New User</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="title">Username</label>
            <input id="title" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Email Address</label>
            <input id="description" name="email" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="title">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>

