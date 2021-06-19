

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="LoginServlet">Hello ADMIN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="AdminOrder">Order</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="adminAdd.jsp">Add Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminStatisticServlet">Statistic</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Account
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="products">Logout</a></li>

                    </ul>
                </li>

            </ul>
            <form class="d-flex" action="AdminSearchProductServlet" method="get">
                <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="input-text">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>

        </div>
    </div>
</nav>
