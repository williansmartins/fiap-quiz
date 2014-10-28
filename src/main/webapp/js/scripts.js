$(document).ready( function(){
	if( $("body").hasClass("inicio") ){
		$("#form-login\\:cpf").mask("999.999.999-99");
		$("#form-login").fadeIn( "slow", function() {
		    // Animation complete.
		  });
	}
	if( $("body").hasClass("login") ){
		$("#form-login").fadeIn( "slow", function() {
		    // Animation complete.
		  });
	}
	if( $("body").hasClass("questao") ){
		$("#form-questao").slideDown( "slow", function() {
			  $(".countdown").fadeIn( "slow", function() {
			    // Animation complete.
			  });
		  });
	}
	if( $("body").hasClass("ultima") ){
		$(".form-ultima").slideDown( "slow", function() {
		    // Animation complete.
		  });
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