
# Spring Security 3

Um projeto que visa colocar em prática os principais conceitos de autenticação e autorização com Spring Security.


## Stack utilizada

- Java
- Maven
- Spring Framework
- H2 Database
- Insomnia



## Estrutura de Pastas

```
/main 
    /src
        /controllers         # Controle das rotas HTTP
        /domain              # Responsável por modelar as entidades
        /infra               # Responsável por classes que auxiliam na infraestrutura como a securança e controle de execeções
        /repositories        # Responsável pelo acesso ao banco de dados
        /services            # Responsável pelo intermédio entre repository e controller
/resources                   # Responsável pelas propriedades da aplicação e recursos do banco

```
## Rodando localmente  🖥️

Para instalar o projeto, siga os passos abaixo:

### Pré-requisitos

- Java JDK (versão 21 ou superior)
- Maven (versão 3.9.7 ou superior)

### Passos

1. Clone o repositório:

   ```sh
   git clonehttps://github.com/Matheus-Nardi/spring-security3.git
   ```

2. Entre no diretório do repositório:

   ```sh
   cd spring-security3
   ```

3. Baixe as dependências:

   ```sh
   mvn clean install
   ```

4. Rode a aplicação localmente:

   ```sh
   mvn spring-boot:run   
   ```
## Demonstração

https://github.com/user-attachments/assets/4b7e0c3e-b07d-4c88-862c-60fecb3007bc


