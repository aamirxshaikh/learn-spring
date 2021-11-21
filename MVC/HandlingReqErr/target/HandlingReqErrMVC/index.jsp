<html>
<head>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
             pageEncoding="ISO-8859-1" isELIgnored="false" %>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>MVC</title>
    <style>
        .form {
            padding-top: 10px;
        }

        .email-field {
            padding-top: 10px;
            padding-bottom: 10px;
        }
    </style>
</head>
<body>
<div>
    <a href="ecommerce/products">View all Products</a>
    <ul>
        <li><a href="ecommerce/products/product1">Product 1</a></li>
        <li><a href="ecommerce/products/product2">Product 2</a></li>
        <li><a href="ecommerce/products/product3">Product 3</a></li>
    </ul>

    <a href="ecommerce/stores">View all Stores</a>

    <ul>
        <li><a href="ecommerce/stores/store1">Store 1</a></li>
        <li><a href="ecommerce/stores/store2">Store 2</a></li>
        <li><a href="ecommerce/stores/store3">Store 3</a></li>
    </ul>
</div>

<div class="form">
    <form action="ecommerce/dashboard">
        <div>
            <label for="name">Name</label>
            <input type="text" name="name" id="name">
        </div>
        <div class="email-field">
            <label for="email">Email</label>
            <input type="email" name="email" id="email">
        </div>
        <div class="submit">
            <input type="submit" name="submit">
        </div>
    </form>
</div>

<div class="form">
    <form action="calculate">
        <div>
            <label for="name">Number 1</label>
            <input type="text" name="number1" id="number1">
        </div>
        <div class="email-field">
            <label for="email">Number 2</label>
            <input type="text" name="number2" id="number2">
        </div>
        <div class="submit">
            <input type="submit" name="submit">
        </div>
    </form>
</div>

</body>
</html>