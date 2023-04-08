<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>
		<div class="modal fade" id="modaldeleteDomaine" >
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Confirmation Suppression</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		        <input type="text" class="form-control" id="idD" disabled style="display:none" />
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer text-center">
                <button type="button" onclick="deleteDomaine();" class="btn head-btn1">Supprimer</button>
		        <button type="button" class="btn head-btn2" data-dismiss="modal">Annuler</button>
		      </div>
		    </div>
		  </div>
		</div>
	 <div class="row col-md-12">
                     <div class="col-xl-7 col-lg-7 col-md-6">
                        <!-- Featured_job_start -->
                        <section class="featured-job-area">
                            <div class="container tbody">
                                <!-- single-job-content -->
                                
                                    
                                        
                                        
                                            
                                                
                                            
             				</div>
             			</section>
             		</div>       
            <div class="container col-md-5"> 
               <div class="card"> 
                   <div class="card-header">
                       <h6 class="m-0 font-weight-bold text-primary">Formulaire d'ajout de domaine</h6>
                   </div>
       
                       
                       <!-- Libelle -->
                       
                       <div class="form-floating mb-3">   
                       <input class="form-control" id="nom" type="text" name="nom" placeholder="Nom Domaine" required autofocus/>
                       </div> 
       
                       <!-- Détail -->
                       

                       <!-- Bouton  Ajouter-->

                       <div class="flex items-center justify-end mt-4">
                           <input type="submit" class="btn btn-primary" onclick="addDomaine();" value="Ajouter"/>
                       </div>
                      
               </div>
           </div>
       </div>
     
<jsp:include page="../footer.jsp"></jsp:include>