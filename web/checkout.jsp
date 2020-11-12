<%@page import="Cake.DTO.CakeDTO"%>
<%@page import="Cake.DTO.CartDTO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
  <link rel="stylesheet" href="css/owl.theme.default.min.css">

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

    
    
    
      
    

    <div class="site-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-12">
            <div class="bg-light rounded p-3">
                <p class="mb-0">Returning customer? <a href="login.jsp" class="d-inline-block">Click here</a> to login</p>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-md-6 mb-5 mb-md-0">
            <h2 class="h3 mb-3 text-black font-heading-serif">Billing Details</h2>
            <div class="p-3 p-lg-5 border">
              <div class="form-group row">
                <div class="col-md-6">
                  <label for="c_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_fname" name="c_fname">
                </div>
                  
                <div class="col-md-6">
                  <label for="c_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_lname" name="c_lname">
                </div>
              </div>
    
              <div class="form-group row">
                <div class="col-md-12">
                  <label for="c_address" class="text-black">Address <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_address" name="c_address" placeholder="Street address">
                </div>
              </div>
    
              <div class="form-group row">
                <div class="col-md-6">
                  <label for="c_state_country" class="text-black">District <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_state_country" name="c_state_country">
                </div>
              </div>
    
              <div class="form-group row mb-5">
                <div class="col-md-6">
                  <label for="c_email_address" class="text-black">Email Address <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_email_address" name="c_email_address">
                </div>
                <div class="col-md-6">
                  <label for="c_phone" class="text-black">Phone <span class="text-danger">*</span></label>
                  <input type="text" class="form-control" id="c_phone" name="c_phone" placeholder="Phone Number">
                </div>
              </div>
    
              <div class="form-group">
                <label for="c_create_account" class="text-black" data-toggle="collapse" href="#create_an_account"
                  role="button" aria-expanded="false" aria-controls="create_an_account"><input type="checkbox" value="1"
                    id="c_create_account"> Create an account?</label>
                <div class="collapse" id="create_an_account">
                  <div class="py-2">
                    <p class="mb-3">Create an account by entering the information below. If you are a returning customer
                      please login at the top of the page.</p>
                    <div class="form-group">
                      <label for="c_account_password" class="text-black">Account Password</label>
                      <input type="email" class="form-control" id="c_account_password" name="c_account_password"
                        placeholder="">
                    </div>
                  </div>
                </div>
              </div>
    
    
              <!--<div class="form-group">
                <label for="c_ship_different_address" class="text-black" data-toggle="collapse"
                  href="#ship_different_address" role="button" aria-expanded="false"
                  aria-controls="ship_different_address"><input type="checkbox" value="1" id="c_ship_different_address">
                  Ship To A Different Address?</label>
                <div class="collapse" id="ship_different_address">
                  <div class="py-2">
    
                    <div class="form-group">
                      <label for="c_diff_country" class="text-black">Country <span class="text-danger">*</span></label>
                      <select id="c_diff_country" class="form-control">
                        <option value="1">Select a country</option>
                        <option value="2">bangladesh</option>
                        <option value="3">Algeria</option>
                        <option value="4">Afghanistan</option>
                        <option value="5">Ghana</option>
                        <option value="6">Albania</option>
                        <option value="7">Bahrain</option>
                        <option value="8">Colombia</option>
                        <option value="9">Dominican Republic</option>
                      </select>
                    </div>
    
    
                    <div class="form-group row">
                      <div class="col-md-6">
                        <label for="c_diff_fname" class="text-black">First Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_fname" name="c_diff_fname">
                      </div>
                      <div class="col-md-6">
                        <label for="c_diff_lname" class="text-black">Last Name <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_lname" name="c_diff_lname">
                      </div>
                    </div>
    
                    <div class="form-group row">
                      <div class="col-md-12">
                        <label for="c_diff_companyname" class="text-black">Company Name </label>
                        <input type="text" class="form-control" id="c_diff_companyname" name="c_diff_companyname">
                      </div>
                    </div>
    
                    <div class="form-group row">
                      <div class="col-md-12">
                        <label for="c_diff_address" class="text-black">Address <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_address" name="c_diff_address"
                          placeholder="Street address">
                      </div>
                    </div>
    
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="Apartment, suite, unit etc. (optional)">
                    </div>
    
                    <div class="form-group row">
                      <div class="col-md-6">
                        <label for="c_diff_state_country" class="text-black">State / Country <span
                            class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_state_country" name="c_diff_state_country">
                      </div>
                      <div class="col-md-6">
                        <label for="c_diff_postal_zip" class="text-black">Posta / Zip <span
                            class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_postal_zip" name="c_diff_postal_zip">
                      </div>
                    </div>
    
                    <div class="form-group row mb-5">
                      <div class="col-md-6">
                        <label for="c_diff_email_address" class="text-black">Email Address <span
                            class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_email_address" name="c_diff_email_address">
                      </div>
                      <div class="col-md-6">
                        <label for="c_diff_phone" class="text-black">Phone <span class="text-danger">*</span></label>
                        <input type="text" class="form-control" id="c_diff_phone" name="c_diff_phone"
                          placeholder="Phone Number">
                      </div>
                    </div>
    
                  </div>
    
                </div>
              </div>-->
    
              <div class="form-group">
                <label for="c_order_notes" class="text-black">Order Notes</label>
                <textarea name="c_order_notes" id="c_order_notes" cols="30" rows="5" class="form-control"
                  placeholder="Write your notes here..."></textarea>
              </div>
    
            </div>
          </div>
          <div class="col-md-6">
    
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black font-heading-serif">Coupon Code</h2>
                <div class="p-3 p-lg-5 border">
    
                  <label for="c_code" class="text-black mb-3">Enter your coupon code if you have one</label>
                  <div class="input-group w-75">
                    <input type="text" class="form-control" id="c_code" placeholder="Coupon Code" aria-label="Coupon Code"
                      aria-describedby="button-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary btn-sm rounded px-4" type="button" id="button-addon2">Apply</button>
                    </div>
                  </div>
    
                </div>
              </div>
            </div>
    
            <div class="row mb-5">
              <div class="col-md-12">
                <h2 class="h3 mb-3 text-black font-heading-serif">Your Order</h2>
                <div class="p-3 p-lg-5 border">
                    <% 
                        response.setCharacterEncoding("UTF-8");
                        request.setCharacterEncoding("UTF-8");
                    CartDTO shoppingCart = (CartDTO)session.getAttribute("cart");
                    
                %>
                  <table class="table site-block-order-table mb-5">
                    <thead>
                      <th>Product</th>
                      <th>Total</th>
                    </thead>
                    <tbody>
                        <% 
                        for(CakeDTO cake: shoppingCart.getCart().values())
                        {
                        %>
                      <tr>
                          <td><%= cake.getCakeName() %> <strong class="mx-2">x</strong> <%= cake.getCakeQuantity() %> </td>
                        <td><%= cake.getCakePrice()*cake.getCakeQuantity()%>VND</td>
                      </tr>
                      <%
                          }
                      %>
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Cart Subtotal</strong></td>
                        <td class="text-black"><%= shoppingCart.getTotal() %>VND</td>
                      </tr>
                      <tr>
                        <td class="text-black font-weight-bold"><strong>Order Total</strong></td>
                        <td class="text-black font-weight-bold"><strong><%= shoppingCart.getTotal() %>VND</strong></td>
                      </tr>
                    </tbody>
                  </table>
    
                  <div class="border mb-3 p-3 rounded">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsebank" role="button"
                        aria-expanded="false" aria-controls="collapsebank">Direct Bank Transfer</a></h3>
    
                    <div class="collapse" id="collapsebank">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won?t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="border mb-3 p-3 rounded">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsecheque" role="button"
                        aria-expanded="false" aria-controls="collapsecheque">Cheque Payment</a></h3>
    
                    <div class="collapse" id="collapsecheque">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won?t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="border mb-5 p-3">
                    <h3 class="h6 mb-0"><a class="d-block" data-toggle="collapse" href="#collapsepaypal" role="button"
                        aria-expanded="false" aria-controls="collapsepaypal">Paypal</a></h3>
    
                    <div class="collapse" id="collapsepaypal">
                      <div class="py-2 pl-0">
                        <p class="mb-0">Make your payment directly into our bank account. Please use your Order ID as the
                          payment reference. Your order won?t be shipped until the funds have cleared in our account.</p>
                      </div>
                    </div>
                  </div>
    
                  <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block" onclick="window.location='thankyou.html'">Place
                      Order</button>
                  </div>
    
                </div>
              </div>
            </div>
    
          </div>
        </div>
        <!-- </form> -->
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