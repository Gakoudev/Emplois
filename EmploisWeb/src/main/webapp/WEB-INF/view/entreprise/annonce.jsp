<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>

<div class="modal fade" id="modalOffre" >
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Nouveau Offre d'emplois</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body text-center">
		      	<form method="post" action="offres">
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<input type="text" name="titre" placeholder="Titre" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Titre'" required class="single-input">
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<input type="date" name="dateLimite"   required class="single-input">
							</div>
               				<div class="form-floating mb-3 mt-10">   
				                   <textarea class="single-textarea" name="description" placeholder="Description Offre" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Description'" required></textarea>
							</div>
               				<div class="form-floating mb-3 mt-10">   
				                   <textarea class="single-textarea" name="experience" placeholder="Expérience" onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Expérience'" required></textarea>
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<input type="text" name="localisation" placeholder="Lieu" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Lieu'" required class="single-input">
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<input type="text" name="salaire" placeholder="Salaire" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Salaire'" required class="single-input">
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-thumb-tack" aria-hidden="true"></i></div>
								<input type="text" name="typeJob" placeholder="Remote/FullTime ..." onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Remote/FullTime ...'" required class="single-input">
							</div>
							 <div class="form-group">
		                       <select class="form-control" name="domaine" id="domaine">
		                        <c:forEach var="domaine" items="${domaines}">
						
								  <option  value='<c:out value="${domaine.id}" />'><c:out value="${domaine.nom}" /></option>
								</c:forEach>
		                       </select>
		                   </div>
		                 
                <button type="submit"  class="btn head-btn1">Valider</button>  
		          </form>
		      </div>
		      <div class="modal-footer text-center">
                <button type="submit" onclick='addOffre();' class="btn head-btn1">Valider</button>
		        <button type="button" data-dismiss="modal" class="btn head-btn2">Annuler</button>
		      </div>
		    </div>
		  </div>
		</div>
	
	<button class="btn head-btn1"  onclick='$("#modalOffre").modal("show")'><i  class="fas fa-fw fa-plus-circle text-primary "></i> </button>
	
		<div class="job-listing-area pt-120 pb-120">
                  
            <div class="container">
                <div class="row">
                    <!-- Left content -->
                   
                    <!-- Right content -->
                    <div class="col-xl-9 col-lg-9 col-md-8">
                        <!-- Featured_job_start -->
                        <section class="featured-job-area">
                            <div class="container tEOffre">
                                <!-- single-job-content -->
                                
                                    
                                        
                                        
                                            
                                                
                                            
             				</div>
             			</section>
             		</div>
             	</div>
             </div>
        </div>                               
                                                
                                                
                                                
                                            
                                        
                                    
                                        
                                        
                                    
                               
                       
                        <!-- Featured_job_end -->
              
        <!-- Job List Area End -->


<jsp:include page="../footer.jsp"></jsp:include>