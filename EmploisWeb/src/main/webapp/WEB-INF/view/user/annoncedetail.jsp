<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<!-- job post company Start -->
        <div class="job-post-company pt-120 pb-120">
            <div class="container">
                <div class="row justify-content-between">
                    <!-- Left Content -->
                    <div class="col-xl-7 col-lg-8">
                        <!-- job single -->
                        <div class="single-job-items mb-50">
                            <div class="job-items">
                                <div class="company-img company-img-details">
                                    <a href="#"><img src="assets/img/icon/job-list1.png" alt=""></a>
                                </div>
                                <div class="job-tittle">
                                    <a href="#">
                                        <h4><c:out value="${annonce.titre}" /></h4>
                                    </a>
                                    <ul>
                                        <li><c:out value="${annonce.entreprise.nom}" /></li>
                                        <li><i class="fas fa-map-marker-alt"></i><c:out value="${annonce.localisation}" /></li>
                                        <li><c:out value="${annonce.salaire}" /></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                          <!-- job single End -->
                       
                        <div class="job-post-details">
                            <div class="post-details1 mb-50">
                                <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Description du Poste</h4>
                                </div>
                                <p> <c:out value="${annonce.description}" /></p>
                            </div>
                            <div class="post-details2  mb-50">
                                 <!-- Small Section Tittle -->
                                <div class="small-section-tittle">
                                    <h4>Experience</h4>
                                </div>
                               <ul>
                                   <li><c:out value="${annonce.experience}" /></li>
                               </ul>
                            </div>
                        </div>

                    </div>
                    <!-- Right Content -->
                    <div class="col-xl-4 col-lg-4">
                        <div class="post-details3  mb-50">
                            <!-- Small Section Tittle -->
                           <div class="small-section-tittle">
                               <h4>Apperçu du Poste</h4>
                           </div>
                          <ul>
                              <li>Lieu : <span><c:out value="${annonce.localisation}" /></span></li>
                              <li>Nature : <span><c:out value="${annonce.typeJob}" /></span></li>
                              <li>Salaire :  <span><c:out value="${annonce.salaire}" /></span></li>
                              <li>Date limite: <span><c:out value="${annonce.dateLimite}" /></span></li>
                          </ul>
                         <div class="apply-btn2">
                            <a href="http://localhost:8080/SamaJob/postuler/offre?email=<c:out value="${annonce.entreprise}" />&?id2=" class="btn">Postuler</a>
                         </div>
                       </div>
                        <div class="post-details4  mb-50">
                            <!-- Small Section Tittle -->
                           <div class="small-section-tittle">
                               <h4>Apropos de l'entreprise</h4>
                           </div>
                              <span>Description</span>
                              <p><c:out value="${annonce.entreprise.description}" /></p>
                            <ul>
                                <li>Name: <span><c:out value="${annonce.entreprise.nom}" /> </span></li>
                                <li>Web : <span> <c:out value="${annonce.entreprise.siteWeb}" /></span></li>
                                <li>Email: <span><c:out value="${annonce.entreprise.email}" /></span></li>
                            </ul>
                       </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- job post company End -->

<jsp:include page="../footer.jsp"></jsp:include>