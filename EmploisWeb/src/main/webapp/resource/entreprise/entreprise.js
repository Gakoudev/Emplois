

$(document).ready(function() {
	 loadDataOffre();

});
function loadDataOffre() {
		 $.ajax({
		 url: "/SamaJob/entreprise/offres/liste",
		 type: "GET",
		 dataType: "json",
		 
		 success: function (result) {
			 
			
		 var html = '';
			 $.each(result, function (key, item) {
			 html += '<div class="single-job-items mb-30">';
			 html += '<div class="job-items">';
			 html += '<div class="company-img">';
			 html += '<a href="#"><img src="../resource/assets/img/icon/entreprise.png"" alt=""></a></div>';
			 html += '<div class="job-tittle job-tittle2">';
			 html += '<a href="#">';
			 html += '<h4>'+ item.titre + '</h4>';
			 html += '</a><ul><li>'+ item.entreprise.nom +'</li>';
			 html += '<li><i class="fas fa-map-marker-alt"></i>' + item.localisation + '</li>';
			 html += '<li>' + item.salaire + '</li></ul></div></div>';
			 html += '<div class="items-link items-link2 f-right"><a href="/SamaJob/offre/details" name="id" value="' + item.id +'">' + item.typeJob + '</a>';
			 html += '<span>limite: '+ item.dateLimite + '</span>';
			 html += '</div></div>';
			 });
			 $('.tOffre').html(html);
			 },
		 });
	
}


/**
 * OFFRE
 */
function addOffre(){
	$.ajax({
		url:'/SamaJob/entreprise/offres',
		type:'Post',
		dataType:'html',
		data:'titre='+$("#titre").val()+'&description='+$("#description").val()+'&localisation='+$("#localisation").val()+'&salaire='+$("#salaire").val()+'&dateLimite='+$("#dateLimite").val()+'&competence='+$("#competence").val()+'&experience='+$("#experience").val()+'&typeJob='+$("#typeJob").val()+'&entreprise='+$("#entreprise").val()+'&domaine='+$("#domaine").val(),
		success : function(code_html,status){
			loadDataOffre();
			alert(code_html);
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}


