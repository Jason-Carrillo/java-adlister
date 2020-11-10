<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 11/10/20
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Create a new Ad</h1>
    <form action="/register.jsp" method="post">
        <div class="form-group">
            <label for="username">Name</label>
            <input id="username" name="username" class="form-control" type="input">
        </div>
        <div class="form-group">
            <label for="email">Name</label>
            <input id="email" name="email" class="form-control" type="input">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <textarea id="password" name="password" class="form-control" type="input"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
</body>
</html>