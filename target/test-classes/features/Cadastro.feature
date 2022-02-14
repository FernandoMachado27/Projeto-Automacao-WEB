# language: pt

@cadastro
Funcionalidade: Cadastro de Usuario

	Contexto:
		Dado o usuario acessa pagina de cadastro

	@cadastro_valido
  Cenario: Cadastro completo com sucesso
    Quando preenche o formulario com dados validos
    E tenta se logar
    Entao eh redirecionado para a pagina inicial

	@cadastro_email_invalido
  Cenario: Um usuario com email invalido nao consegue se logar
    Quando preenche o formulario com email invalido
    E tenta se logar
    Entao continua na pagina de cadastro com mensagem de email invalido
    
  @cadastro_valido_excel
  Cenario: Cadastro completo pelo excel com sucesso
    Quando preenche o formulario com dados validos do excel
    E tenta se logar
    Entao eh redirecionado para a pagina inicial    
    
  @cadastro_email_invalido_excel
  Cenario: Um usuario com email invalido do excel nao consegue se logar
    Quando preenche o formulario com email invalido do excel
    E tenta se logar
    Entao continua na pagina de cadastro com mensagem de email invalido
    
  @cadastro_adicionando_apenas_email
  Cenario: Um usuario tenta se logar preenchendo apenas o campo de email
  Quando preenche apenas o campo de email
  E tenta se logar 
  Entao continua na pagina de cadastro com mensagem de username pass e confirmPass invalidos
 