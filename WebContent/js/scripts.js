$(document).ready( function(){
	$('#slider').slider({
      formater: function(value) {
        return value + ' Reais';
      }
    });

    $('.dropdown-toggle').dropdown();

    $('.show-image').click(function(){
    	$('.imagem-grande').attr( 'src', 'img/' + $(this).attr('data-url') );
    });

});

