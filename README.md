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
- **CID (Context and Dependency Injection)** para uma melhor gestão de ciclos de vida e injeção de dependências.
- **PostgreSQL** como banco de dados relacional.
- **Apache Tomcat** como servidor de aplicação.
- **Maven** para gerenciamento de dependências e automação de builds.

> **Destaques:**
> - Feedback de operações com **FacesMessages**.
> - Validações de campos e tratamentos de erros integrados.
> - Exportação de dados para Excel.
> - Pesquisa dinâmica e autocomplete em campos relacionados.
> - Layout limpo e usabilidade fluída com PrimeFaces.

---

## 🚀 Funcionalidades

- 📋 Cadastro, edição, exclusão e listagem de empresas.
- 🏢 Cadastro e gerenciamento de ramos de atividade.
- 🔍 Pesquisa dinâmica de registros.
- 📂 Exportação dos dados listados para **Excel**.
- ✅ Validação de dados com feedback visual.
- ⚙️ Tratamento de erros robusto com mensagens amigáveis ao usuário.

---

## 🔧 Tecnologias

- **Backend:** Java, JSF, PrimeFaces, JPA, CDI
- **Frontend:** XHTML, PrimeFaces
- **Banco de Dados:** PostgreSQL
- **Servidor de Aplicação:** Apache Tomcat
- **Build e Dependências:** Maven

---

## 🛠️ Como executar o projeto

### Pré-requisitos

- Java 11 ou superior
- Maven 3.x
- PostgreSQL
- Apache Tomcat 9 ou superior

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
2. Configure o persistence.xml com suas credenciais do banco PostgreSQL.

3.Compile o projeto com Maven: 
```bash
mvn clean package

4.Faça o deploy do arquivo .war no Apache Tomcat.

5.Acesse no navegador:http://localhost:8080/nome-do-projeto


📁 src/main/java
    ├── Controller
    ├── model
    ├── repository
    ├── service
    └── util
📁 src/main/resources
    ├── META-INF
        └── persistence.xml
📁 src/main/webapp
    ├── WEB-INF
        ├── template
        └── faces-config.xml
    ├── pages
        ├── GestaoEmpresa.xhtml
        └── GestaoRamoAtividade.xhtml
📄 pom.xml

📈 Em Desenvolvimento / Futuras Implementações
🛠️ Dashboard com gráficos e KPIs

🔍 Filtros avançados de pesquisa

👥 Gestão de usuários e permissões

📄 Relatórios em PDF e outros formatos

🔗 Integração com APIs externas

📊 Melhorias de performance no carregamento de grandes volumes de dados

🌐 Responsividade e adaptação para mobile/tablet

🧑‍💻 Contribuições
Contribuições são muito bem-vindas! Fique à vontade para abrir issues ou enviar pull requests.

📜 Licença
Distribuído sob a licença MIT.

## 📫 Contato

- [![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?logo=linkedin&style=for-the-badge)](https://www.linkedin.com/in/enzo-brito-b85471284)
- [![Gmail](https://img.shields.io/badge/Email-Contact-red?logo=gmail&style=for-the-badge)](mailto:enzoj820@gmail.com)

Feito com ❤️ e muito café!
