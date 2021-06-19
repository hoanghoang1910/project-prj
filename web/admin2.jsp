<%-- 
    Document   : adminOrderDetails
    Created on : Mar 22, 2021, 12:51:35 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <h3 class="mt-5 mb-3">All Product</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Products Name</th>
                                <th>Product Price</th>                                
                                <th>Category</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.lsProduct}" var="list">
                                <tr>
                                    <td>
                                        <img src="assets/images/products/${list.imgName}" width="60" />
                                    </td>
                                    <td>${list.name}</td>
                                    <td>${list.price}</td>

                                    <td>
                                        ${list.getOne()}
                                    </td>
                                    <td>
                                        <a href="AdminCRUDServlet?id=${list.id}" class="btn btn-primary mt-2" style="width: 100px">Edit</a>
                                    </td>
                                    <td>
                                        <a class="btn btn-danger me-2" href="AdminDeleteServlet?id=${list.id}" style="width: 100px;margin-top: 10.5px">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
