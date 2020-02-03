<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>RC-Toys</title>
    <link rel="stylesheet" href="resources/css/index.style.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway&display=swap" rel="stylesheet">
</head>
<body>
<div>
    <ul class="products">
        <#list products as product>
            <!--   1 product   -->
            <li class="product-wrapper">
                <a href="showProduct?productId=${product.getId()}" class="product">
                    <div class="product-photo">
                        <img src="${product.getImgPath()}" alt="">
                    </div>
                    <div class="product-actions">
                        <div class="price">
                            <p>
                            <h2>${product.getPrice()} UAH</h2>
                            </p>
                        </div>
                    </div>
                </a>
            </li>
        </#list>
    </ul>
</div>
<script src="resources/js/script.js"></script>
</body>
</html>