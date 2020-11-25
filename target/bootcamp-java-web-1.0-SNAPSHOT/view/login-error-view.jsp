<%-- 
    Document   : login-error-view
    Created on : Nov 18, 2020, 8:42:33 PM
    Author     : cimiko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Login Error</title>
        <link rel="stylesheet" href="css/regist.css"/>
        <style>
            .regist{
                padding: 100px 0px;
            }
            .button{
                margin: 50px 0px;
            }
            .button a{
                text-decoration: none;
                padding: 10px 50px;
                color: white;
                background: blue;
                border: 1px solid black;
                border-radius: 10px;
            }
        </style>
    </head>
    <body>
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
                    <h1>Login Failed!</h1>
                    <h5>Please enter the correct password.</h5>
                    <p class="button"><a href="login">login</a></p>
                </div>
            </div>
        </main>
        
    </body>
</html>
