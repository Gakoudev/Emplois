

$(document).ready(function() {
	 loadDataDomaine();

});
function loadDataDomaine() {
		 $.ajax({
		 url: "/SamaJob/admin/domaine/liste",
		 type: "GET",
		 dataType: "json",
		 
		 success: function (result) {
			 
			
		 var html = '';
			 $.each(result, function (key, item) {
				 
				 html += '<div class="single-job-items mb-30">';
				 html += '<div class="job-items">';
				 html += '<div class="company-img">';
				 html += '<a ><img src="../resource/assets/img/icon/domaine.png"" alt=""></a></div>';
				 html += '<div class="job-tittle job-tittle2">';
				 html += '<h4>'+  item.nom + '</h4>';
				 html += '</a><ul><li></li>';
				 html += '<li></li></ul></div></div>';
				 html += '<div class="items-link items-link2 f-right"><a data-toggle="modal" data-target="#modaldeleteDomaine" data-whatever='+item.id+'><i class=" fas fa-fw fa-trash"></i></a>';
			 	 html += '</div></div>';
			 	/*  
			 html += '<tr>';
			 html += '<td>' + item.nom + '</td>';
			 html += '<td><button class="btn btn-primary" data-toggle="modal" data-target="#modaldeleteDomaine" data-whatever='+item.id+'><i class="fas fa-fw  fa-trash "></i></button> ';
			 html += '</tr>';
			*/
			 });
			 $('.tbody').html(html);
			 },
		 });
	
}

/**
 * DOMAINE
 */
function addDomaine(){
	$.ajax({
		url:'/SamaJob/admin/domaine',
		type:'Post',
		dataType:'html',
		data:'nom='+$("#nom").val(),
		success : function(code_html,status){
			loadDataDomaine();
			alert(code_html);
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}




function deleteDomaine(){
	$.ajax({
		url:'http://localhost:8080/SamaJob/admin/domaine/delete',
		type:'Post',
		dataType:'html',
		data:'idD='+$("#idD").val(),
		success : function(code_html,status){
			alert(code_html);
			loadDataDomaine();
			$("#modaldeleteDomaine").modal("hide");
		},
		error : function(html,erreur,code){
			alert(erreur);
			
		}
	});
}

$('#modaldeleteDomaine').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget) // Button that triggered the modal
  var id = button.data('whatever') // Extract info from data-* attributes
  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
  var modal = $(this)
  modal.find('.modal-body input').val(id)
})

