$(document).ready( function(){
	if( $("body").hasClass("home") ){
		$("#form-login\\:cpf").mask("999.999.999-99");
	}
	
	$('input[name=alternativas]').change(function (e){
    	$("#form-questao\\:chute").val( $(this).val() );
    });
	
});