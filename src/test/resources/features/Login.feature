# language: pt

@login
Funcionalidade: Login de Usuario

	Contexto: 
		Dado o usuario entra no site 
		Quando entra na area de login

	@login_valido
	Cenario:
		E preenche os dados corretos 
		E clica para logar
		Entao login completo
		
	@login_invalido
	Cenario:
		E preenche um dos dados incorretamente
		E clica para logar
		Entao nao foi possivel concluir o login 
