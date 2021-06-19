<%-- 
    Document   : login
    Created on : Mar 16, 2021, 11:28:46 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets2/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets2/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets2/css/flaticon.css">
        <link rel="stylesheet" href="assets2/css/slicknav.css">
        <link rel="stylesheet" href="assets2/css/animate.min.css">
        <link rel="stylesheet" href="assets2/css/magnific-popup.css">
        <link rel="stylesheet" href="assets2/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets2/css/themify-icons.css">
        <link rel="stylesheet" href="assets2/css/slick.css">
        <link rel="stylesheet" href="assets2/css/nice-select.css">
        <link rel="stylesheet" href="assets2/css/style.css">
    </head>
    <body>
        <header style="font-size: large">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="#">Hoang Furniture</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="products">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Login</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Dropdown
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#">Action</a></li>
                                    <li><a class="dropdown-item" href="#">Another action</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="cart.jsp">Cart <span class="badge rounded-pill bg-danger">${sessionScope.totalProducts}</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
        </header>
        <section class="login_part section_padding " style="margin-top: -130px">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_text text-center">
                            <div class="login_part_text_iner">
                                <h2>New to our Shop?</h2>
                                <p>New furnitures updating every sunday.Proudly present to our customers the 
                                most trendy and convenience products</p>
                                <a href="signup.jsp" class="btn_3">Create an Account</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="login_part_form">
                            <div class="login_part_form_iner">
                                <h3>Welcome Back ! <br>
                                    Please Sign in now</h3>
                                <form class="row contact_form" action="LoginServlet" method="post" novalidate="novalidate">
                                    <div class="col-md-12 form-group p_star">
                                        <input type="text" class="form-control" id="name" name="username" value=""
                                               placeholder="Username">
                                    </div>
                                    <div class="col-md-12 form-group p_star">
                                        <input type="password" class="form-control" id="password" name="password" value=""
                                               placeholder="Password">
                                    </div>
                                    <div class="col-md-12 form-group">
                                        <div class="creat_account d-flex align-items-center">
                                            <input type="checkbox" id="f-option" name="remember">
                                            <label for="f-option">Remember me</label>
                                        </div>
                                        <button type="submit" value="submit" class="btn_3">
                                            log in
                                        </button>
                                        <a class="lost_pass" href="#">forget password?</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
