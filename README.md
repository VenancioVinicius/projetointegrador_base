# Avaliação Prática OO - 3º Bimestre

## Problema

Você deve implementar um pequeno sistema em Java que permita a construção de uma lista de contatos. Um contato possui nome e telefone. Um contato não pode possuir um nome em branco e um contato não pode possuir um telefene em branco. Os dados dos contatos devem ser mostrados em uma tabela. 

Os dados devem serão armazenados localmente em um banco de dados relacional.

Você não precisa se preocupar com o banco de dados, pois ele será fornecido através do arquivo bd.sqlite. Existe uma rotina automática que verifica se o banco existe e está corretamente criado, que será executada toda vez que o sistema for iniciado ou que os testes automatizados forem executados.

A DDL do banco é a seguinte:

```sql
CREATE TABLE IF NOT EXISTS contatos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome varchar(255) NOT NULL,
    telefone varchar(255) NOT NULL)
```


## Desenvolvimento

Utilizando os conhecimentos que você assimilou durante as aulas, faça a implementação do sistema. Uma estrutura básica do sistema é fornecida, assim como um conjunto de testes automatizados. Todos os testes devem passar, para que a sua solução seja válida.

Dica 1: inicie o desenvolvimento pela persistência.

# OS ARQUIVOS DE TESTE NÃO PODEM SER ALTERADOS DE NENHUMA FORMA, A NÃO SER QUE SEJA EXPLICITAMENTE INDICADO PELO PROFESSOR!!

## Conceito

A - Todos os testes passam
B - Um teste não passa
C - Dois testes não passam
D - Três ou mais testes não passam# projetointegrador_base
