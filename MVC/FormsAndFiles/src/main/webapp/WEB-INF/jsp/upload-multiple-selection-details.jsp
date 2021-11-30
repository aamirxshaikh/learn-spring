<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>Details</title>
</head>
<body>
<div>
    <h2>Your Files are Uploaded</h2>
    <div>
        Files:
        <ul>
            <c:forEach var="file" items="${uploads.files}">
                <li>${file.originalFilename}</li>
            </c:forEach>
        </ul>
    </div>

</div>
</body>
</html>