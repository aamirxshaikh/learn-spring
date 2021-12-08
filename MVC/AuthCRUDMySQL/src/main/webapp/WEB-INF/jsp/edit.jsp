<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Edit Event</title>
    <link rel="stylesheet" href="static/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="static/assets/css/Footer-Dark.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <link rel="stylesheet" href="static/assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="static/assets/css/Registration-Form-with-Photo.css">
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
        <div class="container">
            <section class="login-clean">
                <form:form id="event" modelAttribute="event" action="edit" method="post">
                    <h1>Edit Event</h1>
                    <h2 class="visually-hidden">Event Form</h2>
                    <div class="illustration"><i class="icon ion-ios-navigate"></i></div>
                    <form:hidden path="id"/>
                    <div class="mb-3"><form:input class="form-control" type="text" name="name" placeholder="Name" path="name"/><form:errors path="name" class="text-danger"/></div>
                    <div class="mb-3"><form:input class="form-control" type="text" name="details" placeholder="Details" path="details" /><form:errors path="details" class="text-danger"/></div>
                    <div class="mb-3"><form:input class="form-control" type="text" name="location" placeholder="Location" path="location" /><form:errors path="location" class="text-danger"/></div>
                    <div class="mb-3"><form:button name="store" id="store" class="btn btn-primary d-block w-100" type="submit">Update Event</form:button></div>
                </form:form>
            </section>
        </div>
    </section>
</main>
<footer class="footer-dark">
    <div class="container">
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