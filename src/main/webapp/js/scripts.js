$(document).ready( function(){
	
	//Bloquear o botao direito do mouse
	var mensagem = "Não copie, além de imoral é crime!";
//	
//	if (document.layers) {
//		document.captureEvents(Event.MOUSEDOWN);
//		document.onmousedown = clickNS;
//	} else {
//		document.onmouseup = clickNS;
//		document.oncontextmenu = clickIE;
//	}
//	document.oncontextmenu = new Function("return false");
    
	$('#modal-cliente\\:interesse').val( $('.titulo').html() );
	$('#modal-cliente\\:imovel_id').val( $('#form-imovel\\:imovel_id_imovel').val() );
	
	if($("body").hasClass("home") ){
	    
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

	if($("body").hasClass("resultado")){
		
		//Permite o clique no quadrante chamando a tela do imovel especifico
		$(".imovel.quadrante").css( "cursor", "pointer" );
		$(".imovel.quadrante").click(function (){
			console.info($(this).attr("data-imovel-id"));
			window.location.replace("imovel.xhtml?imovel_id=" + $(this).attr("data-imovel-id") );
		});
		
	}
		
	if($("body").hasClass("imovel")){
		//$('.dropdown-toggle').dropdown();
		
		$('.show-image').click(function(){
			$('.imagem-grande').attr( 'src', 'img/' + $(this).attr('data-url') );
		});
		
		//Apresentaçao das caracteristicas e recursos em formato de lista
	    var arr = $("#caracteristicas").attr("data-valor").split(";");
	    for(var i = 0; i < arr.length; i++){
	    	$("#caracteristicas").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	    var arr = $("#recursos").attr("data-valor").split(";");
	    console.info(arr);
	    for(var i = 0; i < arr.length; i++){
	    	$("#recursos").append( "<li>" + arr[i] + "</li>" );
	    }
	    
	    $(".telefone").mask("(99) 9999-9999");
	    $(".celular").mask("(99) 9999-9999?9");
	    
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

function clickIE() {
	if (document.all) {
		(mensagem);
		return false;
	}
}
function clickNS(e) {
	if ( document.layers ) {
		if (e.which == 2 || e.which == 3) {
			alert(mensagem);
			return false;
		}
	}
}