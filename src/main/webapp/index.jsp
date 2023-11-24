<html>
<body>
    <h2>Global Solution - Glow AI</h2>
    <p>API de gerenciamento do banco de dados da aplicação de classificação de doenças de pele.</p>
    <a href="webapi/clientes/">Clientes resource</a> - <a href="webapi/doencas">Doenças resource</a> - <a href="webapi/causas">Causas resource</a> - <a href="webapi/sintomas">Sintomas resource</a> - <a href="webapi/tratamentos">Tratamentos resource</a> - <a href="webapi/predicoes">Predições resource</a> - <a href="webapi/imagens">Imagens resource</a>

    
    <h2>Documentação da API - Gerenciamento Glow AI</h2>
    <h3>Visão Geral</h3>
    <p>Esta API oferece operações de gerenciamento de clientes, doenças e seus dados, permitindo a criação, recuperação e atualização de registros dos mesmos. É uma API RESTful que opera no banco de dados criado pela empresa Glow AI.</p>
	
	<h3>Métodos</h3>
	
	<h3>1. Listar Todos</h3>
		<p>Método: GET</p>
		<p>BASE URL: http://localhost:8080/global.solution/webapi
		<p>URL: /clientes | /doencas | /causas | /imagens | /predicoes | /sintomas | /tratamentos </p>
		<p>Descrição: Obtém uma lista completa dos dados cadastrados no banco de dados.</p>
		<p>Resposta de Sucesso: Código 200 (OK)</p>
		<p>Exemplo de Resposta:</p>
		<pre>
		    <p>
	[
	  {
	    "cep": "54321-876",
	    "cpf": "222.222.222-22",
	    "dataNascimento": "1985-05-15 00:00:00",
	    "descricaoAlergia": "Pólen",
	    "descricaoMedicamentos": "Aspirina",
	    "emailCliente": "maria@email.com",
	    "generoCliente": "F",
	    "idCliente": 2,
	    "nomeCliente": "Maria Oliveira",
	    "numeroCelular": "888888888",
	    "possuiAlergia": "S",
	    "utilizaMedicamentos": "S"
	  },
            // Outros clientes...
     ]
		    </p>
		  </pre>
	
	<h3>2. Obter cliente, causas, doenças, imagens, predições, sintomas ou tratamentos por id.</h3>
		<p>Método: GET</p>
		<p>URL: /clientes/{id} | /causas/{id} | /doencas/{id} | /imagens/{id} | /predicoes/{id} | /sintomas/{id} | /stratamentos{id}</p></p>
		<p>Descrição: Obtém os detalhes dos clientes, causas, doenças, imagens, predições, sintomas ou tratamentos com base no id.</p>
		<p>Resposta de Sucesso: Código 200 (OK)</p>
		<p>Exemplo de Resposta:</p>
		<pre>
		    <p>
		    
		  {
		    "descricaoDoenca": "A candidíase cutânea é uma infecção fúngica causada por leveduras do gênero Candida. Ela afeta a pele e pode causar sintomas como coceira, vermelhidão e descamação.",
		    "idDoenca": 1,
		    "nomeDoenca": "Candidiase Cutânea"
		  }
		    </p>
		  </pre>
	
	<h3>3. Cadastrar um novo cliente.</h3>
		<p>Método: POST</p>
		<p>URL: /clientes/
		<p>Descrição: Cadastrar com os detalhes fornecidos.</p>
		<p>Corpo da Requisição:</p>
		<pre>
			<p>
		{
		  "nomeCliente": "João da Silva",
		  "emailCliente": "joao@example.com",
		  "cpf": "123.456.789-01",
		  "dataNascimento": "10/10/1990",
		  "generoCliente": "M",
		  "numeroCelular": "(11) 98765-4321",
		  "cep": "01234-567",
		  "possuiAlergia": "N",
		  "descricaoAlergia": null,
		  "utilizaMedicamentos": "S",
		  "descricaoMedicamentos": "Paracetamol"
		}
			</p>
		</pre>
		<p>Resposta de Sucesso: Código 201 (Created)</p>
	
	<h3>4. Atualizar um cliente.</h3>
		<p>Método: PUT</p>
		<p>URL: /clientes/
		<p>Descrição: Atualiza com os detalhes fornecidos.</p>
		<p>Corpo da Requisição (campos a serem atualizados):</p>
		<pre>
		<p>
		{
		  "nomeCliente": "João da Silva",
		  "emailCliente": "joao@example.com",
		  "cpf": "123.456.789-01",
		  "dataNascimento": "10/10/1990",
		  "generoCliente": "M",
		  "numeroCelular": "(11) 98765-4321",
		  "cep": "01234-567",
		  "possuiAlergia": "N",
		  "descricaoAlergia": null,
		  "utilizaMedicamentos": "N",
		  "descricaoMedicamentos": "null"
		}
		</p>
		</pre>
		<p>Resposta de Sucesso: Código 200 (OK)</p>

</body>
</html>
