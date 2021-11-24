<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><html>
<head>
    <title>Confirmation</title>
</head>
<body>
<div>
    <h2>Your Registration is Confirmed</h2>
    <div>First Name: ${registration.firstName}</div>
    <div>Last Name: ${registration.lastName}</div>
    <div>Gender: ${registration.gender}</div>
    <div>Email: ${registration.email}</div>
    <div>Age: ${registration.age}</div>
    <div>Interest: ${registration.interest}</div>
    <div>
        Skills:
        <ul>
            <c:forEach var="skill" items="${registration.skills}">
                <li>${skill}</li>
            </c:forEach>
        </ul>
    </div>

</div>
</body>
</html>