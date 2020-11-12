<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <div class="container">
            <form action="RegisterUsernameController" method="POST" class="appointment-form" id="appointment-form">
                <h2>education appointment form</h2>
                <div class="form-group-1">
                    <input type="text" name="txtUsername" id="title" placeholder="Username" required />
                    <h2>${requestScope.INVALIDREGISTER.usernameError}</h2>
                    <input type="text" name="txtPassword" id="name" placeholder="Password" required />
                    <h2>${requestScope.INVALIDREGISTER.passwordError}</h2>
                    <input type="text" name="txtFullname" id="name" placeholder="Fullname" required />
                    <h2>${requestScope.INVALIDREGISTER.fullnameError}</h2>
                    <input type="email" name="txtEmail" id="email" placeholder="Email" required />
                    <h2>${requestScope.INVALIDREGISTER.emailAddressError}</h2>
                    <!--<input type="number" name="txtPhoneNumber" id="phone_number" placeholder="Phone number" required />-->
                    <!--<div class="select-list">
                        <select name="course_type" id="course_type">
                            <option slected value="">Course Type</option>
                            <option value="society">Society</option>
                            <option value="language">Language</option>
                        </select>
                    </div>-->
                </div>
                <!--<div class="form-group-2">
                    <h3>How would you like to bo located ?</h3>
                    <div class="select-list">
                        <select name="confirm_type" id="confirm_type">
                            <option seleected value="">By phone</option>
                            <option value="by_email">By email</option>
                        </select>
                    </div>
                    <div class="select-list">
                        <select name="hour_appointment" id="hour_appointment">
                            <option seleected value="">Hours : 8am 10pm</option>
                            <option value="9h-11h">Hours : 9am 11pm</option>
                        </select>
                    </div>
                </div>-->
                <div class="form-check">
                    <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                    <label for="agree-term" class="label-agree-term">
                        <span>
                            <span>
                                
                            </span>
                                
                        </span>I agree to the  <a href="#" class="term-service">Terms and Conditions</a></label>
                </div>
                
                    <div class="form-submit">
                    <input type="submit" name="submit" id="submit" class="submit" value="Request an appointment" />
                </div>
                </form>
                
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>