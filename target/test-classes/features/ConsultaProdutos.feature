# language: pt

@pesquisa
Funcionalidade: Consultar produto pela tela principal, utilizando o campo de pesquisa

	Cenario: Consultar um produto ate a tela que mostra o produto
		Dado o usuario esta na pagina inicial e acessa a area de pesquisa
		Quando pesquisa um produto
		Entao o produto eh encontrado com sucesso
		
	Cenario: Consultar um produto que nao existe 	
		Dado o usuario esta na pagina inicial e acessa a area de pesquisa
		Quando pesquisa um produto que nao existe 
		Entao o produto nao eh encontrado