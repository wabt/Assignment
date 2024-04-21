<%-- 
    Document   : profile
    Created on : Mar 2, 2024, 10:29:36 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet"> 

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">


        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
        <script>
            function checkPhoneNumber(element) {
                const pattern = /^\+?(\d{1,3})?[- .]?\(?(\d{3})\)?[- .]?(\d{3})[- .]?(\d{4})$/;

                var value = element.value;

                var msg = document.querySelector('#err');

                if (value.match(pattern)) {
                    msg.style.display = 'none';
                    element.style.borderBottomColor = '#059862';
                    console.log("Input matches the regex pattern");
                    flag = true;
                    return true;
                } else {
                    msg.innerHTML = 'Phone number must be number and have 10 character';
                    msg.style.display = 'block';
                    element.style.borderBottomColor = 'red';
                    console.log("Input does not match the regex pattern");
                    falg = false;
                    return false;
                }
            }
        </script>
    </head>
    <body>

        <!-- Navbar start -->
        <div class="container-fluid fixed-top">
            <div class="container topbar bg-primary d-none d-lg-block">
                <div class="d-flex justify-content-between">
                    <div class="top-info ps-2">
                        <small class="me-3"><i class="fas fa-map-marker-alt me-2 text-secondary"></i> <a href="#" class="text-white">123 Street, New York</a></small>
                        <small class="me-3"><i class="fas fa-envelope me-2 text-secondary"></i><a href="#" class="text-white">Email@Example.com</a></small>
                    </div>
                    <div class="top-link pe-2">
                        <a href="#" class="text-white"><small class="text-white mx-2">Privacy Policy</small>/</a>
                        <a href="#" class="text-white"><small class="text-white mx-2">Terms of Use</small>/</a>
                        <a href="#" class="text-white"><small class="text-white ms-2">Sales and Refunds</small></a>
                    </div>
                </div>
            </div>
            <div class="container px-0">
                <nav class="navbar navbar-light bg-white navbar-expand-xl">
                    <a href="home" class="navbar-brand"><h1 class="text-primary display-6">Fruitables</h1></a>
                    <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                        <span class="fa fa-bars text-primary"></span>
                    </button>
                    <div class="collapse navbar-collapse bg-white" id="navbarCollapse">
                        <div class="navbar-nav mx-auto">
                            <a href="home" class="nav-item nav-link">Home</a>
                            <a href="shop" class="nav-item nav-link">Shop</a>
                            <a href="shopdetail" class="nav-item nav-link active">Shop Detail</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                    <a href="cart" class="dropdown-item">Cart</a>
                                    <a href="checkout" class="dropdown-item">Checkout</a>
                                    <a href="testimonial" class="dropdown-item">Testimonial</a>
                                    <!--                                    <a href="404.html" class="dropdown-item">404 Page</a>-->
                                </div>
                            </div>
                            <a href="contact" class="nav-item nav-link">Contact</a>
                        </div>
                        <div class="d-flex m-3 me-0">
                            <!--<button class="btn-search btn border border-secondary btn-md-square rounded-circle bg-white me-4" data-bs-toggle="modal" data-bs-target="#searchModal"><i class="fas fa-search text-primary"></i></button>-->
                            <a href="cart" class="position-relative me-4 my-auto">
                                <i class="fa fa-shopping-bag fa-2x"></i>
                                <span class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1" style="top: -5px; left: 15px; height: 20px; min-width: 20px;">3</span>
                            </a>
                            <!--                            <a href="#" class="my-auto">
                                                            <i class="fas fa-user fa-2x"></i>
                                                        </a>-->
                            <c:if test="${sessionScope.account==null}">
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-user fa-2x"></i></a>
                                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="login" class="dropdown-item">Login</a>
                                        <a href="signup" class="dropdown-item">Signup</a>
                                    </div>
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.account!=null}">
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fas fa-user fa-2x"></i></a>
                                    <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                        <a href="profile" class="dropdown-item">Profile</a>
                                        <a href="admin" class="dropdown-item">Admin</a>
                                        <a href="logout" class="dropdown-item">Logout</a>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Navbar End -->

        <div class="container-xl px-4 mt-4">
            <!-- Account page navigation-->
            <nav class="nav nav-borders">
                <a class="nav-link active ms-0" href="https://www.bootdey.com/snippets/view/bs5-edit-profile-account-details" target="__blank">Profile</a>
                <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-billing-page" target="__blank">Billing</a>
                <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-security-page" target="__blank">Security</a>
                <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-edit-notifications-page"  target="__blank">Notifications</a>
            </nav>
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                            <!-- Profile picture help block-->
                            <!--                            <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                                                         Profile picture upload button
                                                        <button class="btn btn-primary" type="button">Upload new image</button>-->
                        </div>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="profile" method="post">
                                <!-- Form Group (username)-->
                                <input type="text" hidden name="userID" value="${sessionScope.account.getUserID()}">
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Username (how your name will appear to other users on the site)</label>
                                    <input class="form-control" id="inputUsername" type="text" readonly name="userName" placeholder="Enter your username" value="${sessionScope.account.getUserName()}">
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputFirstName">First name*</label>
                                        <input class="form-control" id="inputFirstName" required type="text" name="firstName" placeholder="Enter your first name" value="${sessionScope.account.getFirstName()}">
                                    </div>
                                    <!-- Form Group (last name)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputLastName">Last name*</label>
                                        <input class="form-control" id="inputLastName" required type="text" name="lastName" placeholder="Enter your last name" value="${sessionScope.account.getLastName()}">
                                    </div>
                                </div>
                                <!-- Form Row        -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (organization name)-->
                                    <!--                                    <div class="col-md-6">
                                                                            <label class="small mb-1" for="inputOrgName">Organization name</label>
                                                                            <input class="form-control" id="inputOrgName" type="text" placeholder="Enter your organization name" value="Start Bootstrap">
                                                                        </div>-->
                                    <!-- Form Group (location)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputCountry">Country</label>
                                        <input class="form-control" id="inputCountry" type="text" name="country" placeholder="Enter your country" value="${sessionScope.address.getCountry()}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputCity">City</label>
                                        <input class="form-control" id="inputCity" type="text" name="city" placeholder="Enter your city" value="${sessionScope.address.getCity()}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputAddressLine">Address Line</label>
                                        <input class="form-control" id="inputAddressLine" type="text" name="addressLine" placeholder="Enter your address" value="${sessionScope.address.getAddressLine()}">
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputGender">Gender*</label><br/><!-- comment --><br/>
                                        <input required  id="inputGender" type="radio" <c:if test="${sessionScope.account.getSex()==1}">checked</c:if> name="sex" value="1">Male &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input required id="inputGender" type="radio" <c:if test="${sessionScope.account.getSex()==0}">checked</c:if> name="sex" value="0">FeMale
                                        </div>
                                    </div>
                                    <!-- Form Group (email address)-->
                                    <div class="mb-3">
                                        <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                        <input class="form-control" id="inputEmailAddress" required type="text" readonly name="email" placeholder="Enter your email address" value="${sessionScope.account.getEmail()}">
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number*</label>
                                        <input class="form-control" onkeyup="checkPhoneNumber(this)" id="inputPhone" required type="text" name="phone" placeholder="Enter your phone number" value="0${sessionScope.account.getPhone()}">
                                        <div id="err" style="display: none; color: red">Input type err</div>
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Birthday*</label>
                                        <input class="form-control" id="inputBirthday" required type="date" name="dob" placeholder="Enter your birthday" value="${sessionScope.account.getDob()}">
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <h5 class="input100" style="color: red">${requestScope.error}</h5>
                                <input class="btn btn-primary" type="submit" value="Save Change">
                            </form>
                            <br/><!-- comment -->
                            <a href="password" class="btn btn-primary">Change Password</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
