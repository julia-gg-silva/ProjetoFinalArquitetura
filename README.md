# Sistema de Manutenção Industrial - Almoxarifado

## Contexto
Na **WEG**, o setor de manutenção industrial precisa de um sistema confiável para controlar o **almoxarifado** da fábrica.  
Atualmente, a gestão de materiais, fornecedores e requisições é feita manualmente ou em planilhas, o que gera problemas como:
- Falhas no controle de estoque
- Atrasos no atendimento de requisições
- Falta de rastreabilidade de entradas e saídas  

Para resolver isso, será desenvolvido um **protótipo funcional em Java com JPA**, estruturado em camadas, que permita gerenciar fornecedores, materiais, notas de entrada e requisições.  
Esse protótipo será a base para futuros sistemas corporativos mais robustos, podendo futuramente se integrar a sensores de estoque automatizados e sistemas ERP.  

---

## ⚙️ Funcionalidades Mínimas
- **Separação de responsabilidades**: camadas Model, Repository, Service e Controller
- **Persistência de dados com JPA** (MySQL)  
- **Padrões de projeto**: Factory Method, Observer, Adapter
- **Controle de estoque** integrado às entradas e requisições

---

##  Funcionalidades do Sistema

### 1️ Cadastro de Fornecedores
- Dados: **nome, CNPJ**  
- Regras:  
  - CNPJ único (não duplicado)  
  - Nome e CNPJ obrigatórios  
- Apenas administradores podem cadastrar fornecedores (em futuras versões com controle de usuários).  

---

### 2️ Cadastro de Materiais
- Dados: **nome, unidade de medida (kg, m, peça), quantidade inicial em estoque**  
- Regras:  
  - Nome único por material  
  - Quantidade inicial ≥ 0  
- Estoque atualizado automaticamente a partir das notas de entrada e requisições.  

---

### 3️ Registro de Notas de Entrada
- Associa **fornecedor, data de entrada e materiais comprados**  
- Cada material recebe uma quantidade que será adicionada ao estoque  
- Validações:  
  - Fornecedor deve existir no cadastro  
  - Quantidade ≥ 0  
- Efeito: **estoque atualizado automaticamente**  

---

### 4️ Criação de Requisição de Material
- Dados: **setor solicitante, data, lista de materiais e quantidades**  
- Regras:  
  - Quantidade solicitada ≤ estoque disponível  
  - Status inicial: **PENDENTE**  
- Associa materiais e quantidades à requisição.  

---

### 5️ Atendimento de Requisições
- Apenas requisições com status **PENDENTE** podem ser atendidas  
- Validações:  
  - Conferir se há estoque suficiente  
- Efeitos:  
  - Estoque reduzido  
  - Status atualizado para **ATENDIDA**  
  - Se não houver estoque → erro e status mantido **PENDENTE** 

---

## Tecnologias Utilizadas
- Java  
- JPA
- SPRING BOOT
- MySQL  
- Padrão MVC

---

# Como rodar o sistema

Este guia explica como rodar o sistema localmente em sua máquina para desenvolvimento e testes.

## Requisitos Mínimos

Antes de começar, você precisará instalar os seguintes softwares:

- [Postman](https://www.postman.com/downloads/) - Para testar os endpoints da API.
- [Banco de Dados](https://www.mysql.com/downloads/) - Este projeto utiliza MySQL. Você pode usar qualquer outro banco de dados, mas será necessário ajustar a configuração.
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework utilizado para o desenvolvimento da aplicação.
- [IDE](https://www.jetbrains.com/idea/download/) - Recomendamos o uso do IntelliJ IDEA ou Spring Tool Suite para melhor suporte ao Spring Boot.
- [Git](https://git-scm.com/) - Para clonar o repositório.

## Passo a Passo para Rodar o Projeto

### 1. Clonar o Repositório

Primeiro, clone o repositório do projeto em sua máquina local:

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

###2. Configurar o Banco de Dados

Certifique-se de que o MySQL ou o banco de dados de sua escolha esteja instalado e configurado corretamente. Para o MySQL, crie um banco de dados para o projeto com o nome almoxarifado:

```bash
CREATE DATABASE almoxarifado;
```

A seguir, configure as credenciais de banco de dados no arquivo application.properties (localizado em src/main/resources/application.properties):

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/almoxarifado
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

###3. Importar o Projeto na IDE

- Abra sua IDE (exemplo: IntelliJ IDEA ou Spring Tool Suite).
- Importe o projeto como um projeto Maven ou Gradle, dependendo da configuração do seu repositório.
- Aguarde a IDE baixar todas as dependências necessárias.


###4. Rodar a Aplicação

Para rodar o sistema:

- Na IDE, procure pela classe principal do Spring Boot, que normalmente está localizada em src/main/java/com/seu-pacote/NomeDaClasseApplication.java.
- Clique com o botão direito sobre a classe e escolha a opção "Run" ou "Executar".
- Alternativamente, se preferir rodar via terminal, execute o seguinte comando dentro da pasta raiz do projeto:

```bash
mvn spring-boot:run
```


###5. Testar os Endpoints com o Postman

Agora que o sistema está rodando, você pode testar os endpoints da API utilizando o Postman.

- Abra o Postman
- Crie uma nova coleção.
- Adicione os endpoints da sua API, definindo os métodos (GET, POST, PUT, DELETE) e o corpo da requisição conforme necessário.
- Certifique-se de que o servidor está em execução (geralmente na URL http://localhost:8081).
- Teste cada endpoint para garantir que está funcionando corretamente.

###6. Conclusão

Após seguir esses passos, seu ambiente de desenvolvimento estará pronto e você poderá fazer modificações, testar a API e desenvolver novas funcionalidades.

