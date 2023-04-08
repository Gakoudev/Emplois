

$(document).ready(function() {
	 loadDataEntreprise();

});
function loadDataEntreprise() {
		 $.ajax({
		 url: "/SamaJob/admin/entreprise/liste",
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
				 html += '<h4>'+  item.nom + '</h4>';
				 html += '</a><ul><li>'+ item.telephone +'</li>';
				 html += '<li>' + item.siteWeb + '</li></ul></div></div>';
				 html += '<div class="items-link items-link2 f-right"><a data-toggle="modal" data-target="#modalEditEntreprise" data-whatever='+item.id+'><i class=" fas fa-fw fa-pencil-alt"></i></a>';
				 html += '<span> '+ item.email + '</span>';
			 	 html += '</div></div>';
			 /*
			 html += '<tr>';
			 html += '<td>' + item.nom + '</td>';
			 html += '<td>' + item.adresse + '</td>';
			 html += '<td>' + item.email + '</td>';
			 html += '<td>' + item.siteWeb + '</td>';
			 html += '<td>' + item.telephone + '</td>';
			 html += '<td><button class="btn btn-primary" data-toggle="modal" data-target="#modalEditEntreprise" data-whatever='+item.id+'><i class="fas fa-fw  fa-pen "></i></button> ';
			 html += '</tr>';
			 */
			 });
			 $('.tEntreprise').html(html);
			 },
		 });
	
}


/**
 * ENTREPRISE
 */
function addEntreprise(){
	$.ajax({
		url:'/SamaJob/admin/entreprise',
		type:'Post',
		dataType:'html',
		data:'nom='+$("#nom").val()+'&description='+$("#description").val()+'&domaine='+$("#domaine").val()+'&adresse='+$("#adresse").val()+'&email='+$("#email").val()+'&siteWeb='+$("#siteWeb").val()+'&telephone='+$("#telephone").val(),
		success : function(code_html,status){
			loadDataEntreprise();
			alert(code_html);
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}



function editEntreprise(){
	$.ajax({
		url:'http://localhost:8080/SamaJob/admin/entreprise/edit',
		type:'Post',
		dataType:'html',
		data:'idE='+$("#idE").val()+'&nomE='+$("#nomE").val()+'&domaineE='+$("#domaineE").val()+'&adresseE='+$("#adresseE").val()+'&emailE='+$("#emailE").val()+'&siteWebE='+$("#siteWebE").val()+'&telephoneE='+$("#telephoneE").val(),
		success : function(code_html,status){
			loadDataEntreprise();
			alert(code_html);
			
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}


function deleteEntreprise(){
	$.ajax({
		url:'SamaJob/admin/entreprise/delete',
		type:'Post',
		dataType:'html',
		data:'idEntreprise='+$("#idEntreprise").val(),
		success : function(code_html,status){
			location.reload();
			alert(code_html);
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}

$('#modaldeleteEntreprise').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var id = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('.modal-body input').val(id)
})



$('#modalEditEntreprise').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var id = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  $.ajax({
		url:'http://localhost:8080/SamaJob/admin/entreprise/edit',
		type:'Get',
		dataType:'json',
		data:'idE='+id,
		success : function(data){ 
			$("#idE").val(data.id);
			$("#nomE").val(data.nomE);
			$("#adresseE").val(data.adresseE);
			$("#emailE").val(data.emailE);
			$("#siteWebE").val(data.siteWebE);
			$("#telephoneE").val(data.telephoneE);
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
})