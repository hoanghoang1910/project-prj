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
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Order List</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Customer name</th>
                                <th>Mobile</th>
                                <th>Address</th>
                                <th>Total bill</th>
                                <th>Note</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${requestScope.listO}" var="list">
                                <c:if test="${list.status == 1}">
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
                                        <td>
                                            <a href="AdminOrderDetails?id=${list.id}">More Details</a>
                                            <a href="AdminUpdateOrder?id=${list.id}">Update Order</a>
                                        </td>

                                    </tr>
                                </c:if>
                            </c:forEach>    
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
