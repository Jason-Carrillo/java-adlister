<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 11/4/20
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ads</title>
</head>
<ul>
    <c:forEach var="ad" items="${ads}">
        <div class="ad">
            <h1>${ad.title}</h1>
            <h4>${ad.description}</h4>
            <hr>
        </div>
    </c:forEach>
</ul>

</html>
