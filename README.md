# candidaturas-isel
Aplicacao Java em consola para simular candidaturas a cursos do ISEL.
# Sistema de Candidaturas ao ISEL

## Descrição
Este projeto consiste numa aplicação em Java, executada em consola, que simula de forma simples o processo de candidatura de estudantes a cursos do ISEL.

A aplicação permite:
- adicionar cursos
- adicionar candidatos
- registar candidaturas
- listar cursos, candidatos e candidaturas
- atribuir vagas
- mostrar candidatos admitidos
- pesquisar candidatos
- guardar e carregar dados em ficheiro

## Objetivo
O objetivo deste trabalho é aplicar os conceitos de programação orientada a objetos em Java, utilizando classes, herança, métodos, arrays, ficheiros e organização modular do código.

## Estrutura do projeto
O projeto está organizado nas seguintes classes:
- `Pessoa`
- `Candidato`
- `Curso`
- `Candidatura`
- `GestorCandidaturas`
- `FicheiroDados`
- `Main`

## Funcionalidades principais
1. Registo de cursos
2. Registo de candidatos
3. Registo de candidaturas
4. Listagem de dados
5. Atribuição de vagas com base na nota e nas vagas disponíveis
6. Pesquisa de candidatos
7. Persistência de dados em ficheiro

## Regras utilizadas
- A nota de acesso está na escala de 0 a 20
- O email do candidato deve ter um formato simples válido
- Um candidato só pode ser admitido se tiver nota igual ou superior à nota mínima do curso
- Um curso só admite candidatos enquanto tiver vagas disponíveis

## Utilização de IA
A Inteligência Artificial foi utilizada de forma ativa em praticamente toda a Parte D do projeto.

O apoio da IA incluiu:
- identificação dos requisitos principais
- proposta da arquitetura da aplicação
- divisão do projeto por classes
- criação da estrutura inicial do código
- implementação de métodos e funcionalidades do menu
- criação da lógica de candidaturas e atribuição de vagas
- apoio na leitura e escrita de ficheiros
- melhoria de validações, como email e nota de acesso
- geração de documentação do projeto
- criação de exemplos de teste

Após esse apoio, o código foi analisado, testado, adaptado e simplificado para garantir que a versão final correspondia aos requisitos do trabalho e era compreendida pelo autor
## Execução
A aplicação deve ser executada pela classe `Main`.
