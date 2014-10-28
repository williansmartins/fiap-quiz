$(document).ready( function(){
	if( $("body").hasClass("home") ){
		$("#form-login\\:cpf").mask("999.999.999-99");
	}
	
	//////////////////////////////////////////////////////////////////
	//Bloquear o botao direito do mouse
	document.oncontextmenu = document.body.oncontextmenu = function() {return false;}
	//////////////////////////////////////////////////////////////////
	//FIM - Bloquear o botao direito do mouse
	
});

function trocou(){
	$("#form-questao\\:chute").val( $('input[name=alternativas]:checked').val() );
}