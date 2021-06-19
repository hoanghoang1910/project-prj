
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Hello, world!</title>

        <style>
            a {
                display: block;
                text-decoration: none;
                color: #000;
                text-transform: uppercase;
                font-weight: 500;
            }
            a:hover {
                color: red !important;
            }
            img {
                max-width: 100%;
                max-height: 150px;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>

        <div class="container mt-5">
            <div class="row">
                <c:if test="${lsBrand != null}">
                    <div class="col-md-2">
                        <h5 class="mt-3" style="font-size: xx-large">Brands</h5>
                        <c:forEach items="${requestScope.lsBrand}" var="brand">
                            <a class="mt-3" href="filter?id=${brand.id}&type=1">${brand.name}</a>
                        </c:forEach>

                        <h5 class="mt-5" style="font-size: x-large">Categories</h5>
                        <c:forEach items="${requestScope.lsCategory}" var="category">
                            <a class="mt-3" href="filter?id=${category.id}&type=2">${category.name}</a>
                        </c:forEach>
                    </div>
                </c:if>

                <div class="col-md-10">
                    <div class="row">
                        <c:forEach items="${requestScope.lsProduct}" var="product">
                            <div class="col-md-3 mt-4">
                                <div class="card">
                                    <img src="assets/images/products/${product.imgName}" class="card-img-top" style="max-height:150px;max-width:100%">
                                    <div class="card-body">
                                        <h5 class="card-title">
                                            <a href="product-detail?id=${product.id}" style="text-decoration: none; color: #000; font-size: 18px;">
                                                ${product.name}
                                            </a>
                                        </h5>
                                        <h5>${product.price}$</h5>
                                        <a href="cart?id=${product.id}" class="btn btn-primary mt-2">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="clearfix" style="margin-top: 2%">
                            <ul class="pagination">
                                <c:forEach begin="1" end="${endP}" var="o">
                                    <li class="page-item"><a href="products?pageid=${o}" class="page-link">${o}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="component/footer.jsp" %>



        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
