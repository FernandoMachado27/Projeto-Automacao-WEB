# language: pt

@login
Funcionalidade: Login de Usuario

	Contexto: 
		Dado o usuario acessa pagina de login

	@login_valido
	Cenario:
		Quando preenche os dados corretos 
		E clica para logar
		Entao login completo
		
	@login_invalido
	Cenario:
		Quando preenche um dos dados incorretamente
		E clica para logar
		Entao nao foi possivel concluir o login 
