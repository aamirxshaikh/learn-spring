<%--
  Created by IntelliJ IDEA.
  User: aamir
  Date: 08/11/21
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
    <div>
        <h2>Products</h2>

        <table>
            <tr>
                <th>Name</th>
                <th>Category</th>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.name}</td>
                    <td>${product.category}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
