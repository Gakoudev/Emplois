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
		<link rel="shortcut icon" type="image/x-icon" href="resource/assets/img/favicon.ico">

		<!-- CSS here -->
            <link rel="stylesheet" href="resource/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="resource/assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="resource/assets/css/flaticon.css">
            <link rel="stylesheet" href="resource/assets/css/price_rangs.css">
            <link rel="stylesheet" href="resource/assets/css/slicknav.css">
            <link rel="stylesheet" href="resource/assets/css/animate.min.css">
            <link rel="stylesheet" href="resource/assets/css/magnific-popup.css">
            <link rel="stylesheet" href="resource/assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="resource/assets/css/themify-icons.css">
            <link rel="stylesheet" href="resource/assets/css/slick.css">
            <link rel="stylesheet" href="resource/assets/css/nice-select.css">
            <link rel="stylesheet" href="resource/assets/css/style.css">
   </head>

   <body style="max-height:100vh; overflow: hidden;">
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="resource/assets/img/logo/logo.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Preloader Start -->
    <header>
        <!-- Header Start -->
       
        <!-- Header End -->
    </header>
    <main>
    <div class="slider-area ">
    	<!-- Modal Login -->
		<div class="modal fade" id="login" >
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Se connecter en tant que</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      
		      <div class="modal-footer text-center">
                <a href="login" class="btn head-btn1">Demandeur d'emplois</a>
		        <a href="entreprise" class="btn head-btn2">Entreprise</a>
		      </div>
		    </div>
		  </div>
		</div>
		
            <!-- Mobile Menu -->
            <div class="slider-active">
                <div style="height: 100vh;" class="single-slider slider-height2  align-items-center" data-background="resource/assets/img/hero/h1_hero.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-6 col-lg-9 col-md-10">
                                <div class="hero__caption">
                                    <h1>Trouves ton Job en un Click</h1>
                                </div>
                            </div>
                        </div>
                        <!-- Login Register -->
                        <div class="row">
                            <div class="col-xl-8">
                                <!-- form -->
                                <div class="header-btn d-none f-right d-lg-block">
                                    <a href="inscription" class="btn head-btn1">Register</a>
                                    <a class="btn head-btn2" onclick='$("#login").modal("show")'>Login</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <footer class="footer-area footer-bg  fixed-bottom">
        
        <!-- footer-bottom area -->
        <div class="footer-bottom-area footer-bg">
                <div class="footer-border">
                             <div class="footer-copy-right text-center">
                                 <p>
								   <i class="fa fa-heart" aria-hidden="true"></i><a href="https://colorlib.com" target="_blank">GakouDev</a>
								  </p>
                             </div>
                         
                     
                </div>
        </div>
        <!-- Footer End-->
    </footer>

  <!-- JS here -->
	
		<!-- All JS Custom Plugins Link Here here -->
        <script src="resource/assets/js/vendor/modernizr-3.5.0.min.js"></script>
		<!-- Jquery, Popper, Bootstrap -->
		<script src="resource/assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="resource/assets/js/popper.min.js"></script>
        <script src="resource/assets/js/bootstrap.min.js"></script>
	    <!-- Jquery Mobile Menu -->
        <script src="resource/assets/js/jquery.slicknav.min.js"></script>

		<!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="resource/assets/js/owl.carousel.min.js"></script>
        <script src="resource/assets/js/slick.min.js"></script>
        <script src="resource/assets/js/price_rangs.js"></script>
        
		<!-- One Page, Animated-HeadLin -->
        <script src="resource/assets/js/wow.min.js"></script>
		<script src="resource/assets/js/animated.headline.js"></script>
        <script src="resource/assets/js/jquery.magnific-popup.js"></script>

		<!-- Scrollup, nice-select, sticky -->
        <script src="resource/assets/js/jquery.scrollUp.min.js"></script>
        <script src="resource/assets/js/jquery.nice-select.min.js"></script>
		<script src="resource/assets/js/jquery.sticky.js"></script>
        
        <!-- contact js -->
        <script src="resource/assets/js/contact.js"></script>
        <script src="resource/assets/js/jquery.form.js"></script>
        <script src="resource/assets/js/jquery.validate.min.js"></script>
        <script src="resource/assets/js/mail-script.js"></script>
        <script src="resource/assets/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="resource/assets/js/plugins.js"></script>
        <script src="resource/assets/js/main.js"></script>
        
    </body>
</html>