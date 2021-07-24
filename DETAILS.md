# Detalhes para utilização dos endpoints da API RESTful de Grafos

## 📗 Resumo

- 1️⃣ [**Salvar Grafo**](#1️⃣-Salvar-grafo)
    - `Endpoint: /graph`
- 2️⃣ [**Recuperar Grafo**](#2️⃣-Recuperar-grafo)
    - `Endpoint: /graph/<graphId>`
- 3️⃣ [**Encontrar todas rotas disponíveis dado um bairro de origem e outro de destino**](#3️⃣-Encontrar-todas-rotas-disponíveis-dado-um-bairro-de-origem-e-outro-de-destino)
    - `Endpoint: /routes/from/<town1>/to/<town2>?maxStops=<maxStops>`
- 4️⃣ [**Encontrar todas rotas disponíveis dado um bairro de origem e outro de destino em um grafo salvo anteriormente**](#4️⃣-Encontrar-todas-rotas-disponíveis-dado-um-bairro-de-origem-e-outro-de-destino-em-um-grafo-salvo-anteriormente)
    - `Endpoint: /routes/<graphId>/from/<town1>/to/<town2>?maxStops=<maxStops>`
- 5️⃣ [**Determinar distância de um caminho específico**](#5️⃣-Determinar-distância-de-um-caminho-específico)
    - `Endpoint: /distance`
- 6️⃣ [**Determinar distância de um caminho específico em um grafo salvo**](#6️⃣-Determinar-distância-de-um-caminho-específico-em-um-grafo-salvo)
    - `Endpoint: /distance/<graphId>`
- 7️⃣ [**Determinar distância mínima entre dois bairros**](#7️⃣-Determinar-distância-mínima-entre-dois-bairros)
    - `Endpoint: /distance/from/<town1>/to/<town2>`
- 8️⃣ [**Determinar distância mínima entre dois bairros em um grafo salvo**](#8️⃣-Determinar-distância-mínima-entre-dois-bairros-em-um-grafo-salvo)
    - `Endpoint: /distance/<graphId>/from/<town1>/to/<town2>`
    
---

## 1️⃣ Salvar Grafo
 
<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/graph</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Recebe arestas de um grafo e salva em um banco de dados para consultas posteriores.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>CREATED (201)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>

```yaml
{
  "data": [
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    },
    { 
      "source": "B", "target": "C", "distance":2
    },
    { 
      "source": "B", "target": "D", "distance":4
    },
    { 
      "source": "C", "target": "B", "distance":3
    },
    { 
      "source": "C", "target": "D", "distance":1
    },
    { 
      "source": "C", "target": "E", "distance":7
    },
    { 
      "source": "E",  "target": "B", "distance":5
    },
    { 
      "source": "E", "target": "D", "distance":7
    }
  ]
}
```

</td>
 
<td>

```yaml
{
  "id": 1,
  "data": [
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    },
    { 
      "source": "B", "target": "C", "distance":2
    },
    { 
      "source": "B", "target": "D", "distance":4
    },
    { 
      "source": "C", "target": "B", "distance":3
    },
    { 
      "source": "C", "target": "D", "distance":1
    },
    { 
      "source": "C", "target": "E", "distance":7
    },
    { 
      "source": "E",  "target": "B", "distance":5
    },
    { 
      "source": "E", "target": "D", "distance":7
    }
  ]
}
```

</td>
</tr> 
</table>

---
 
## 2️⃣ Recuperar Grafo

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/graph/&lt;graphId&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;graphId&gt; [int]</b>: id de um grafo existente.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>GET</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Retorna um grafo previamente salvo no banco de dados. Se o grafo não existe, é retornado HTTP NOT FOUND.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Error Response Code</h4></td>
        <td>NOT FOUND (404)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
`None`

</td>
 
<td>

```yaml
{
  "id": 1,
  "data": [
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    },
    { 
      "source": "B", "target": "C", "distance":2
    },
    { 
      "source": "B", "target": "D", "distance":4
    },
    { 
      "source": "C", "target": "B", "distance":3
    },
    { 
      "source": "C", "target": "D", "distance":1
    },
    { 
      "source": "C", "target": "E", "distance":7
    },
    { 
      "source": "E",  "target": "B", "distance":5
    },
    { 
      "source": "E", "target": "D", "distance":7
    }
  ]
}
```

</td>
</tr> 
</table> 

---
 
## 3️⃣ Encontrar todas rotas disponíveis dado um bairro de origem e outro de destino
         
<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/routes/from/&lt;town1&gt;/to/&lt;town2&gt;?maxStops=&lt;maxStops&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;town1&gt; [string A-Z]</b>: nome do bairro de origem.</li>
             <li><b>[required] &lt;town2&gt; [string A-Z]</b>: nome do bairro de destino.</li>
             <li><b>[optional] &lt;maxStops&gt; [int]</b>: quantidade máxima de paradas.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Calcula todas as rotas disponíveis de um bairro de origem para outro de destino, dado um número máximo de paradas. Se não existirem rotas possíveis, o resultado será uma lista vazia. Se o parâmetro "maxStops" não for definido, será listado todas as rotas possíveis.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
```yaml
{
  "data": [
    { 
      "source": "A", "target": "B", "distance":5
    },
    { 
      "source": "B", "target": "C", "distance":4
    },
    { 
      "source": "C", "target": "D", "distance":8
    },
    { 
      "source": "D", "target": "C", "distance":8
    },
    { 
      "source": "D", "target": "E", "distance":6
    },
    { 
      "source": "A", "target": "D", "distance":5
    },
    { 
      "source": "C", "target": "E", "distance":2
    },
    { 
      "source": "E", "target": "B", "distance":3
    },
    { 
      "source": "A", "target": "E", "distance":7
    }
  ]
}
```

</td>
 
<td>

```yaml
{
  "routes": [
    {
      "route": "ABC",
      "stops": 2
    },
    {
      "route": "ADC",
      "stops": 2
    },
    {
      "route": "AEBC",
      "stops": 3
    }
  ]
}
```

</td>
</tr> 
</table> 

---
 
## 4️⃣ Encontrar todas rotas disponíveis dado um bairro de origem e outro de destino em um grafo salvo anteriormente

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/routes/&lt;graphId&gt;/from/&lt;town1&gt;/to/&lt;town2&gt;?maxStops=&lt;maxStops&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;graphId&gt; [int]</b>: id de um grafo existente.</li>
             <li><b>[required] &lt;town1&gt; [string A-Z]</b>: nome do bairro de origem.</li>
             <li><b>[required] &lt;town2&gt; [string A-Z]</b>: nome do bairro de destino.</li>
             <li><b>[optional] &lt;maxStops&gt; [int]</b>: quantidade máxima de paradas.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Faz exatamente o mesmo que o anterior, porém utilizando um grafo salvo anteriormente. Se o grafo não existir, é retornado HTTP NOT FOUND.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Error Response Code</h4></td>
        <td>NOT FOUND (404)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
`None`

</td>
 
<td>

```yaml
{
  "routes": [
    {
      "route": "ABC",
      "stops": 2
    },
    {
      "route": "ADC",
      "stops": 2
    },
    {
      "route": "AEBC",
      "stops": 3
    }
  ]
}
```

</td>
</tr> 
</table> 

---
 
## 5️⃣ Determinar distância de um caminho específico

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/distance</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Retorna a distância total de um caminho entre uma lista direcionada e específica de bairros. Caso a lista de bairros esteja vazia ou seja unitária, o resultado será 0. Se o dado caminho não existir, então será retornado -1.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
```yaml
{
  "path": ["A", "B", "C", "D"],
  "data": [
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    },
    { 
      "source": "B", "target": "C", "distance":2
    },
    { 
      "source": "B", "target": "D", "distance":4
    },
    { 
      "source": "C", "target": "B", "distance":3
    },
    { 
      "source": "C", "target": "D", "distance":1
    },
    { 
      "source": "C", "target": "E", "distance":7
    },
    { 
      "source": "E",  "target": "B", "distance":5
    },
    { 
      "source": "E", "target": "D", "distance":7
    }
  ]
}
```

</td>
 
<td>

```yaml
{
  "distance": 9
}
```

</td>
</tr> 
</table>         

---
      
## 6️⃣ Determinar distância de um caminho específico em um grafo salvo

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/distance/&lt;graphId&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;graphId&gt; [int]</b>: id de um grafo existente.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Faz exatamente o mesmo que o anterior, porém utilizando um grafo salvo anteriormente. Se o grafo não existir, é retornado HTTP NOT FOUND.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Error Response Code</h4></td>
        <td>NOT FOUND (404)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
```yaml
{
 "path": ["A", "B", "C", "D"]
}
```

</td>
 
<td>

```yaml
{
  "distance": 9
}
```

</td>
</tr> 
</table>

---
 
## 7️⃣ Determinar distância mínima entre dois bairros

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/distance/from/&lt;town1&gt;/to/&lt;town2&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;town1&gt; [string A-Z]</b>: nome do bairro de origem.</li>
             <li><b>[required] &lt;town2&gt; [string A-Z]</b>: nome do bairro de destino.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Determina a rota cuja distância seja a mínima possível entre dois bairros. Se os bairros de origem e destino forem iguais, o resultado será 0. Se não existir rota possível entre os dois bairros, então o resultado será -1.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
```yaml
{
  "data": [
    { 
      "source": "A", "target": "B", "distance":6
    },
    { 
      "source": "A", "target": "E", "distance":4
    },
    { 
      "source": "B", "target": "A", "distance":6
    },
    { 
      "source": "B", "target": "C", "distance":2
    },
    { 
      "source": "B", "target": "D", "distance":4
    },
    { 
      "source": "C", "target": "B", "distance":3
    },
    { 
      "source": "C", "target": "D", "distance":1
    },
    { 
      "source": "C", "target": "E", "distance":7
    },
    { 
      "source": "E",  "target": "B", "distance":5
    },
    { 
      "source": "E", "target": "D", "distance":7
    }
  ]
}
```

</td>
 
<td>

```yaml
{
 "distance": 8,
 "path": ["A", "B", "C"]
}
```

</td>
</tr> 
</table>

---
        
## 8️⃣ Determinar distância mínima entre dois bairros em um grafo salvo

<table>
    <tr>
        <td align="center"><h4>Endpoint</h4</td>
        <td>/distance/&lt;graphId&gt;/from/&lt;town1&gt;/to/&lt;town2&gt;</td>
    </tr>
    <tr>
        <td align="center"><h4>Params</h4</td>
        <td>
            <ul>
             <li><b>[required] &lt;graphId&gt; [int]</b>: id de um grafo existente.</li>
             <li><b>[required] &lt;town1&gt; [string A-Z]</b>: nome do bairro de origem.</li>
             <li><b>[required] &lt;town2&gt; [string A-Z]</b>: nome do bairro de destino.</li>
            </ul>
         </td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Method</h4></td>
        <td>POST</td>
    </tr>
    <tr>
        <td align="center"><h4>Descrição</h4></td>
        <td>Faz exatamente o mesmo que o anterior, porém utilizando um grafo salvo anteriormente. Se o grafo não existir, é retornado HTTP NOT FOUND.</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Success Response Code</h4></td>
        <td>OK (200)</td>
    </tr>
    <tr>
        <td align="center"><h4>HTTP Error Response Code</h4></td>
        <td>NOT FOUND (404)</td>
    </tr>
     <tr>
        <td align="center"><h4>Contract: Request payload</h4></td>
        <td align="center"><h4>Contract: Response payload</h4></td>
     </tr>
         
<tr>

<td>
 
`None`

</td>
 
<td>

```yaml
{
 "distance": 8,
 "path": ["A", "B", "C"]
}
```

</td>
</tr> 
</table>
