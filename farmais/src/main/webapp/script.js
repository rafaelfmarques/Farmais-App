/**
 * 
 */

function confirma(idrem){
	var resposta = confirm("Confirma a exclusão?");
	if (resposta == true){
		//alert(idrem);
		window.location.href= "deletar?idrem=" + idrem;
	}
}

