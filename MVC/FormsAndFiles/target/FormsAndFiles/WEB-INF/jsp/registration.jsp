<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>
<div>
    <div class="form pt-3">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <form:form class="pt-2" action="submit" modelAttribute="registration">
                        <div class="form-group pb-2"><form:input path="firstName" class="border rounded border-dark form-control" type="text" name="first-name" placeholder="First Name" style="background: rgba(255,255,255,0);" /></div>
                        <div class="form-group pb-2"><form:input path="lastName" class="border rounded border-dark form-control" type="text" name="last-name" placeholder="Last Name" style="background: rgba(255,255,255,0);" /></div>
                        <div class="form-group pb-2">
                            <div class="form-check"><form:radiobutton path="gender" value="Male" class="form-check-input" /><label class="form-check-label">Male</label></div>
                            <div class="form-check"><form:radiobutton path="gender" value="Female" class="form-check-input" /><label class="form-check-label">Female</label></div>
                        </div>
                        <div class="form-group pb-2"><form:input path="email" class="border rounded border-dark form-control" type="email" name="email" placeholder="E-mail" style="background: rgba(255,255,255,0);" /></div>
                        <div class="form-group pb-2">
                            <div class="form-check"><form:checkbox path="skills" value="Spring Boot" class="form-check-input" /><label class="form-check-label">Spring Boot</label></div>
                            <div class="form-check"><form:checkbox path="skills" value="React" class="form-check-input" /><label class="form-check-label">React</label></div>
                        </div>
                        <div class="form-group text-right"><button class="btn btn-primary text-light" type="submit" value="submit">Submit</button></div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>