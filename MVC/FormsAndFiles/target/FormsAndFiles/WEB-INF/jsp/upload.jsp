<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Upload</title>
</head>
<body>
<div>
    <p class="text-success">${success}</p>

    <div class="form pt-3">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <form:form method="POST" class="pt-2" action="upload" enctype="multipart/form-data">
                        <div class="form-group pb-2"><label for="file">File</label><input class="border rounded border-dark form-control" type="file" name="file" id="file" style="background: rgba(255,255,255,0);" /></div>
                        <div class="form-group pb-2"><label for="name">Name</label><input class="border rounded border-dark form-control" type="text" name="name" id="name" style="background: rgba(255,255,255,0);" /></div>
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