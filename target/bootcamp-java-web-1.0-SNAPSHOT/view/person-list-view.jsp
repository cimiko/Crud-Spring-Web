<%-- 
    Document   : person-list-view
    Created on : Nov 21, 2020, 1:11:32 PM
    Author     : cimiko
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Person Data</title>
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
                
                <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
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
    
                <div class="">
                    <h1>Manage Person</h1>
                    <table class="table bg-light">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">User Name</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var = "person" items="${persons}">
                                <tr>
                                    <td style="text-align: left;">
                                        ${person.name}
                                    </td>
                                    <td class="update">
                                        <a href="delete?id=${person.id}" onclick="deletePerson('${person.id}')">Delete</a>
                                    </td>
                                    <td class="update">
                                        <a href="update?id=${person.id}">Update</a>
                                    </td>
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
            </div>
        </main>
        
        
    </body>
    <script>
        function deletePerson(id){
            event.preventDefault();
            if(confirm("Are you sure to delete this data?")){
                //actual delete here 
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function(){
                    if (this.readyState == 4 && this.status == 200) {
//                        alert("Success deleting data " + this.responseText);
                        alert("Success deleting data ");

                        location.reload();
                    }
                };
                xmlhttp.open("GET", "delete?id=" + id, true);
                xmlhttp.send();
            }
            return false;
        };
            
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</html>
