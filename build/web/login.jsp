<%-- 
    Document   : login
    Created on : Feb 29, 2024, 12:35:10 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login V6</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />

        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">

        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">

        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">

        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">

        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">

        <meta name="robots" content="noindex, follow">
        <script nonce="4000e694-c584-4915-a76a-f777051eb871">try{(function(w, d){!function(ct, cu, cv, cw){ct[cv] = ct[cv] || {}; ct[cv].executed = []; ct.zaraz = {deferred:[], listeners:[]}; ct.zaraz.q = []; ct.zaraz._f = function(cx){return async function(){var cy = Array.prototype.slice.call(arguments); ct.zaraz.q.push({m:cx, a:cy})}}; for (const cz of["track", "set", "debug"])ct.zaraz[cz] = ct.zaraz._f(cz); ct.zaraz.init = () => {var cA = cu.getElementsByTagName(cw)[0], cB = cu.createElement(cw), cC = cu.getElementsByTagName("title")[0]; cC && (ct[cv].t = cu.getElementsByTagName("title")[0].text); ct[cv].x = Math.random(); ct[cv].w = ct.screen.width; ct[cv].h = ct.screen.height; ct[cv].j = ct.innerHeight; ct[cv].e = ct.innerWidth; ct[cv].l = ct.location.href; ct[cv].r = cu.referrer; ct[cv].k = ct.screen.colorDepth; ct[cv].n = cu.characterSet; ct[cv].o = (new Date).getTimezoneOffset(); if (ct.dataLayer)for (const cG of Object.entries(Object.entries(dataLayer).reduce(((cH, cI) => ({...cH[1], ...cI[1]})), {})))zaraz.set(cG[0], cG[1], {scope:"page"}); ct[cv].q = []; for (; ct.zaraz.q.length; ){const cJ = ct.zaraz.q.shift(); ct[cv].q.push(cJ)}cB.defer = !0; for (const cK of[localStorage, sessionStorage])Object.keys(cK || {}).filter((cM => cM.startsWith("_zaraz_"))).forEach((cL => {try{ct[cv]["z_" + cL.slice(7)] = JSON.parse(cK.getItem(cL))} catch {ct[cv]["z_" + cL.slice(7)] = cK.getItem(cL)}})); cB.referrerPolicy = "origin"; cB.src = "/cdn-cgi/zaraz/s.js?z=" + btoa(encodeURIComponent(JSON.stringify(ct[cv]))); cA.parentNode.insertBefore(cB, cA)}; ["complete", "interactive"].includes(cu.readyState)?zaraz.init():ct.addEventListener("DOMContentLoaded", zaraz.init)}(w, d, "zarazData", "script"); })(window, document)} catch (e){throw fetch("/cdn-cgi/zaraz/t"), e; };</script></head>

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

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
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
<!--                                <a href="404.html" class="dropdown-item">404 Page</a>-->
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
                        <!--                        <a href="#" class="my-auto">
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

    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-t-85 p-b-20">
                <form action="login" method="post" class="login100-form validate-form">
<!--                    <span class="login100-form-title p-b-70">
                        Welcome
                    </span>-->
                    <div class="wrap-input100 validate-input m-t-85 m-b-35" data-validate="Enter username">
                        <input onkeyup="checkEmpty(this)" id="username" class="input100 has-val" required type="text" name="username">
                        <span class="focus-input100" data-placeholder="Username"></span>
                    </div>
                    <div class="wrap-input100 validate-input m-b-50" data-validate="Enter password">
                        <input id="password" class="input100 has-val" required type="password" name="pass">
                        <span class="focus-input100" data-placeholder="Password"></span>
                    </div>
                    <h5 class="input100" style="color: red">${requestScope.error}</h5>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn">
                            Login
                        </button>
                    </div>
                    <ul class="login-more p-t-190">
                        <li class="m-b-8">
                            <span class="txt1">
                                Forgot
                            </span>
                            <a href="forget" class="txt2">
                                Password?
                            </a>
                        </li>
                        <li>
                            <span class="txt1">
                                Don’t have an account?
                            </span>
                            <a href="signup" class="txt2">
                                Sign up
                            </a>
                        </li>
                    </ul>
                </form>
            </div>
        </div>
    </div>
    <div id="dropDownSelect1"></div>

    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>

    <script src="vendor/animsition/js/animsition.min.js"></script>

    <script src="vendor/bootstrap/js/popper.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <script src="vendor/select2/select2.min.js"></script>

    <script src="vendor/daterangepicker/moment.min.js"></script>
    <script src="vendor/daterangepicker/daterangepicker.js"></script>

    <script src="vendor/countdowntime/countdowntime.js"></script>

    <script src="<%=request.getContextPath()%>/js/main.js"></script>

    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
    <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
            dataLayer.push(arguments);
            }
            gtag('js', new Date());
            gtag('config', 'UA-23581568-13');
    </script>
    <script defer src="https://static.cloudflareinsights.com/beacon.min.js/v84a3a4012de94ce1a686ba8c167c359c1696973893317" integrity="sha512-euoFGowhlaLqXsPWQ48qSkBSCFs3DPRyiwVu3FjR96cMPx+Fr+gpWRhIafcHwqwCqWS42RZhIudOvEI+Ckf6MA==" data-cf-beacon='{"rayId":"85ca690c1cf0097e","version":"2024.2.1","token":"cd0b4b3a733644fc843ef0b185f98241"}' crossorigin="anonymous"></script>
</body>
</html>
