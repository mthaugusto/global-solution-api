<html>
<body>
    <h2>Global Solution - Glow AI</h2>
    <p>API de gerenciamento do banco de dados da aplica��o de classifica��o de doen�as de pele.</p>
    <a href="webapi/clientes/">Clientes resource</a> - <a href="webapi/doencas">Doen�as resource</a> - <a href="webapi/causas">Causas resource</a> - <a href="webapi/sintomas">Sintomas resource</a> - <a href="webapi/tratamentos">Tratamentos resource</a> - <a href="webapi/predicoes">Predi��es resource</a> - <a href="webapi/imagens">Imagens resource</a>

    
    <h2>Documenta��o da API - Gerenciamento Glow AI</h2>
    <h3>Vis�o Geral</h3>
    <p>Esta API oferece opera��es de gerenciamento de clientes, doen�as e seus dados, permitindo a cria��o, recupera��o e atualiza��o de registros dos mesmos. � uma API RESTful que opera no banco de dados criado pela empresa Glow AI.</p>
	
	<h3>M�todos</h3>
	
	<h3>1. Listar Todos</h3>
		<p>M�todo: GET</p>
		<p>BASE URL: http://localhost:8080/global.solution/webapi
		<p>URL: /clientes | /doencas | /causas | /imagens | /predicoes | /sintomas | /tratamentos </p>
		<p>Descri��o: Obt�m uma lista completa dos dados cadastrados no banco de dados.</p>
		<p>Resposta de Sucesso: C�digo 200 (OK)</p>
		<p>Exemplo de Resposta:</p>
		<pre>
		    <p>
	[
	  {
	    "cep": "54321-876",
	    "cpf": "222.222.222-22",
	    "dataNascimento": "1985-05-15 00:00:00",
	    "descricaoAlergia": "P�len",
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
	
	<h3>2. Obter cliente, causas, doen�as, imagens, predi��es, sintomas ou tratamentos por id.</h3>
		<p>M�todo: GET</p>
		<p>URL: /clientes/{id} | /causas/{id} | /doencas/{id} | /imagens/{id} | /predicoes/{id} | /sintomas/{id} | /stratamentos{id}</p></p>
		<p>Descri��o: Obt�m os detalhes dos clientes, causas, doen�as, imagens, predi��es, sintomas ou tratamentos com base no id.</p>
		<p>Resposta de Sucesso: C�digo 200 (OK)</p>
		<p>Exemplo de Resposta:</p>
		<pre>
		    <p>
		    
		  {
		    "descricaoDoenca": "A candid�ase cut�nea � uma infec��o f�ngica causada por leveduras do g�nero Candida. Ela afeta a pele e pode causar sintomas como coceira, vermelhid�o e descama��o.",
		    "idDoenca": 1,
		    "nomeDoenca": "Candidiase Cut�nea"
		  }
		    </p>
		  </pre>
	
	<h3>3. Cadastrar um novo cliente.</h3>
		<p>M�todo: POST</p>
		<p>URL: /clientes/
		<p>Descri��o: Cadastrar com os detalhes fornecidos.</p>
		<p>Corpo da Requisi��o:</p>
		<pre>
			<p>
		{
		  "nomeCliente": "Jo�o da Silva",
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
		<p>Resposta de Sucesso: C�digo 201 (Created)</p>
	
	<h3>4. Atualizar um cliente.</h3>
		<p>M�todo: PUT</p>
		<p>URL: /clientes/
		<p>Descri��o: Atualiza com os detalhes fornecidos.</p>
		<p>Corpo da Requisi��o (campos a serem atualizados):</p>
		<pre>
		<p>
		{
		  "nomeCliente": "Jo�o da Silva",
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
		<p>Resposta de Sucesso: C�digo 200 (OK)</p>

</body>
</html>
