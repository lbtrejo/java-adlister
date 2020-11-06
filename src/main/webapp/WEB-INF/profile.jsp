<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Viewing ${user}'s profile.</h1>
        <p>Is an admin: ${isAdmin}</p>
    </div>
    <div class="container">
        <form action="/logout" method="GET">
            <button type="submit" class="btn btn-primary">Logout</button>
        </form>
    </div>


</body>
</html>
