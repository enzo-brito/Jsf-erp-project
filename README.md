
# 📊 Cadastro de Empresas

[![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow.svg)]()  
[![License](https://img.shields.io/badge/license-MIT-blue.svg)]()  
[![Java](https://img.shields.io/badge/Java-8+-red.svg)]()  
[![JSF](https://img.shields.io/badge/JSF-PrimeFaces-blueviolet.svg)]()  
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-blue.svg)]()  
[![Maven](https://img.shields.io/badge/Maven-Dependências%20gerenciadas-orange.svg)]()

> **Cadastro de Empresas** é uma aplicação web focada no gerenciamento de empresas e seus ramos de atividade. O sistema é robusto, seguro e pronto para expansão com novas funcionalidades 🚀.

---

## 📚 Sobre o projeto

Este projeto foi desenvolvido utilizando:

- **Java Server Faces (JSF)** com **PrimeFaces** para criação de componentes ricos e responsivos.
- **JPA (Java Persistence API)** para o gerenciamento de entidades e persistência de dados.
- **CDI (Context and Dependency Injection)** para gestão de ciclos de vida e injeção de dependências.
- **PostgreSQL** como banco de dados relacional.
- **Apache Tomcat** como servidor de aplicação.
- **Jersey (JAX-RS)** para implementação da API RESTful.
- **Maven** para gerenciamento de dependências e automação de builds.
- **JWT (JSON Web Token)** para autenticação segura dos usuários.

**Principais recursos:**
- Feedback visual com **FacesMessages**.
- Validação de campos e tratamento de erros.
- Exportação de dados para **Excel**.
- Pesquisa dinâmica e autocomplete.
- Layout moderno e responsivo com PrimeFaces.
- 📈 **Dashboard com gráficos dinâmicos (Pizza e Barras)** para visualização estatística.
- 🌐 **API RESTful com autenticação JWT** para integração com sistemas externos.

---

## 🚀 Funcionalidades

- 📋 Cadastro, edição, exclusão e listagem de empresas.
- 🏢 Cadastro e gerenciamento de ramos de atividade.
- 👥 Cadastro e autenticação de usuários com JWT.
- 📊 Visualização de empresas por tipo e por ramo de atividade com gráficos interativos.
- 🔍 Pesquisa dinâmica de registros.
- 📂 Exportação dos dados listados para **Excel**.
- ✅ Validação de dados com mensagens visuais.
- ⚙️ Tratamento de erros robusto e amigável.
- 🌐 Consumo e fornecimento de dados via API RESTful segura.

---

## 🌐 API RESTful

A aplicação fornece uma **API RESTful** construída com **Jersey (JAX-RS)** e protegida com **JWT**, permitindo integrações seguras e eficazes.

### 🔐 Autenticação com JWT

Antes de acessar os endpoints protegidos, é necessário autenticar-se e obter um token JWT.

#### 🔸 Cadastro de Usuário

- **POST** `/api/usuarios/registrar`  
- Exemplo de requisição:
```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "senhaHash": "123456"
}
```

#### 🔸 Login de Usuário

- **POST** `/api/usuarios/login`  
- Exemplo de requisição:
```json
{
  "usuario": "joao@email.com",
  "senha": "123456"
}
```

- Se autenticado com sucesso, um **token JWT** será retornado. Utilize-o no cabeçalho das requisições subsequentes:

```
Authorization: Bearer <seu_token_jwt>
```

---

### 🔗 Endpoints disponíveis

#### 📁 Empresas

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/api/empresas/` | Lista todas as empresas |
| GET    | `/api/empresas/{id}` | Retorna uma empresa específica pelo ID |
| GET    | `/api/empresas/pesquisar?nome=nome` | Pesquisa empresas por nome |
| POST   | `/api/empresas/` | Cria uma nova empresa |
| PUT    | `/api/empresas/{id}` | Atualiza uma empresa existente |
| DELETE | `/api/empresas/{id}` | Remove uma empresa pelo ID |
| GET    | `/api/empresas/total-por-tipo?tipo=tipo` | Retorna o total de empresas por tipo |
| GET    | `/api/empresas/total-por-ramo` | Retorna o total de empresas por ramo de atividade |

#### 🏭 Ramos de Atividade

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET    | `/api/ramoatividades` | Lista todos os ramos de atividade |
| GET    | `/api/ramoatividades/{id}` | Retorna um ramo de atividade pelo ID |
| GET    | `/api/ramoatividades/pesquisar?descricao=descricao` | Pesquisa ramos por descrição |
| POST   | `/api/ramoatividades/` | Cria um novo ramo de atividade |
| PUT    | `/api/ramoatividades/{id}` | Atualiza um ramo existente |
| DELETE | `/api/ramoatividades/{id}` | Remove um ramo de atividade |

> 🧪 A API pode ser testada via ferramentas como **Postman** ou **Insomnia**.
> 🔐 Todos os endpoints (exceto registro e login) requerem autenticação JWT.

---

## 🔧 Tecnologias utilizadas

| Camada            | Tecnologia                                  |
|-------------------|----------------------------------------------|
| Backend           | Java, JSF, PrimeFaces, JPA, CDI WELD, Jersey, JWT     |
| Frontend          | XHTML, PrimeFaces                           |
| Banco de Dados    | PostgreSQL                                  |
| Servidor          | Apache Tomcat                               |
| Build             | Maven                                       |

---

## 🛠️ Como executar o projeto

### Pré-requisitos

| Ferramenta     | Versão Recomendada |
|----------------|--------------------|
| Java           | 8+                 |
| Maven          | 2.x                |
| PostgreSQL     | 14+                |
| Apache Tomcat  | 9+                 |

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
   ```

2. Configure o `persistence.xml` com suas credenciais do banco PostgreSQL.

3. Compile o projeto com Maven:
   ```bash
   mvn clean package
   ```

4. Faça o deploy do arquivo `.war` no Apache Tomcat.

5. Acesse a aplicação web:
   ```
   http://localhost:8080/jsfProject
   ```

6. Teste a API (exemplo):
   ```
   GET http://localhost:8080/jsfProject/api/empresas/
   ```

---

### Estrutura do Projeto

```
📁 src/main/java
    ├── controller
    ├── model
    ├── repository
    ├── service
    ├── rest        ← Endpoints REST (JAX-RS)
    └── util
📁 src/main/resources
    └── META-INF
        └── persistence.xml
📁 src/main/webapp
    ├── WEB-INF
        ├── template
        └── faces-config.xml
    ├── pages
        ├── GestaoEmpresa.xhtml
        ├── GestaoRamoAtividade.xhtml
        └── Dashboard.xhtml
📄 pom.xml
```

---

## 📈 Em Desenvolvimento / Futuras Implementações

- [x] 📊 Dashboard com gráficos e KPIs
- [x] 🌐 API RESTful com Jersey e JAX-RS
- [x] 🔐 Autenticação com JWT
- [ ] 🔍 Filtros avançados de pesquisa
- [ ] 👥 Gestão de usuários e permissões
- [ ] 📄 Relatórios em PDF e outros formatos
- [ ] 📊 Otimizações de performance para grandes volumes de dados
- [ ] 🌐 Responsividade para dispositivos móveis/tablets

---

## 🧑‍💻 Contribuições

Contribuições são muito bem-vindas!  
Sinta-se à vontade para abrir uma [issue](https://github.com/enzo-brito/jsf-erp-project/issues) ou enviar um [pull request](https://github.com/enzo-brito/jsf-erp-project/pulls).

---

## 📜 Licença

Distribuído sob a licença **MIT**.  

---

## 📫 Contato

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?logo=linkedin&style=for-the-badge)](https://www.linkedin.com/in/enzo-brito-b85471284)  
[![Gmail](https://img.shields.io/badge/Email-Contact-red?logo=gmail&style=for-the-badge)](mailto:enzoj820@gmail.com)

---

Feito com ❤️ e muito café!

