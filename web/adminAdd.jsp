<%-- 
    Document   : adminEdit
    Created on : Mar 20, 2021, 10:36:21 PM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Add</title>

        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbarAdmin.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">Add Product</h3>
                    <form action="AdminAddServlet" method="post">
                        <table class="table table-striped">
                            <tr>
                                <th>Product ID</th>
                                <th><input type="text" style="width: 1000px" value="" name="ProductID"></th>
                            </tr>                       
                            <tr>
                                <th>Brand ID</th>
                                <th><input type="text" style="width: 1000px" value="" name="BrandID"></th>
                            </tr>
                                                    <tr>
                                <th>Product Name</th>
                                <th><input type="text" style="width: 1000px" value="" name="Name"></th>
                            </tr>
                            <tr>
                                <th>Category ID</th>
                                <th><input type="text" style="width: 1000px" value="" name="CategoryID"></th>
                            </tr>
                            <tr>
                                <th>Price</th>
                                <th><input type="text" style="width: 1000px" value="" name="Price"></th>
                            </tr>
                            <tr>
                                <th>Quantity</th>
                                <th><input type="text" style="width: 1000px" value="" name="Quantity"></th>
                            </tr>
                            <tr>
                                <th>Img_link</th>
                                <th><input type="text" style="width: 1000px" value="" name="Img_link"></th>
                            </tr>
                            <tr>
                                <th>Description</th>
                                <th><input type="text" style="width: 1000px" value="" name="Description"></th>
                            </tr>
                            <tr>
                                <th>Note</th>
                                <th><input type="text" style="width: 1000px" value="" name="Note"></th>
                            </tr>
                            <tr>
                                <th>Status</th>
                                <th><input type="text" style="width: 1000px" value="" name="Status"></th>
                            </tr>

                        </table>
                        <div class="row">
                            <div class="col-md-6 text-end" style="margin-left: 200px">
                               
                                <input class="btn btn-success" type="submit" value="Add Product">
                            </div>
                        </div>
                    </form>    
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>

