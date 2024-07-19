<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<! DOCTYPE html>  
<html lang="en" >  
<head>  
  <meta charset="UTF-8">  
  <title> Đăng Nhập  
</title>  
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/home/css/open-iconic-bootstrap.min.css">  
</head>  
<style>  
body {  
          background-repeat: no-repeat, repeat;
          text-align: center;  
          background-position: center;  
          background-size: cover;  
          padding-top: 50px;
           
        }  
        .login-form { 
          width: 50%;
          background:#1a11117a;  
          margin: auto;   
          padding: 100px;  
          border-radius: 50px;  
          color: white;  
          box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.75);  
        }  
        .login-heading {  
          text-align: center;  
          margin-top: 20px;  
        }  
        .btn-primary {  
          width: 20%;
          color: white;
          background-color:DodgerBlue;
          margin-top: 20px; 
          padding: 8px 16px;
          border:none;
        }
        .container{
          text-align: center;
        } 
        .form-group{
            margin-top: 20px;
        }
        .form-control{
           padding: 10px 40px;
        } 
</style>  
<body>
  
<h1 class="text-center">Login Admin  </h1>  
    <div class="container"> 
    <p style="color:red;"> ${msg }</p>     
        <div class="login-form">  
            <form  action="${pageContext.servletContext.contextPath}/admin/login" method="post">  
              <div class="form-group">    
                <input type="text" class="form-control" name="userName"  placeholder="user name">  
                <small > </small>  
              </div>  
              <div class="form-group">    
                <input type="password" class="form-control" name="password"  placeholder="password"> 
                <small > </small> 
              </div>   
              <button type="submit" class="btn btn-primary"> Login </button>  
            </form>  
          </div>    
    </div>  
  </body>  
  <script src="${pageContext.servletContext.contextPath}/home/js/jquery.min.js" > </script>  
    <script src="${pageContext.servletContext.contextPath}/home/js/popper.min.js" > </script>  
    <script src="${pageContext.servletContext.contextPath}/home/js/bootstrap.min.js" > </script>  
    <script>  
    </script>
</html>  
