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
                    <h3 class="mt-5 mb-3">Edit Order</h3>
                    <form action="AdminUpdateOrder" method="post">
                        <table class="table table-striped">
                            <tr style="display: none">
                                <th>Order id</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.id}" name="OrderId"></th>
                            </tr>
                            <tr>
                                <th>Customer name</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.name}" name="CustomerName"></th>
                            </tr>                       
                            <tr>
                                <th>Mobile</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.mobile}" name="Mobile"></th>
                            </tr>
                            <tr>
                                <th>Address</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.address}" name="Address"></th>
                            </tr>
                            <tr>
                                <th>Total bill</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.totalPrice}" name="TotalBill"></th>
                            </tr>
                            <tr>
                                <th>Note</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.note}" name="Note"></th>
                            </tr>
                            <tr>
                                <th>Status (0/1)</th>
                                <th><input type="text" style="width: 1000px" value="${requestScope.order.status}" name="Status"></th>
                            </tr>
                        </table>
                        <div class="row">
                            <div class="col-md-6 text-end" style="margin-left: 200px">

                                <input class="btn btn-success" type="submit" value="Update">
                            </div>
                        </div>
                    </form>    
                </div>
            </div>
        </div>
    </body>
</html>


