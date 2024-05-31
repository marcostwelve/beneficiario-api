<h1 align="center"> Beneficiário Api </h1>

<p align="center">
   Uma aplicação utilizando Java e Spring Boot de uma API REST, onde manter cadastro de beneficiários de um plano de saúde, de acordo com o diagrama de classe abaixo:
</p>

## Diagrama de classe
![image](https://github.com/marcostwelve/springboot-plan-api/assets/94411600/49403c21-a3ca-49fc-96d2-6c1a9b4b8482)<br>

<p align="center">
  <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Desenvolvimento</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Instruções</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-projeto">Acessando o banco de dados H2 database</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#memo-licença">Licença</a>
</p>
<br>

## 🚀 Tecnologias

Esse projeto foi desenvolvido com as seguintes tecnologias:

- Java
- Spring Boot
- H2 Database
- Postman
- IntelliJ
- Swagger
- Git e Github
<br>

## 🧠 Desenvolvimento

O projeto foi desenvolvido, seguindo o diagrama de classe OneToMany, onde um beneficiário pode ter muitos documentos, e um documento um beneficiário.
O projeto foi desenvolvido em Spring Boot na versão 3 e Java na versão 17, sendo criado o projeto base no __Spring initializl__, com Maven Project como gerenciador de dependências.
A aplicação foi estudada e estruturada em pastas, seguindo a base de orientação a objetos e recursos do Java e Spring Boot.
Foram realizados testes em cada implementação de método no projeto, para validar todas as requisições REST solicitadas para a API.
Foi utilizado o H2 database, como banco de dados, para guardar dados, criar tabelas e relacionamento entre as tabelas.
Todos os beneficiários e documentos, estão com implementação para gerar ID´s automáticos, sem a precisão de inseri-los manualmente.
Utilizado o JPA, para Serealizar os dados em JSON para o banco de dados, e não haver inconsistência de dados ao enviar ao banco de dados.
Os nome das classes estão em ingês sendo benefiary para beneficiário e document para documento.
Para realizar os end points da aplicação, foi utilizado o Postman.

## ⚙️ Instruções


Para verificar se o projeto está funcionando corretamente, abra o arquivo no IntelliJ, ou em outra IDE digite no campo de link do nagevador ou no Postman `http://localhost:8080`

### Requisições HTTP

Código  | Descrição
--- | ------
200 | OK
400 | Bad Request - Requisição Inválida
404 | Not Found - Não encontrado
500 | Internal Server Error - Erro interno do servidor

#### Método GET
Método GET `http://localhost:8080/beneficiario`
Esta requisição irá retornar e listar dados de todos os beneficiários cadastrados no banco de dados

![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/7760e42f-7140-4737-a452-611ddbffb9dc) <br>
Ao enviar a requisição para o banco de dados, ele retornou todos os usuários cadastrado no sistema
<br>

Método GET `http://localhost:8080/beneficiario/{id}`
Esta requisição retorna um beneficiário a partir do seu id passado por parâmetro
<br>
Ao enviar a requisição para o banco de dados, ele retornou o usuário cadastrado com o id 2 no sistema
<br>

#### Método POST
Método POST `http://localhost:8080/beneficiario`
Esta requisição irá cadastrar um novo beneficiário com seus documentos


##### Exemplo de código
```
{
	"nome": "Suzana Santos",
	"telefone": "(11)9999-9999",
	"dataNascimento": "2000-10-15"
}
```
Obs: Não é necessário incluir o campo de documento

Ao enviar a requisição para o banco de dados, ele enviou os dados que foram cadastrado no body.

Ao listar os beneficiarios;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/0d450392-34e8-4f82-a715-6d601b1c9e8f)<br>

Listar os documentos do beneficiários;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/ee3c40be-c465-4031-ba28-06bb918ffa21)
<br>

#### Método PUT
Método PUT `http://localhost:8080/beneficiario/{id}`
Esta requisição irá atualizar dados de um beneficiário, através do id passado por parâmetro

##### Exemplo de código
```
     {
        "nome": "Maria Brown da Silva",
        "telefone": "11999999999",
        "dataNascimento": "2000-10-05",
        "dataAtualizacao": "2022-02-22"
    }
```

Atualizando os dados;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/64cf0052-3a77-49a3-ac91-40c290ca740e)

<br>

#### Método Delete
Método Delete `http://localhost:8080/beneficiario/{id}`
Esta requisição irá retornar um beneficiário do sistema de cadastro, passando seu id como parâmetro

Excluindo o beneficiário com o ID 5 
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/3aeb6f33-f91a-4548-89af-7c428f2ccbca) <br>

Listando todos os usuários;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/470380fe-f89e-4bd5-980c-643240bfd3d4)
<br>

Buscando o usuário com o ID 5;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/2546dfee-2f83-4f8d-933e-5bdc0611a08e)
<br>

#### Documentos


Método GET `http://localhost:8080/beneficiario/beneficiarioId/documento`
Esta requisição retorna todos os documentos de um beneficiários a partir do seu id passado por parâmetro
 ![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/bae2850b-17cc-4b45-92d4-c0602f7982e4) <br>
Ao enviar a requisição para o banco de dados, ele retornou todos os documentos do usuário cadastrado com o id 1 no sistema
<br>

Método GET `http://localhost:8080/beneficiario/beneficiarioId/documento/{id}`
Esta requisição retorna um documento de um beneficiário a partir do seu id passado por parâmetro
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/cc42a5e7-a5ab-48d3-8d01-f4ef66405693)
<br>

Ao enviar a requisição para o banco de dados, ele retornou  o documento de ID 5 do usuário cadastrado com o id 1 no sistema
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/095ea45b-dea0-4b49-8e4f-79f8d9960a8e)
<br>

Método Post `http://localhost:8080/beneficiario/beneficiarioId/documento`
Esta requisição cadastra um documento para um beneficiário a partir do seu id passado por parâmetro

##### Exemplo de código
```
  {
    "tipoDocumento": "RG",
    "descricao": "55.555.555.8"
 }
```
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/c9c361cb-8ede-4068-bbce-39200f825993)
<br>
Ao enviar a requisição para o banco de dados, ele retornou todos os documentos do usuário cadastrado com o id 1 no sistema
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/21270037-a454-4c9a-9a0b-53781a0925fa)
<br>

Podemos cadastrar mais documentos para o usuário
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/556acf03-16eb-46c3-90d3-e898ca5bd66c)
<br>

Método Post `http://localhost:8080/beneficiario/beneficiarioId/documento/1`
Esta requisição atualiza um documento para um beneficiário a partir do seu id passado por parâmetro

##### Exemplo de código
```
  {
    "tipoDocumento": "RG",
    "descricao": "55.555.555.8",
    "dataAtualizacao": "2024-03-12
 }
```

![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/cf32c9ab-959b-4a62-bfb1-50c484cfd2f3)
<br>
Ao listar documentos, o documento de ID 6 foi atualizado, para o beneficiário de ID 1
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/97e46ac1-cd70-43da-9d1f-0eaaa544ff13) 
<br>

#### Método Delete
Método Delete `http://localhost:8080/beneficiario/beneficiarioId/documento/{id}`
Esta requisição irá deletar um documento para o beneficiario, com o id definido

Excluindo o documento com o ID 6
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/eb699b63-af4b-4671-a0f1-17da95f28e33)
<br>

Listando todos os documentos;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/120675ae-712a-4bde-bdd8-d44648b55477)
<br>

Buscando o usuário com o ID 6;
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/fe492e79-13db-4eba-b1f6-026fb038022f)
<br>

## Swagger

A API, está documantada no Swagger. Caso queria utilizar para testes, pode acessar o link [Swagger](http://localhost:8080/swagger-ui/index.html#/Benefici%C3%A1rios/listarBeneficiarios)
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/f9c54d9a-1e0d-47bc-baf0-1a4fe4477305)
<br>

## Acessando o banco de dados H2 database

Para acessar o banco de dados H2, digite na aba de link do navegador: `http://localhost:8080/h2`
Irá aparecer uma tela como esta:

![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/2c07b4c0-2437-48be-a587-65c3ab3f98d6) <br>

Os dados de usuários, são padrões do H2, e estão no arquivo `application.properties`
Não é necessário alterar dados, somente clicar em conect

Há as duas tabelas criadas pelo o H2, __BENEFICIARIO__ e __DOCUMENTO__
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/8db9b8ee-9f8b-441c-955e-20bc1132006b)<br>

Para executar comandos SQL, basta clicar em uma tabela e depois clicar em Run
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/01761c72-b253-4c3f-8962-4aae30348496)
<br>

Para executar a outra tabela, basta clicar em clear e clicar em uma tabela e depois clicar em Run
![image](https://github.com/marcostwelve/beneficiario-api/assets/94411600/5c21dd4f-2bc0-47d7-968e-e45f4386eb0e)

<br>


## :memo: Licença

Esse projeto está sob a licença MIT.

---
