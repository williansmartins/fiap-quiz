$(document).ready( function(){
	
	if($("body").hasClass("home")){
	    
		//Permite o clique no quadrante chamando a tela do imovel especifico
		$(".imovel.quadrante").css( "cursor", "pointer" );
		$(".imovel.quadrante").click(function (){
			console.info($(this).attr("data-imovel-id"));
			window.location.replace("imovel.xhtml?imovel_id=" + $(this).attr("data-imovel-id") );
		});
		
		$('#slider').slider({
			formater: function(value) {
				return value + ' Reais';
			}
		});
	}
		
	if($("body").hasClass("imovel")){
		//$('.dropdown-toggle').dropdown();
		
		$('.show-image').click(function(){
			$('.imagem-grande').attr( 'src', 'img/' + $(this).attr('data-url') );
		});
		
	    var arr = $("#caracteristicas").attr("data-valor").split(";").slice(0,-1);
	    for(var i = 0; i<arr.length; i++){
	    	$("#caracteristicas").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	    var arr = $("#recursos").attr("data-valor").split(";").slice(0,-1);
	    for(var i = 0; i<arr.length; i++){
	    	$("#recursos").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	}


    //$('#myTab a:first').tab('show');
    
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
function check(){
	var valores = $("input[name='preco']").val().split(",");
	$("input[name='min']").val( valores[0] );
	$("input[name='max']").val(valores[1]);
}