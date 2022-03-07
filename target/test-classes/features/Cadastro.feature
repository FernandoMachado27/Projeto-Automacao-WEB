# language: pt

@cadastro
Funcionalidade: Cadastro de Usuario

	Contexto:
		Dado o usuario acessa o site
		Quando clica para fazer login
		E clica para criar nova conta
    
  @cadastro_valido_excel
  Cenario: Cadastro completo pelo excel com sucesso
    E preenche o formulario com dados validos do excel
    E tenta se logar
    Entao e redirecionado para a pagina inicial    
    
  @cadastro_email_invalido_excel
  Cenario: Um usuario com email invalido do excel nao consegue se logar
    E preenche o formulario com email invalido do excel
    E tenta se logar
    Entao continua na pagina de cadastro com mensagem de email invalido
    
  @cadastro_adicionando_apenas_email
  Cenario: Um usuario tenta se logar preenchendo apenas o campo de email
    E preenche apenas o campo de email
    E tenta se logar 
    Entao continua na pagina de cadastro com mensagem de username pass e confirmPass invalidos
 