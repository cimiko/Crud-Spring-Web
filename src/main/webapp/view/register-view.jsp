<%-- 
    Document   : register-view
    Created on : Nov 19, 2020, 1:26:39 AM
    Author     : cimiko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Register</title>
        <link rel="stylesheet" href="css/regist.css"/>
        <script src="/js/validateRegist.js"></script>
    </head>
    <body>
        <section>
        <header>
            <nav class="navbar">
                <a class="navbar-brand" href="http://localhost:8080/bootcamp-java-web/">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRliDdW0n18MCieL74e0JTpjbVCh6F3fAvNw&usqp=CAU"
                        width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
                    CiMiKo
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </nav>
        </header>

        <main>
            <div class="container registPage">
                <video autoplay muted loop id="myVideo">
                    <source src="video/TechnologyBG.mp4" type="video/mp4">
                </video>
                
                <div class="regist">
                    <form action="register" method="POST" onsubmit="validateForm();">
                        <div class="form-group">
                          <label for="username">Username</label>
                          <input type="text" class="form-control w-75" name="userName" value="${userName}">
                          <small id="error" class="form-text text-muted"><p style="color: red;">${error}</p></small>
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control w-75" name="password">
                        </div>
                        <div class="form-group">
                          <label for="password">Confirm Password</label>
                          <input type="password" class="form-control w-75" name="confirmPassword">
                        </div>
                        <button type="submit" class="btn btn-primary w-75">Register</button>
                      </form>
                </div>
            </div>
        </main>
    </section>
                        
    </body>
    <script>
        function validateForm(){
            var validation = 
                    validateUserNameAsEmailAddress()
                    && validatePasswordAndConfirmPasswordIsTheSame();
            if((validation != "") || (validation != null)){
                if(!validation){
                    document.getElementById("error").innerHTML
                        = "Username should be Valid Email and password must be same."
                    event.preventDefault();
                }
            }else{
                document.getElementById("error").innerHTML
                    = "Form cannot be empty, Please enter the correct username and password."
                event.preventDefault();
            }
            
            return validation;
        }
        
        function validateUserNameAsEmailAddress(){
            var emailFormat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
            var userName = document.getElementsByName("userName")[0].value;
            if(userName && userName.match(emailFormat)) {
                return true;
            }
            return false;
        }
        
        function validatePasswordAndConfirmPasswordIsTheSame(){
            var password = document.getElementsByName("password")[0].value;
            var confirmPassword = 
                    document.getElementsByName("confirmPassword")[0].value;
            
            if(password &&
                    confirmPassword &&
                    password == confirmPassword) {
                return true;
            }
            return false;
        }
    </script>
</html>
