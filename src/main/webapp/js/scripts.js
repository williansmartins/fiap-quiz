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

    $('#myTab a:first').tab('show');
    
    $("input[name=radio-home]").prop("checked", true).trigger("click");
    $("input[name=radio-carousel]").prop("checked", true).trigger("click");

    $("#option1").change(function (e){
    	$("#imovel-form\\:radio1").val(true);
    });
    $("#option2").change(function (e){
    	$("#imovel-form\\:radio1").val(false);
    });
    
    
    $("#option3").change(function (e){
    	$("#imovel-form\\:radio2").val(true);
    });
    $("#option4").change(function (e){
    	$("#imovel-form\\:radio2").val(false);
    });
    
    $(".popularImovel").click(function (e){
    	e.preventDefault();
    	$('#imovel-form\\:titulo').val("Residencial Ametista")
    	$('#imovel-form\\:valor').val("150000")
    	$('#imovel-form\\:dormitorios').val("2")
    	$('#imovel-form\\:metros').val("54.0")
    	$('#imovel-form\\:vagas').val("1")
    	$('#imovel-form\\:cidade').val("Cotia")
    	$('#imovel-form\\:fita').val("aluga")
    	
    	$('#imovel-form\\:descricaoCompleta').val("descricaoCompleta")
    	$('#imovel-form\\:descricaoQuadrante').val("descricaoQuadrante")
    	$('#imovel-form\\:descricaoCarousel').val("descricaoCarousel")
    	
    	$('#imovel-form\\:caracteristicas').val("caracteristica1;caracteristica2;caracteristica2;caracteristica3")
    	$('#imovel-form\\:recursos').val("recurso1;recurso2;recurso2;recurso3")
    	
    	$('#imovel-form\\:maps').val("https://www.google.com.br/maps/place/")
    	$('#imovel-form\\:endereco').val("Rua Amapá, 345 - Jardim Rosalina - Cotia - SP - 06608-430")
    });
    
    
});