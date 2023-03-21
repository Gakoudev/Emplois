<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp"></jsp:include>
<!-- Modal Editer -->
					<div class="modal fade" id="modalEditEntreprise">
					 	<div class="modal-dialog" >
						    <div class="modal-content">
						      <div class="modal-header card-header">
                 				<h6 class="m-0 font-weight-bold text-primary">Editer Entreprise</h6>
                 				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						       <div class="modal-body">
						       			
							          <div class="form-floating mb-3" >
					                   	<input class="form-control" id="idE" type="text" name="idE"  disabled/>
							          </div>
			 
					                   <!-- Nom -->
					                   
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="nomE" type="text" name="nomE" placeholder="Nom entreprise" required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="adresseE" type="text" name="adresseE" placeholder="Adresse " required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="emailE" type="text" name="emailE" placeholder="Email " required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="siteWebE" type="text" name="siteWebE" placeholder="Site Web" required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="telephoneE" type="text" name="telephoneE" placeholder="Telephone" required autofocus/>
					                   </div>
					                   
					                   <!-- Students -->
					                   
					                   <div class="form-group">
					                       <select class="form-control" name="domaineE" id="domaineE">
					                        <c:forEach var="domaine" items="${domaines}">
									
											  <option  value='<c:out value="${domaine.id}" />'><c:out value="${domaine.nom}" /></option>
											</c:forEach>
					                       </select>
					                   </div>
					                   
					                   <!-- courses -->
									
						       </div>
						       <div class="modal-footer  card-footer">
						       
					                       <!-- Bouton  Update-->
					
					                  <div class="flex items-center justify-end mt-4">
					        			  <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
					        			  <button  type="submit" onclick="editEntreprise();" class="btn btn-primary" data-dismiss="modal">Modifier</button>
					                      <!-- input type="submit" onclick="editInscription();" class="btn btn-primary" value="Valider"/> 
					                       -->
					                  </div>
						       </div>
						    </div>
					 	</div>
					</div>
                    
	<div class="row col-md-12">
            <div class="container col-md-7">
                <div class="card  mb-4">
                    <div class="card-header">
                        <h6 class="m-0 font-weight-bold text-primary">Liste des Entreprise</h6>
                    </div>
                    <div class="card-body">
                        <table id="tablesEntreprise">
                            <thead>
                                <tr>
                                    <th>Nom </th>
                                    <th>Adresse </th>
                                    <th>Email </th>
                                    <th>Site Web </th>
                                    <th>Telephone </th>
                                    <th>Editer</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                    <th>Nom </th>
                                    <th>Adresse </th>
                                    <th>Email </th>
                                    <th>Site Web </th>
                                    <th>Telephone </th>
                                    <th>Editer</th>
                                </tr>
                            </tfoot>
                            <tbody class="tEntreprise">
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
            <div class="container col-md-4"> 
               <div class="card"> 
                   <div class="card-header">
                       <h6 class="m-0 font-weight-bold text-primary">Formulaire d'ajout d'Entreprise</h6>
                   </div>
       
                       
                       <!-- Libelle -->
                       
                      
			 
					                   <!-- Nom -->
					                   
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="nom" type="text" name="nom" placeholder="Nom entreprise" required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="description" type="text" name="description" placeholder="Description " required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="adresse" type="text" name="adresse" placeholder="Adresse " required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="email" type="text" name="email" placeholder="Email " required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="siteWeb" type="text" name="siteWeb" placeholder="Site Web" required autofocus/>
					                   </div>
					                   <div class="form-floating mb-3">   
					                   	<input class="form-control" id="telephone" type="text" name="telephone" placeholder="Telephone" required autofocus/>
					                   </div>
					                   
					                   <!-- Students -->
					                   
					                   <div class="form-group">
					                       <select class="form-control" name="domaine" id="domaine">
					                        <c:forEach var="domaine" items="${domaines}">
									
											  <option  value='<c:out value="${domaine.id}" />'><c:out value="${domaine.nom}" /></option>
											</c:forEach>
					                       </select>
					                   </div>
					                   
					                   <!-- courses -->
									
								

                       <!-- Bouton  Ajouter-->

                       <div class="flex items-center justify-end mt-4">
                           <input type="submit" class="btn btn-primary" onclick="addEntreprise();" value="Ajouter"/>
                       </div>
                      
               </div>
           </div>
       </div>
      
<jsp:include page="../footer.jsp"></jsp:include>