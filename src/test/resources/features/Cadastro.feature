# language: pt

Funcionalidade: Cadastro de Usuario

  Cenario: Cadastro completo com sucesso
    Dado o usuario acessa pagina de cadastro
    Quando preenche o formulario com dados validos
    E realiza o cadastro
    Entao eh redirecionado para a pagina inicial

  Cenario: Um usuario com email invalido nao consegue se logar
    Dado o usuario acessa pagina de cadastro
    Quando preenche o formulario com email invalido
    E tenta se logar
    Entao continua na pagina de cadastro com mensagem de email invalido