# language: pt

@pesquisa
Funcionalidade: Consultar produto pela tela principal, utilizando o campo de pesquisa

	Contexto:
		Dado o usuario esta na pagina inicial e acessa a area de pesquisa

	@produto_existente
	Cenario: Consultar um produto ate a tela que mostra o produto
		Quando pesquisa um produto
		Entao o produto e encontrado com sucesso
		
	@produto_inexistente
	Cenario: Consultar um produto que nao existe 	
		Quando pesquisa um produto que nao existe 
		Entao o produto nao e encontrado