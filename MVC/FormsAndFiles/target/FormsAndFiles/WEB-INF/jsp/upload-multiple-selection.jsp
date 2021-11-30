<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Upload Multiple Selection</title>
</head>
<body>
<div>
    <h2>Upload Multiple Selection</h2>

<%--    <form:form modelAttribute="uploads" action="upload-multiple-selection" method="POST" enctype="multipart/form-data">--%>
<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>Select files</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Enter Name</td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <input type="file" name="files" multiple="multiple">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <input type="submit" id="submit">--%>
<%--                    <input type="reset" id="reset">--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form:form>--%>
    <div class="form pt-3">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <form:form modelAttribute="uploads" action="upload-multiple-selection" method="POST" enctype="multipart/form-data">
                        <div class="form-group pb-2"><label for="files">Files</label><input multiple="multiple" class="border rounded border-dark form-control" type="file" name="files" id="files" style="background: rgba(255,255,255,0);" /></div>

                        <div class="form-group text-right"><input class="btn btn-primary text-light" type="submit" value="Submit" /></div>
                        <div class="form-group text-right"><input class="btn btn-danger text-light" type="reset" value="Reset" /></div>
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