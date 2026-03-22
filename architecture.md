# Arquitetura do Projeto

## Visão geral
A aplicação segue uma estrutura simples e modular, baseada em programação orientada a objetos.

O sistema foi dividido em classes que representam:
- entidades do domínio
- lógica principal da aplicação
- gestão de ficheiros
- interação com o utilizador

## Classes principais

### Pessoa
Classe base que representa uma pessoa com nome e email.

### Candidato
Herda de `Pessoa` e representa um candidato ao ISEL.
Tem:
- número de candidato
- nota de acesso

### Curso
Representa um curso disponível no sistema.
Tem:
- código
- nome
- vagas
- nota mínima

### Candidatura
Representa a candidatura de um candidato a um curso.
Tem:
- candidato
- curso
- estado

### GestorCandidaturas
É a classe principal da lógica da aplicação.
Responsabilidades:
- guardar candidatos, cursos e candidaturas
- adicionar dados
- listar dados
- procurar candidatos e cursos
- ordenar candidaturas por nota
- atribuir vagas
- mostrar admitidos

### FicheiroDados
Responsável por:
- guardar dados em ficheiro
- carregar dados de ficheiro

### Main
Responsável pela interação com o utilizador através de um menu em consola.

## Relações entre classes
- `Candidato` herda de `Pessoa`
- `Candidatura` associa um `Candidato` a um `Curso`
- `GestorCandidaturas` gere coleções de `Candidato`, `Curso` e `Candidatura`
- `Main` usa `GestorCandidaturas` e `FicheiroDados`

## Decisões de implementação
Foram usadas estruturas simples, como arrays e contadores, para manter o projeto fácil de compreender e adequado ao contexto académico.

Os estados das candidaturas foram representados por texto:
- Pendente
- Admitida
- Nao colocada

## Persistência
Os dados são guardados num ficheiro de texto chamado `dados.txt`, dividido em secções:
- CURSOS
- CANDIDATOS
- CANDIDATURAS
