<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
		<link rel="shortcut icon" type="image/x-icon" href="resource/assets/img/favicon.ico">

    <title>Login</title>

    <!-- Custom fonts for this template-->
            <link rel="stylesheet" href="resource/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="resource/assets/css/animate.min.css">
            <link rel="stylesheet" href="resource/assets/css/magnific-popup.css">
            <link rel="stylesheet" href="resource/assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="resource/assets/css/themify-icons.css">
            <link rel="stylesheet" href="resource/assets/css/slick.css">
            <link rel="stylesheet" href="resource/assets/css/nice-select.css">
            <link rel="stylesheet" href="resource/assets/css/style.css">

</head>

<body class="bg-danger">
	<c:choose>
	   	<c:when test="${erreur != null}">
		<script>
		window.onload = function() {
	        alert("email ou mot de passe incorrect !!!");
	      }
				
		</script>
	   		
	   	</c:when>
	 </c:choose>
	<section class="vh-100">
	  <div class="container py-5 h-100 mt-50">
	    <div class="row d-flex align-items-center justify-content-center h-100">
	      <div class="col-md-8 col-lg-7 col-xl-6">
	        <img src="resource/login/img/draw2.png"
	          class="img-fluid" alt="Phone image">
	      </div>
	      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
	        <form class="user" action="entreprise" name="entreprise" method="post">
	          <!-- Email input -->
	          <div class="form-group">
                  <input type="email" class="form-control form-control-lg"
                      id="email" aria-describedby="emailHelp" name="email"
                      placeholder="Adresse Email">
              </div>
              
	          <!-- Password input -->
              <div class="form-group">
                  <input type="password" class="form-control form-control-lg"
                      id="exampleInputPassword" name="password" placeholder="Mot de Passe">
              </div>
	
	
	          <!-- Submit button -->
	          <button type="submit" class="btn-primary btn-lg btn-block">Login</button>
	
	        </form>
	      </div>
	    </div>
	  </div>
	</section>


		<!-- All JS Custom Plugins Link Here here -->
        <script src="resource/assets/js/vendor/modernizr-3.5.0.min.js"></script>
		<!-- Jquery, Popper, Bootstrap -->
		<script src="resource/assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="resource/assets/js/popper.min.js"></script>
        <script src="resource/assets/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="resource/assets/js/jquery.slicknav.min.js"></script>


        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="resource/assets/js/plugins.js"></script>
        <script src="resource/assets/js/main.js"></script>

</body>

</html>