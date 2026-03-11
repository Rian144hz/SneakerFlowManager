# 👟 SneakerFlow Manager

O **SneakerFlow Manager** é um sistema de gerenciamento de estoque de calçados desenvolvido em Java como parte dos estudos no Instituto Federal. O projeto utiliza o padrão **DAO (Data Access Object)** para persistência de dados em um banco de dados MySQL, permitindo que as informações dos sneakers sejam salvas e recuperadas permanentemente entre as execuções.

## 🚀 Funcionalidades
* **Sincronização Automática**: Ao iniciar, o sistema carrega todos os dados salvos no MySQL para o estoque local.
* **Cadastro (CRUD)**: Registro de novos sneakers com modelo, marca, tamanho e preço.
* **Persistência**: Uso de `PreparedStatement` para garantir a segurança (contra SQL Injection) ao salvar dados no banco.
* **Listagem**: Visualização detalhada de todos os itens cadastrados no estoque.
* **Busca**: Localização de sneakers específicos filtrando pela marca.
* **Remoção**: Exclusão de modelos tanto da lista em memória quanto do banco de dados.
* **Cálculo de Valor**: Soma do valor total de todos os itens atualmente no estoque.

## 🛠️ Tecnologias Utilizadas
* **Linguagem**: Java.
* **Banco de Dados**: MySQL.
* **Sistema Operacional**: Linux Ubuntu.
* **IDE**: IntelliJ IDEA.
* **Driver JDBC**: MySQL Connector/J.

## 📂 Estrutura de Pacotes
O projeto segue uma arquitetura organizada para facilitar a manutenção:
* `application`: Classes com o método `main` e fluxo de interface com o usuário.
* `entities`: Modelos de dados (`Sneaker`), lógica de estoque (`stock`) e acesso a dados (`SneakerDAO`).
* `database`: Configuração e fábrica de conexões com o banco de dados (`ConnectionFactory`).



## 🔧 Como Rodar o Projeto

### 1. Configurar o Banco de Dados
No seu terminal MySQL ou DBeaver, execute:
```sql
CREATE DATABASE db_sneakers;
USE db_sneakers;

CREATE TABLE sneakers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(100),
    mark VARCHAR(100),
    size INT,
    price DOUBLE
);
