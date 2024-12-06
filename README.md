# Document Counter

## Descrição

Este é um sistema web desenvolvido em Java com Spring Boot que permite o upload de documentos (PDF, Word), contabiliza o número de páginas e retorna um valor estimado ao usuário com base na quantidade de páginas.

## Funcionalidades

- Upload de arquivos PDF e Word.
- Contagem automática de páginas dos documentos.
- Cálculo e retorno de valores com base na contagem de páginas.
- Tratamento de erros e validação de formatos de arquivo suportados.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Framework:** Spring Boot
- **Dependências:**
  - Apache POI (para manipulação de documentos Word)
  - PDFBox (para manipulação de arquivos PDF)
  - Spring Web
  - Spring DevTools (para facilitar o desenvolvimento)

## Como Executar o Projeto

### Requisitos

- Java 17 ou superior.
- Maven 3.8 ou superior.

### Passos para Execução

1. Clone este repositório:

   ```bash
   git clone 'https://github.com/ELIEZERBITTENCOURT/documentCounter.git'
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd documentCounter
   ```

3. Compile o projeto:

   ```bash
   mvn clean install
   ```

4. Inicie a aplicação:

   ```bash
   mvn spring-boot:run
   ```

5. Acesse a aplicação no navegador:

   ```bash
   http://localhost:8080
   ```

## Endpoints da API

### Upload de Arquivo

- **URL:** `/api/documents/upload`
- **Método:** POST
- **Headers:**
  - `Content-Type: multipart/form-data`
- **Corpo da Requisição:** Arquivo em formato PDF ou Word.
- **Exemplo de Resposta:**

  ```json
  {
    "filename": "documento.pdf",
    "pages": 66,
    "cost": 6.6000000000000005
  }
  ```

## Estrutura do Projeto

```code
src/
|-- main/
|   |-- java/
|   |   |-- com.example.documentCounter/
|   |       |-- controller/    # Controladores REST
|   |       |-- model/         # Modelos de dados
|   |       |-- service/       # Regras de negócio
|   |       |-- DocumentCounterApplication.java
|   |-- resources/
|       |-- application.properties # Configurações da aplicação
|-- test/ # Testes unitários e de integração
```

## Configurações

### application.properties

```properties
# Configurações do servidor
server.port=8080
spring.application.name=DocumentCounter
spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB

```

## Melhorias Futuras

- Adição de suporte a mais formatos de arquivos (e.g., Excel, PowerPoint).
- Integração com serviços de armazenamento em nuvem (AWS S3, Google Drive).
- Implementação de autenticação e autorização.
- Interface do usuário para interação com a aplicação.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
