# language: pt
  # encoding: utf-8

Funcionalidade: Inserir os dados do veículo

  Cenário: Preenchimento dos dados
    Dado que o usuario está na página da Tricents
    Quando seleciona os itens de forma correta
    E preenche os campos de forma correta
    E clica no botão next
    Então deve ir para a aba inserir os dados do seguro
    Quando seleciona os itens pessoais de forma correta
    E preenche os campos pessoais de forma correta
    E clica no botão next da página
    Então deve ir para a aba inserir os dados do produto
    Quando seleciona os itens do produto de forma correta
    E preenche os campos do produto de forma correta
    E clica no botão next da página produto
    Então deve ir para a aba selecionar opções de preço
    Quando deve selecionar a forma de pagamento
    E clica no botão next da página opção de preço
    Então deve ir para a aba enviar cotação
    Quando preenche os campos da página enviar cotação de forma correta
    E clica no botão send
    E deve receber a mensagem de confirmação "Sending e-mail success!"
    Então deve clicar no botão ok








