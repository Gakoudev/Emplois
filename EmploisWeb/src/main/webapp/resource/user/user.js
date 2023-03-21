

$(document).ready(function() {
	 loadDataOffre();

});
function loadDataOffre() {
		 $.ajax({
		 url: "/SamaJob/offres/liste",
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
			 html += '<div class="items-link items-link2 f-right"><a href="job_details.html">' + item.typeJob + '</a>';
			 html += '<span>limite: '+ item.dateLimite + '</span>';
			 html += '</div></div>';
			 });
			 $('.tOffre').html(html);
			 },
		 });
	
}

