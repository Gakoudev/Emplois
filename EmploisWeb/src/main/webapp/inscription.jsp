<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<jsp:include page="header.jsp"/>
	<div class="section-top-border">
				<div class="row">
					<div class="col-lg-8 col-md-8">
						<h3 class="mb-30 text-center">S'Inscrire</h3>
						<form action="registrer" method="post">
							<div class="mt-10">
								<input type="text" name="prenom" placeholder="Prénom"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Prénom'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="nom" placeholder="Nom"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Nom'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="email" name="email" placeholder="Adress Email"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Adress Email'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="password" name="password" placeholder="Mot de Passe"
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Mot de Passe'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="telephone" placeholder="Téléphone" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Téléphone'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="adresse" placeholder="Adresse" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Adresse'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="age" placeholder="Age" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Age'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="niveauEtude" placeholder="Niveau d'Etude" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Niveau d'Etude'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="specialite" placeholder="Spécialité" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Spécialité'" required
									class="single-input">
							</div>
							<div class="input-group-icon mt-10">
								<div class="icon"><i class="fa fa-globe" aria-hidden="true"></i></div>
								<div class="form-select" id="default-select"">
									<select name="domaine" >
										<c:forEach var="domaine" items="${domaines}">
											<option value="<c:out value="${domaine.id}" />"><c:out value="${domaine.nom}" /></option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="mt-10">
								<textarea class="single-textarea" name="experience" placeholder="Expérience Professionnelle" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Expérience Professionnelle'" required></textarea>
							</div>
                       <div class="mt-10 text-center">
                           <input type="submit" class="btn btn-primary"  value="Ajouter">
                       </div>
							<!-- For Gradient Border Use -->
							<!-- <div class="mt-10">
										<div class="primary-input">
											<input id="primary-input" type="text" name="first_name" placeholder="Primary color" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Primary color'">
											<label for="primary-input"></label>
										</div>
									</div> -->
						</form>
						

					</div>
				</div>
			</div>
			<div  class="mt-70"></div>
	<jsp:include page="footer.jsp"/>