/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


        function validateForm(){
            var validation = 
                    validateUserNameAsEmailAddress()
                    && validatePasswordAndConfirmPasswordIsTheSame();
            alert("test");
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