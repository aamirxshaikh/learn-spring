<%--
  Created by IntelliJ IDEA.
  User: aamir
  Date: 09/11/21
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Stores</title>
</head>
<body>
    <div>
        <h2>Stores</h2>

        <table>
            <tr>
                <th>Name</th>
            </tr>
            <c:forEach items="${stores}" var="store">
                <tr>
                    <td>${store.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
