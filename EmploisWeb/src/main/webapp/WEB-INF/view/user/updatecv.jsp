<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<jsp:include page="../header.jsp"/>
	<div class="section-top-border">
				<div class="row">
					<div class="col-lg-8 col-md-8">
						<h3 class="mb-30 text-center">Mettre à jours mon CV</h3>
						<form action="editer" method="post">
							
							<div class="mt-10">
								<input type="text" name="telephone" placeholder="${cv.telephone}" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Téléphone'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="adresse" placeholder="${cv.adresse}" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Adresse'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="age" placeholder="${cv.age}" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Age'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="niveauEtude" placeholder="${cv.niveauEetude}" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Niveau d'Etude'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<input type="text" name="specialite" placeholder="${cv.specialite}" 
									onfocus="this.placeholder = ''" onblur="this.placeholder = 'Spécialité'" required
									class="single-input">
							</div>
							<div class="mt-10">
								<textarea class="single-textarea" name="experience" placeholder="${cv.experienceProfessionnelle}" onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Expérience Professionnelle'" required></textarea>
							</div>
                       <div class="mt-10 text-center">
                           <input type="submit" class="btn btn-primary"  value="Modifier">
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
	<jsp:include page="../footer.jsp"/>