<%-- 
    Document   : login-view
    Created on : Nov 18, 2020, 8:35:42 PM
    Author     : cimiko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Login</title>
        <link rel="stylesheet" href="css/login.css"/>
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
            <div class="container loginPage">
                <video autoplay muted loop id="myVideo">
                    <source src="video/TechnologyBG.mp4" type="video/mp4">
                </video>
    
                <div class="login">
                    <form action="login-spring-mvc" method="POST">
                        <div class="form-group">
                          <label for="username">Username</label>
                          <input type="text" class="form-control w-75" name="userName">
                          <small id="error" class="form-text text-muted"><p style="color: red;">${error}</p></small>
                        </div>
                        <div class="form-group">
                          <label for="password">Password</label>
                          <input type="password" class="form-control w-75" name="password">
                        </div>
                        <div class="form-group">
                            <small>Belum mempunyai account? </small>
                            <a href="http://localhost:8080/bootcamp-java-web/register">Register</a>
                        </div>
                        <button type="submit" class="btn btn-primary w-75">Login</button>
                      </form>
                </div>
            </div>
        </main>
    </section>
    </body>
</html>
