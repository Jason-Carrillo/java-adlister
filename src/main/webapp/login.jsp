<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 11/3/20
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="partials/navbar.jsp" %>
<%@ include file="partials/head.jsp" %>
<form method="post">
    <input type="text" name="username" placeholder="Username">
    <input type="text" name="password" placeholder="Password">
    <button type="submit">Submit</button>
</form>

<c:if test="${param.username.equalsIgnoreCase('admin') && param.password.equals('password')}">
    <meta http-equiv="Refresh" content="0; url='/profile.jsp'" />
</c:if>

</body>
<%@ include file="partials/footer.jsp" %>
</html>
