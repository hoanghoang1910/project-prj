<%-- 
    Document   : cart
    Created on : Mar 2, 2021, 8:22:38 PM
    Author     : AnhDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Giỏ hàng</title>
        
        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>

        <c:choose>
            <c:when test="${sessionScope.listCart eq null}">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center mt-5">
                            <h4>Không có sản phẩm nào trong giỏ hàng.</h4>
                            <a class="btn btn-info mt-3" href="products">Tiếp tục mua hàng</a>
                        </div>                       
                    </div>                   
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="mt-5 mb-3">Giỏ hàng</h3>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Hình ảnh</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Giá</th>
                                        <th>Số lượng</th>
                                        <th>Số tiền</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${sessionScope.listCart}" var="cart">
                                        <tr>
                                            <td>
                                                <img src="assets/images/products/${cart.imgName}" width="60" />
                                            </td>
                                            <td>${cart.name}</td>
                                            <td>${cart.price}</td>
                                            <td>
                                                <a class="me-3" href="update-cart?flag=1&id=${cart.id}" >&nbsp;</a>
                                                ${cart.quantity}
                                                <a class="ms-3" href="update-cart?flag=2&id=${cart.id}" >&nbsp;</a>
                                            </td>
                                            <td>
                                                <fmt:formatNumber type="currency" currencySymbol="đ" value="${cart.price * cart.quantity}" />
                                            </td>
                                            <td>
                                                <a href="remove-cart?id=${cart.id}">Xoá</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <a class="btn btn-info" href="products">Tiếp tục mua hàng</a>
                        </div>
                        <div class="col-md-6 text-end">
                            <b class="me-4">
                                Tổng tiền:
                                <fmt:formatNumber type="currency" currencySymbol="đ" value="${sessionScope.totalMoney}" />
                            </b>
                            <a class="btn btn-danger me-2" href="remove-cart?id=0">Xoá tất cả</a>
                            <a class="btn btn-success" href="checkout.jsp">Tiếp tục</a>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
