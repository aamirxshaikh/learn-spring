<html>
<head>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1" isELIgnored="false" %>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Forms</title>
</head>
<body>
<a href="user/register">Register User</a>
<div>
<%--    <a href="user/upload">Upload Document</a>--%>
    <input type="button" onclick="location.href='user/upload'" value="Upload Document">

    <input type="button" onclick="location.href='user/upload-multiple'" value="Upload Multiple Document">

</div>
</body>
</html>