# API RESTful de Grafos

<h3>Esta API possui como objetivo realizar algumas tarefas utilizando grafos. Ela foi desenvolvida para o processo seletivo na vaga de Analista Jr do <a href="https://www.original.com.br/">Banco Original</a>.</h3>

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

|            | Endpoint | Descrição |
|------------|----------|-----------|
| [**POST**] | /graph   | Recebe um grafo e salva no banco de dados. |
| [**GET**]  | /graph/&lt;graphId&gt; | Busca um grafo por id. |
| [**POST**] | /routes/from/&lt;town1&gt;/to/&lt;town2&gt;?maxStops=&lt;maxStops&gt; | Encontrar todos caminhos entre dois vértices, podendo definir as paradas máximas. |
| [**POST**] | /routes/&lt;graphId&gt;/from/&lt;town1&gt;/to/&lt;town2&gt;?maxStops=&lt;maxStops&gt; | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |
| [**POST**] | /distance | Retorna a distância total de um caminho pré-definido entre dois vértices. |
| [**POST**] | /distance/&lt;graphId&gt; | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |
| [**POST**] | /distance/from/&lt;town1&gt;/to/&lt;town2&gt; | Calcula o caminho com menor distância entre dois vértices. |
| [**POST**] | /distance/&lt;graphId&gt;/from/&lt;town1&gt;/to/&lt;town2&gt; | Mesma funcionalidade do anterior, porém será calculado baseado em um grafo salvo. |

## ✏ Exemplo de Requisição

<h4> O exemplo abaixo realiza uma requisição GET para realizar uma busca por um grafo que possua o Id 1.</h4>

|| Endpoint |
|-------------|----------|
| [**GET**] | http://localhost:8080/graph/1|

- **Resposta:**
```yaml
{
  "id": 1,
  "data": [
    {
      "source": "A",
      "target": "B",
      "distance": 6
    },
    {
      "source": "A",
      "target": "E",
      "distance": 4
    },
    {
      "source": "B",
      "target": "A",
      "distance": 6
    },
    {
      "source": "B",
      "target": "C",
      "distance": 2
    },
    {
      "source": "B",
      "target": "D",
      "distance": 4
    },
    {
      "source": "C",
      "target": "B",
      "distance": 3
    },
    {
      "source": "C",
      "target": "D",
      "distance": 1
    },
    {
      "source": "C",
      "target": "E",
      "distance": 7
    },
    {
      "source": "E",
      "target": "B",
      "distance": 5
    },
    {
      "source": "E",
      "target": "D",
      "distance": 7
    }
  ]
}
```

---

### Codificado com :heart: por [Valtenis Souza](https://github.com/souzavaltenis) 🚀
