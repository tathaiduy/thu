<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <head>
        <title>Wines &mdash; Website Template by Colorlib</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <link href="https://fonts.googleapis.com/css?family=Cinzel:400,700|Montserrat:400,700|Roboto&display=swap" rel="stylesheet"> 

        <link rel="stylesheet" href="user/fonts/icomoon/style.css">

        <link rel="stylesheet" href="user/css/bootstrap.min.css">
        <link rel="stylesheet" href="user/css/jquery-ui.css">
        <link rel="stylesheet" href="user/css/owl.carousel.min.css">
        <link rel="stylesheet" href="user/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="user/css/owl.theme.default.min.css">

        <link rel="stylesheet" href="user/css/jquery.fancybox.min.css">

        <link rel="stylesheet" href="user/css/bootstrap-datepicker.css">

        <link rel="stylesheet" href="user/fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="user/css/aos.css">
        <link href="user/css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="user/css/style.css">
        <style> 
            .tab { 
                display: inline-block; 
                margin-left: 40px; 
                margin-bottom: 20px;
                margin-top: 20px
            } 
        </style>


    </head>

    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">

        <div class="site-wrap">

            <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div>



            <div class="header-top">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-12 text-center">
                            <form action="MainUserController" method="POST" id="loadWelcomeUserPage">
                                <input type="hidden" name="action" value="user/welcome-user.html" />
                                <a href="javascript:welcomeUserPage()" class="site-logo">
                                    <img src="user/images/logo.jpg" alt="Image" class="img-fluid">
                                </a>
                            </form>
                        </div>
                        <a href="#" class="mx-auto d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
                                class="icon-menu h3"></span></a>
                    </div>
                </div>




                <div class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block" role="banner">

                    <div class="container">
                        <div class="d-flex align-items-center">

                            <div class="mx-auto">
                                <nav class="site-navigation position-relative text-left" role="navigation">
                                    <ul class="site-menu main-menu js-clone-nav mx-auto d-none pl-0 d-lg-block border-none">
                                        <li>
                                            <form action="MainUserController" method="POST" >
                                                <input type="hidden" name="action" value="user/welcome-user.html" />
                                                <input type="submit" value="Welcome" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                        <li>
                                            <form action="MainUserController" method="POST">
                                                <input type="submit" value="About" name="action" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                        <li>
                                            <form action="MainUserController" method="POST">
                                                <input type="submit" value="Cake" name="action" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                        <li>
                                            <form action="ShowUserCartController" method="POST">
                                                <input type="submit" value="Your Cart" name="action" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                        <li>
                                            <form action="MainUserController" method="POST">
                                                <input type="submit" value="Contact" name="action" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                        <li>
                                            <form action="MainUserController" method="POST">
                                                <input type="submit" value="LogOut" name="action" class="btn add text-left" />
                                            </form>
                                        </li>
                                        <span class="tab"></span>
                                    </ul>                                                                                                                                                                                                                                                                                         
                                </nav>

                            </div>

                        </div>
                    </div>

                </div>

            </div>







            <div class="site-section mt-5">
                <div class="container">

                    <div class="row mb-5">
                        <div class="col-12 section-title text-center mb-5">
                            <h2 class="d-block">Our Products</h2>
                            <p></p>
                        </div>
                    </div>

                    <div class="row mb-5">
                        <div class="col-12 section-title text-center mb-5">
                            <form action="MainUserController" class="search-form d-inline-block" method="POST">
                                <div class="d-flex">
                                    <input type="hidden" name="action" value="Cake" />
                                    <input type="text" class="form-control" placeholder="Search..." name="txtSearchCakeAdmin" value="">
                                    <button type="submit" class="btn btn-secondary" ><span class="icon-search"></span></button>
                                    
                                </div>
                            </form>
                        </div>  
                    </div>


                    <div class="row">
                        <c:forEach items="${requestScope.USERCAKEINFO}" var="dto" varStatus="count">


                            <div class="col-lg-4 mb-5 col-md-6">
                                <form action="MainUserController" method="POST">
                                    <div class="wine_v_1 text-center pb-4">
                                        <a href="shop-single.html" class="thumbnail d-block mb-4"><img src=${dto.cakePicture} alt="Image" class="img-fluid"></a>
                                        <div>
                                            <h3 class="heading mb-1" id="cakeName"><a href="#">${dto.cakePrice}</a></h3>
                                            <span class="price" id="cakePrice">${dto.cakePrice}VND</span>
                                            <input type="hidden" name="cakeName" value="${dto.cakeName}" />
                                            <input type="hidden" name="cakePrice" value="${dto.cakePrice}" />
                                            <input type="hidden" name="cakePicture" value="${dto.cakePicture}" />
                                            <input type="hidden" name="cakeID" value="${dto.cakeID}" />
                                            <input type="hidden" name="cakeIDdas" value="${sessionScope.ROLE}" />
                                        </div>


                                        <div class="wine-actions">

                                            <h3 class="heading-2"><a href="#">${dto.cakeName}</a></h3>
                                            <span class="price d-block">${dto.cakePrice}VND</span>

                                            <div class="rating">
                                                <span class="icon-star"></span>
                                                <span class="icon-star"></span>
                                                <span class="icon-star"></span>
                                                <span class="icon-star"></span>
                                                <span class="icon-star-o"></span>
                                            </div>

                                            <a href="cart.html" class="btn add"><span class="icon-shopping-bag mr-3"></span> Add to Cart</a>
                                            <input type="submit" name="action" value="Add To Cart" class="btn add" >
                                        </div>
                                    </div>
                                </form>
                            </div>


                        </c:forEach>


                    </div>
                </div>
            </div>

            <div class="hero-2" style="background-image: url('user/images/cakewelcome.jpg');">
                <div class="container">
                    <div class="row justify-content-center text-center align-items-center">
                        <div class="col-md-8">
                            <span class="sub-title">Welcome</span>
                            <h2>Cake For Everyone</h2>
                            <h6>Photo by Meritt Thomas on Unsplash</h6>

                        </div>
                    </div>
                </div>
            </div>

            <div class="site-section bg-light">
                <div class="container">
                    <div class="owl-carousel owl-slide-3 owl-slide">

                        <blockquote class="testimony">
                            <img src="user/images/person1.jpg" alt="Image">
                            <p>&ldquo;TRẦN LỮ NGỌC TRINH&rdquo;</p>
                            <p class="small text-primary">&mdash; Tart Baker and Saler</p>
                        </blockquote>
                        <blockquote class="testimony">
                            <img src="user/images/person2.jpg" alt="Image">
                            <p>&ldquo;BÒ&rdquo;</p>
                            <p class="small text-primary">&mdash; Baker and Saler</p>
                        </blockquote>
                        <blockquote class="testimony">
                            <img src="user/images/person3.jpg" alt="Image">
                            <p>&ldquo;TẠ THÁI DUY&rdquo;</p>
                            <p class="small text-primary">&mdash; SHIPPER KIÊM ĂN CHỰC NY </p>
                        </blockquote>
                        <blockquote class="testimony">
                            <img src="images/person_1.jpg" alt="Image">
                            <p>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero sapiente beatae, nemo quasi quo neque consequatur rem porro reprehenderit, a dignissimos unde ut enim fugiat deleniti quae placeat in cumque?&rdquo;</p>
                            <p class="small text-primary">&mdash; Allie Smith</p>
                        </blockquote>

                    </div>
                </div>
            </div>




            <div class="footer">
                <div class="container">

                    <div class="row">
                        <div class="col-12 text-center">
                            <div class="social-icons">
                                <a href="#"><span class="icon-facebook"></span></a>
                                <a href="#"><span class="icon-twitter"></span></a>
                                <a href="#"><span class="icon-youtube"></span></a>
                                <a href="#"><span class="icon-instagram"></span></a>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="copyright">
                                <p>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                </p>



                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
        <!-- .site-wrap -->


        <!-- loader -->
        <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div>

        <script src="user/js/jquery-3.3.1.min.js"></script>
        <script src="user/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="user/js/jquery-ui.js"></script>
        <script src="user/js/popper.min.js"></script>
        <script src="user/js/bootstrap.min.js"></script>
        <script src="user/js/owl.carousel.min.js"></script>
        <script src="user/js/jquery.stellar.min.js"></script>
        <script src="user/js/jquery.countdown.min.js"></script>
        <script src="user/js/bootstrap-datepicker.min.js"></script>
        <script src="user/js/jquery.easing.1.3.js"></script>
        <script src="user/js/aos.js"></script>
        <script src="user/js/jquery.fancybox.min.js"></script>
        <script src="user/js/jquery.sticky.js"></script>
        <script src="user/js/jquery.mb.YTPlayer.min.js"></script>




        <script src="user/js/main.js"></script>
        <script type="text/javascript">
            function welcomeUserPage() 
                        {
                            document.getElementById('loadWelcomeUserPage').submit();
                        }
        </script>
    </body>

</html>