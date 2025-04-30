
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
- **Maven** para gerenciamento de dependências e automação de builds.

**Principais recursos:**
- Feedback visual com **FacesMessages**.
- Validação de campos e tratamento de erros.
- Exportação de dados para **Excel**.
- Pesquisa dinâmica e autocomplete.
- Layout moderno e responsivo com PrimeFaces.
- 📈 **Dashboard com gráficos dinâmicos (Pizza e Barras)** para visualização estatística.

---

## 🚀 Funcionalidades

- 📋 Cadastro, edição, exclusão e listagem de empresas.
- 🏢 Cadastro e gerenciamento de ramos de atividade.
- 📊 Visualização de empresas por tipo e por ramo de atividade com gráficos interativos.
- 🔍 Pesquisa dinâmica de registros.
- 📂 Exportação dos dados listados para **Excel**.
- ✅ Validação de dados com mensagens visuais.
- ⚙️ Tratamento de erros robusto e amigável.

---

## 🔧 Tecnologias utilizadas

| Camada            | Tecnologia                        |
|-------------------|------------------------------------|
| Backend           | Java, JSF, PrimeFaces, JPA, CDI   |
| Frontend          | XHTML, PrimeFaces                 |
| Banco de Dados    | PostgreSQL                        |
| Servidor          | Apache Tomcat                     |
| Build             | Maven                             |

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

5. Acesse a aplicação:
   ```
   http://localhost:8080/nome-do-projeto
   ```

### Estrutura do Projeto

```
📁 src/main/java
    ├── controller
    ├── model
    ├── repository
    ├── service
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
- [ ] 🔍 Filtros avançados de pesquisa
- [ ] 👥 Gestão de usuários e permissões
- [ ] 📄 Relatórios em PDF e outros formatos
- [ ] 🔗 Integração com APIs externas
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
