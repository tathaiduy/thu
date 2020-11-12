<%@page import="Cake.DTO.CartDTO"%>
<%@page import="Cake.DTO.CakeDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Wines &mdash; Website Template by Colorlib</title>
  <meta charset="utf-8">
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
            <a href="register.html" class="site-logo">
              <img src="user/images/logo.jpg" alt="Image" class="img-fluid">
            </a>
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
                      <form action="welcome.html" method="POST">
                        <input type="submit" value="Welcome" class="btn add text-left" />
                  </form>
                  </li>
                  <span class="tab"></span>
                  <li>
                      <form action="about.html" method="POST">
                        <input type="submit" value="About" class="btn add text-left" />
                  </form>
                  </li>
                  <span class="tab"></span>
                  <li>
                      <form action="SearchCakeController" method="POST">
                       <input type="submit" value="Cake" class="btn add text-left" />
                   </form>
                  </li>
                   <span class="tab"></span>
                   <li>
                      <form action="SearchCakeController" method="POST">
                    <input type="submit" value="Shop" class="btn add text-left" />
                  </form>
                  </li>
                  <span class="tab"></span>
                  <li>
                      <form action="contact.html" method="POST">
                    <input type="submit" value="Contact" class="btn add text-left" />
                  </form>
                  </li>
                  <span class="tab"></span>
                  <li>
                      <form action="login.jsp" method="POST">
                    <input type="submit" value="Login" class="btn add text-left" />
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

    
    
    

      
    

    <div class="site-section  pb-0">
        
      <div class="container">
        <div class="row mb-5 justify-content-center">
          <div class="col-7 section-title text-center mb-5">
              <% 
                    CartDTO shoppingCart = (CartDTO)session.getAttribute("cart");
                    if(shoppingCart != null)
                    {
                        
                    
                %>
            <h2 class="d-block">Cart</h2>
          </div>
        </div>
        <div class="row mb-5">
            <form action="UpdateCakeController" class="col-md-12" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                <h2 class="h5 cart-product-title text-black"><%= shoppingCart.getCustomerName() %>'s cart</h2>
                  <tr>
                    <th class="product-thumbnail">Image</th>
                    <th class="product-name">Product</th>
                    <th class="product-price">Price</th>
                    <th class="product-quantity">Quantity</th>
                    <th class="product-total">Total</th>
                    <th class="product-remove">Remove</th>
                    
                  </tr>
                </thead>
                <tbody>
                
                    <% 
                        
                         for(CakeDTO cake: shoppingCart.getCart().values())
                        {
                        %>
                  
                  <tr>
                    <td class="product-thumbnail">
                        
                      <img src=<%= cake.getCakePicture() %> alt="Image" class="img-fluid">
                      <input type="hidden" name="cakePicture" value="<%= cake.getCakePicture() %>" />
                    </td>
                    <td class="product-name">
                      <h2 class="h5 cart-product-title text-black"><%= cake.getCakeName() %></h2>
                      <input type="hidden" name="cakeName" value="<%= cake.getCakeName() %>" />
                    </td>
                    <td>
                        
                        <%= cake.getCakePrice() %>
                    <input type="hidden" name="cakePrice" value="<%= cake.getCakePrice() %>" />
                    
                    </td>
                    <td>
                      <div class="input-group mb-3" style="max-width: 120px;">
                        <div class="input-group-prepend">
                          <button class="btn btn-outline-primary js-btn-minus" type="button">&minus;</button>
                        </div>
                              <input type="text" id="a" name="txtQuantity" class="form-control text-center border mr-0" value=<%= cake.getCakeQuantity() %> placeholder=""
                          aria-label="Example text with button addon" aria-describedby="button-addon1">
                              <input type="hidden" name="cakeID" value="<%= cake.getCakeID() %>" />
                        <div class="input-group-append">
                            <button class="btn btn-outline-primary js-btn-plus" type="button">&plus;</button>
                        </div>
                      </div>
                    </form>
                    </td>
                    <td><%= cake.getCakePrice()*cake.getCakeQuantity()%></td>
                    
                    <td>
                        <form action="DeleteCakeController" method="POST">
                            <input type="hidden" name="cakePicture" value="<%= cake.getCakePicture() %>" />
                            <input type="hidden" name="cakeName" value="<%= cake.getCakeName() %>" />
                            <input type="hidden" name="cakePrice" value="<%= cake.getCakePrice() %>" />
                            <input type="hidden" name="cakeID" value="<%= cake.getCakeID() %>" />
                            
                        <input type="submit" value="X" class="btn btn-primary height-auto btn-sm" name="action" />
                        </form>
                    </td>
                  </tr>
                  
                    <%
                        }
                    }
else 
{
%>

<h2> No record Found </h2>
                       <%
}
                    %>
                  
                </tbody>
              </table>
                    
                        <input type="submit" value="Update" class="btn btn-primary btn-lg btn-block" name="action" />
                    
            </div>
          </form>
        </div>
    
      </div>
    </div>

    <div class="site-section pt-5 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <div class="row mb-5">
             <div class="col-md-6">
                  <form action="SearchCakeController" method="POST">
                      <button class="btn btn-outline-primary btn-md btn-block">Continue Shopping</button>
                  </form>
                
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <label class="text-black h4" for="coupon">Coupon</label>
                <p>Enter your coupon code if you have one.</p>
              </div>
              <div class="col-md-8 mb-3 mb-md-0">
                <input type="text" class="form-control py-3" id="coupon" placeholder="Coupon Code">
              </div>
              <div class="col-md-4">
                <button class="btn btn-primary btn-md px-4">Apply Coupon</button>
                
              </div>
            </div>
          </div>
          <div class="col-md-6 pl-5">
            <div class="row justify-content-end">
              <div class="col-md-7">
                <div class="row">
                  <div class="col-md-12 text-right border-bottom mb-5">
                    <h3 class="text-black h4 text-uppercase">Cart Totals</h3>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-md-6">
                    <span class="text-black">Subtotal</span>
                  </div>
                  <div class="col-md-6 text-right">
                      <% 
                          int totalPrice = 0;
                      if(shoppingCart != null)
                      {
                          totalPrice = shoppingCart.getTotal();
                      }
                      else
                      {
                          totalPrice = 0;
                      }
                      %>
                    <strong class="text-black"><%=totalPrice %></strong>
                  </div>
                </div>
                <div class="row mb-5">
                  <div class="col-md-6">
                    <span class="text-black">Total</span>
                  </div>
                  <div class="col-md-6 text-right">
                    <strong class="text-black"><%=totalPrice %></strong>
                  </div>
                </div>
    
                <div class="row">
                  <div class="col-md-12">
                      <form action="checkout.jsp" method="POST">
                          <input type="submit" class="btn btn-primary btn-lg btn-block" value="thu" />
                      </form>
                    <!--<button class="btn btn-primary btn-lg btn-block" onclick="window.location='checkout.jsp'">Proceed To
                      Checkout</button>-->
                  </div>
                </div>
              </div>
            </div>
          </div>
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

</body>

</html>