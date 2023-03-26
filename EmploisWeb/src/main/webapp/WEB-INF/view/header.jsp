<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
         <title>Sama Job </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
		<link rel="shortcut icon" type="image/x-icon" href="../resource/assets/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="../resource/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="../resource/assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="../resource/assets/css/flaticon.css">
            <link rel="stylesheet" href="../resource/assets/css/price_rangs.css">
            <link rel="stylesheet" href="../resource/assets/css/slicknav.css">
            <link rel="stylesheet" href="../resource/assets/css/animate.min.css">
            <link rel="stylesheet" href="../resource/assets/css/magnific-popup.css">
            <link rel="stylesheet" href="../resource/assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="../resource/assets/css/themify-icons.css">
            <link rel="stylesheet" href="../resource/assets/css/slick.css">
            <link rel="stylesheet" href="../resource/assets/css/nice-select.css">
            <link rel="stylesheet" href="../resource/assets/css/style.css">
   </head>

   <body>
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="../resource/assets/img/logo/logo.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
       <div class="header-area header-transparrent">
           <div class="headder-top header-sticky">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-3 col-md-2">
                            <!-- Logo -->
                            <div class="logo">
                                <a href="index.html"><img src="../resource/assets/img/logo/logo.png" alt=""></a>
                            </div>  
                        </div>
                        <div class="col-lg-9 col-md-9">
                            <div class="menu-wrapper">
                                <!-- Main-menu -->
                                <div class="main-menu">
                                    <nav class="d-none d-lg-block">
                                    	<ul id="navigation">
                                    <%
									   // Vérifier si l'attribut "profile" existe dans la session
									   if (session.getAttribute("profile") != null) {
									      // Récupérer la valeur de l'attribut "profile"
									      String profile = (String) session.getAttribute("profile");
									      
									      // Vérifier si la valeur de l'attribut "profile" est égale à "admin"
									      if (profile.equals("User")) {
									    	  %>
									         
	                                            <li><a href="http://localhost:8080/SamaJob/liste/offres">Offres d'emplois </a></li>
	                                            <li><a href="http://localhost:8080/SamaJob/samaCv/editer">Modifier mon CV</a></li>
	                                            <li><a href="http://localhost:8080/SamaJob/samaCv/pdf">Imprimer mon CV</a></li>
                                        	 
									    	  <%
									      }
									      else
									    	  if(profile.equals("Admin")){
									    		  %>
		                                            <li><a href="entreprise">Entreprise</a></li>
		                                            <li><a href="domaine">Domaine</a></li>
	                                            <%
									    	  }
										      else
										    	  if(profile.equals("Entreprise")){
										    		  
										    	  }
									   }
									%>
                                        
                                        </ul>
                                    </nav>
                                </div>          
                                <!-- Header-btn -->
                                <div class="header-btn d-none f-right d-lg-block">
                                    <a href="http://localhost:8080/SamaJob/logout" class="btn head-btn2">Logout</a>
                                </div>
                            </div>
                        </div>
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
           </div>
       </div>
        <!-- Header End -->
    </header>
    <main>