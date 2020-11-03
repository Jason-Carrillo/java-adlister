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

<form method="post">
    <input type="text" name="username" id="username" placeholder="Username">
    <input type="text" name="password" id="password" placeholder="Password">
    <button type="submit">Submit</button>
</form>

<title>Please login</title>
<c:if test="${param.username.equalsIgnoreCase('admin') && param.password.equals('password')}">
    <meta http-equiv="Refresh" content="0; url='/profile.jsp'" />
</c:if>

</body>
</html>
