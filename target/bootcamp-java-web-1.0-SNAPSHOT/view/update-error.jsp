<%-- 
    Document   : update-error
    Created on : Nov 21, 2020, 2:27:04 PM
    Author     : cimiko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Update Error</title>
        <link rel="stylesheet" href="css/regist.css"/>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg">
                <a class="navbar-brand" href="personlist">
                    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRliDdW0n18MCieL74e0JTpjbVCh6F3fAvNw&usqp=CAU"
                        width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
                    CiMiKo
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                
                <div class="collapse navbar-collapse justify-content-end">
                    <div class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${name}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="logout">Logout</a>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        <main>
            <div class="container registPage">
                <video autoplay muted loop id="myVideo">
                    <source src="video/TechnologyBG.mp4" type="video/mp4">
                </video>
    
                <div class="regist">
                    <h1>Updating Password Error!</h1>
                    <p style="color: red;">${error}</p>
                    <p class="button"><a href="person-list">Go To Person List</a></p>
                </div>
            </div>
        </main>
    </body>
</html>
