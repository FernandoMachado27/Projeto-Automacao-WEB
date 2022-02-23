# language: pt

@pesquisa
Funcionalidade: Consultar produto pela tela principal, utilizando o campo de pesquisa

	Contexto:
		Dado o usuario abre o site
		Quando acessa a area de pesquisa

	@produto_existente
	Cenario: Consultar um produto ate a tela que mostra o produto
		E pesquisa um produto
		Entao o produto e encontrado com sucesso
		
	@produto_inexistente
	Cenario: Consultar um produto que nao existe 	
		E pesquisa um produto que nao existe 
		Entao o produto nao e encontrado