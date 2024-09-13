# Teste Unitário e Mock para Horário de Atendimento dos Professores

Este repositório contém uma implementação de testes unitários e mocks para validar uma classe responsável por popular uma página web com informações sobre o horário de atendimento dos professores do INATEL. O horário de atendimento é retornado por um servidor remoto em formato JSON.

## Objetivo

O objetivo é testar a funcionalidade de uma classe que consome dados JSON para apresentar informações sobre os horários de atendimento dos professores. O teste deve cobrir cenários de sucesso e falha.

## Estrutura do Projeto

- **src/main/java/br/inatel/atendimento**: Contém a implementação das classes e interfaces relacionadas ao serviço de atendimento dos professores.
- **src/test/java/br/inatel/atendimento/test**: Contém os testes unitários e mocks para a classe que consome os dados JSON.

## Funcionalidades

1. **BuscaAtedimentoProfessor**: Classe que busca os horários de atendimento dos professores a partir de um JSON.
2. **MockAtendimentoService**: Serviço mock para simular a resposta do servidor remoto.
3. **TesteBuscaAtendimento**: Testes unitários para validar a funcionalidade da busca e o comportamento do serviço mock.

## Como Rodar os Testes
1. Clone o Repositório
```bash 
git clone https://github.com/ThomasCeccon/C214.git
````
2. Execute os testes:
```bash 
mvn test
````

## Dependências
- JUnit 4.13.2
- Mockito 4.4.0
- Gson 2.9.0

## Contribuindo
Se você deseja contribuir para este projeto, faça um fork, crie uma branch para suas alterações e envie um pull request.

## EQUIPE
- Gabriella Gonçalves Moreira-1744
- Thomas Ceccon Guimarães-1812
