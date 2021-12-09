<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>Events</title>
    <link rel="stylesheet" href="static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="static/assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
</head>

<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient">
    <div class="container"><a class="navbar-brand logo" href="http://localhost:8080/AuthCRUDMySQL/">SpringMVCCRUD</a><button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarNav"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div id="navbarNav" class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="logout.html">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="page landing-page">
    <section class="portfolio-block block-intro">
        <div class="container pb-4">
            <div class="about-me">
                <a class="btn btn-outline-primary" role="button" href="${pageContext.request.contextPath}/events/create">Create an Event</a>
            </div>
        </div>
        <div class="container">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <c:choose>
                        <c:when test="${empty events}">
                            <p>No events created yet !</p>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Details</th>
                                <th>Location</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="event" items="${events}">
                                <tr>
                                    <td>${event.id}</td>
                                    <td>${event.name}</td>
                                    <td>${event.details}</td>
                                    <td>${event.location}</td>
                                    <td>
                                        <input class="btn btn-warning border rounded" onclick="location.href='events/edit/${event.id}'" type="button" value="Edit">
                                        <input class="btn btn-danger border rounded" onclick="location.href='events/delete/${event.id}'" type="button" value="Delete">
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>
<footer class="footer-dark">
    <div class="container pb-4">
        <div class="row">
            <div class="col-sm-6 col-md-3 item">
                <h3>Services</h3>
                <ul>
                    <li><a href="#">Web design</a></li>
                    <li><a href="#">Development</a></li>
                    <li><a href="#">Hosting</a></li>
                </ul>
            </div>
            <div class="col-sm-6 col-md-3 item">
                <h3>About</h3>
                <ul>
                    <li><a href="#">Company</a></li>
                    <li><a href="#">Team</a></li>
                    <li><a href="#">Careers</a></li>
                </ul>
            </div>
            <div class="col-md-6 item text">
                <h3>Company Name</h3>
                <p>Praesent sed lobortis mi. Suspendisse vel placerat ligula. Vivamus ac sem lacus. Ut vehicula rhoncus elementum. Etiam quis tristique lectus. Aliquam in arcu eget velit pulvinar dictum vel in justo.</p>
            </div>
            <div class="col item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a></div>
        </div>
        <p class="copyright">Company Name © 2021</p>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
<script src="static/assets/js/theme.js"></script>
</body>
</html>