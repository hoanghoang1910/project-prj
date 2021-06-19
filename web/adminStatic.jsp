<%-- 
    Document   : adminOrder
    Created on : Mar 21, 2021, 11:39:23 PM
    Author     : Acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <%@ include file="component/navbarAdmin.jsp" %>
        <div class="container" style="margin-bottom: -100px">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">${requestScope.currentDate} details :</h3>
                </div>
            </div>
        </div>
        <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4" style="margin-top: 100px; margin-left: 100px">
                <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                    Today income</div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">${requestScope.incomeToday} $</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-calendar fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4" style="margin-top: 100px">
                <div class="card border-left-success shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                    This month income</div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">${requestScope.incomeThisMonth} $</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4" style="margin-top: 100px">
                <div class="card border-left-success shadow h-100 py-2">
                    <div class="card-body">
                        <div class="row no-gutters align-items-center">
                            <div class="col mr-2">
                                <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                    Total orders today</div>
                                <div class="h5 mb-0 font-weight-bold text-gray-800">${requestScope.numberOrder} order(s)</div>
                            </div>
                            <div class="col-auto">
                                <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Today orders</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Customer name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                                <th>Total bill</th>
                                <th>Note</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${requestScope.todayOrder}" var="list">

                                <tr>
                                    <td>
                                        ${list.name}
                                    </td>
                                    <td>${list.mobile}</td>
                                    <td>${list.address}</td>
                                    <td>
                                        ${list.totalPrice}
                                    </td>
                                    <td>
                                        ${list.note}
                                    </td>                                      
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            </div>
        </div>                   


        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Most order date : ${highOrderDate}</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Customer name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                                <th>Total bill</th>
                                <th>Note</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${requestScope.order}" var="list">

                                <tr>
                                    <td>
                                        ${list.name}
                                    </td>
                                    <td>${list.mobile}</td>
                                    <td>${list.address}</td>
                                    <td>
                                        ${list.totalPrice}
                                    </td>
                                    <td>
                                        ${list.note}
                                    </td>                                      
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Top 5 customer</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Customer name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                                <th>Total bill</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${requestScope.customer}" var="list2">

                                <tr>
                                    <td>
                                        ${list2.name}
                                    </td>
                                    <td>${list2.mobile}</td>
                                    <td>${list2.address}</td>
                                    <td>
                                        ${list2.totalPrice}
                                    </td>                                     
                                </tr>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Top 5 best seller</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Hình ảnh</th>
                                <th>Tên sản phẩm</th>
                                <th>Giá</th>
                                <th>Danh mục</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.productLS}" var="productl" >
                                <tr>
                                    <td>
                                        <img src="assets/images/products/${productl.imgName}" width="60" />
                                    </td>
                                    <td>${productl.name}</td>
                                    <td>${productl.price}</td>
                                    <td>
                                        ${productl.getOne()}
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
