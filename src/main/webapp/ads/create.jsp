<%--
  Created by IntelliJ IDEA.
  User: levitrejo
  Date: 11/5/20
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Add an Ad"/>
    </jsp:include>
</head>
<body class="bg-dark">
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container">
        <h1 class="text-red">Add Your Ad</h1>
        <form action="/create" method="POST">
            <div class="form-group">
                <label for="title" class="text-green">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description" class="text-blue">Description</label>
                <input id="description" name="description" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="userId" class="text-green">Select your User ID</label>
                <select class="form-control" id="userId" name="userId">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <div class="form-group">
                <label for="adId" class="text-blue">adID</label>
                <input id="adId" name="adId" class="form-control" type="text">
            </div>
            <input type="submit" class="btn btn-success btn-block" value="Post Your Ad">
        </form>
    </div>

</body>
</html>
