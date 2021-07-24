# API RESTful de Grafos

#### Esta API possui como objetivo realizar algumas tarefas utilizando grafos. Ela foi desenvolvida para o processo seletivo na vaga de Analista Jr do [Banco Original](https://www.original.com.br/).

[![Author](https://img.shields.io/badge/author-souzavaltenis-AD1256?style=flat-square)](https://github.com/souzavaltenis)
[![Languages](https://img.shields.io/github/languages/count/souzavaltenis/banco-original-desafio-grafos?color=%23AD1256&style=flat-square)](#)
![GitHub stars](https://img.shields.io/github/stars/souzavaltenis/banco-original-desafio-grafos?style=flat-square)
![GitHub forks](https://img.shields.io/github/forks/souzavaltenis/banco-original-desafio-grafos?style=flat-square)

## 🔥 Tecnologias Utilizadas

- Java
- Spring Boot
- JPA
- Hibernate
- Banco de dados H2
- JUnit

## 🛠️ Funcionalidades 

- Salvar Grafo
- Recuperar Grafo
- Buscar todas rotas disponíveis dado um vértice de origem e outro de destino
- Determinar distância de um caminho específico
- Determinar a distância mínima entre dois vértices

## 🤔 Como Iniciar essa API ?

```
- Clone esse repositório:
$ git clone https://github.com/souzavaltenis/banco-original-desafio-grafos.git

- Entre no diretório:
$ cd banco-original-desafio-grafos

- Inicialize a API:
$ mvn spring-boot:run
```

## 📍 Endpoints

#### Todos endpoints disponíveis nesta API estão listados na tabela abaixo. 
#### Se desejar saber mais detalhes para utilização de cada endpoint, [clique aqui](/DETAILS.md). 
<br>

|            | Endpoint | Descrição |
|------------|----------|-----------|
| [**POST**] | /graph   | Recebe um grafo e salva no banco de dados. |
| [**GET**]  | /graph/\<graphId\> | Busca um grafo por id. |
| [**POST**] | /routes/from/\<town1\>/to/\<town2\>?maxStops=\<maxStops\> | Encontrar todos caminhos entre dois vértices, podendo definir as paradas máximas. |
| [**POST**] | /routes/\<graphId\>/from/\<town1\>/to/\<town2\>?maxStops=\<maxStops\> | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |
| [**POST**] | /distance | Retorna a distância total de um caminho pré-definido entre dois vértices. |
| [**POST**] | /distance/\<graphId\> | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |
| [**POST**] | /distance/from/\<town1\>/to/\<town2\> | Calcula o caminho com menor distância entre dois vértices. |
| [**POST**] | /distance/\<graphId\>/from/\<town1\>/to/\<town2\> | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |

---

#### Codificado com :heart: por [Valtenis Souza](https://github.com/souzavaltenis) 🚀
