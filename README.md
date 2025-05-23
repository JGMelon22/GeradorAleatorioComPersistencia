# Atividade Individual Avaliativa 2 - POO-III

O seguinte repositório contem o código fonte referente a atividade " Criação de aplicativo Web usando interface JSF e modelos de arquitetura MVC, com integração dos recursos das bibliotecas JPA". <br/>

### 📝 Proposta da atividade

> Em um aplicativo Web com persistência de dados, é preciso criar páginas para permitir a interação com os usuários, como a entrada de dados para posterior tratamento pela aplicação. Também é necessária a integração com as funcionalidades da biblioteca Java Persistent API – JPA para armazenamento das informações no banco de dados e implementação do tratamento de exceções de forma adequada.
> 
> No desenvolvimento de aplicações Web, a interação com o usuário é feita por meio das páginas JSF usando o padrão de arquitetura MVC. Por outro lado, as aplicações Web também precisam de funcionalidades de persistência dos dados realizada pela integração com a interface JPA. Dessa forma, torna-se necessário configurar e integrar os recursos de ambas as ferramentas, além da implementação do tratamento de exceções de forma adequada. 
> 
> Crie um aplicativo Web para a geração de um número aleatório pelo usuário utilizando o padrão MVC pela tecnologia JSF e a integração com a biblioteca JPA.
> 
> Procedimentos para elaboração:
> 
> Para a elaboração do trabalho, você deverá utilizar fonte Arial com tamanho 12 e páginas formato A4. Considere as normas ABNT. 
> 
> 1º passo: descreva de forma detalhada as características do modelo de arquitetura MVC, relacionando pelo menos duas vantagens de utilizar esse modelo (mínimo de 10 linhas). 
> 
> 2º passo: descreva a configuração das unidades de persistência no arquivo “persistence.xml”.  
> 
> 3º passo: descreva o mapeamento objeto-relacional das entidades, no qual as classes da aplicação são estruturadas para tabelas do banco de dados pela anotação “@Entity”.  
> 
> 4º passo: descreva os métodos para a inicialização e a finalização das unidades de persistência usando a interface javax.servlet.Filter.  
> 
> 5º passo: descreva os métodos para a abertura e a confirmação das transações da aplicação usando a interface javax.servlet.Filter. Implemente o tratamento de exceções.  
> 
> 6º passo: crie um objeto “Managed Bean” para gerar um número randômico entre zero e um valor numérico inserido pelo usuário usando o método “Random” da biblioteca “Math”. Ao final, guarde o valor em uma propriedade do “Managed Bean”. 
> 
> 7º passo: crie uma página XHTML de entrada de dados pelo usuário.  
> 
> 8º passo: crie uma página XHTML de resposta para exibir o número aleatório gerado.

## 🧰 Tecnologias utilizadas

- OpenJDK 8 <br/>
- JSF
- Jakarta EE 8
- Maven <br/>
- Netbeans <br/>
- MySQL <br/>

## 🧩 Dependências 

- javax.faces (org.glassfish:javax.faces:2.3.9)
- javaee-api (javax:javaee-api:8.0)
- Hibernate (org.hibernate:hibernate-core:5.3.37.Final)
- MySQL Connector/J (com.mysql:mysql-connector-j:8.3.0)

## 🚧 Como executar?

1. Clone o projeto
2. Restaure as dependências Maven (manualmente ou através da interface gráfica do Netbeans)
3. Inicie o servidor do banco de dados MySQL e execute o script disponível no diretório `/SQL`
4. Ajuste a string de conexão no `persistence.xml` de acordo com as credenciais e rota de seu SGBD
5. Execute o projeto