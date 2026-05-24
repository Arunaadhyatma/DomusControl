# DomusControl

## Status do projeto

Em desenvolvimento.

## Tecnologias utilizadas

- Java
- Java Swing
- MySQL
- MySQL Workbench
- Apache NetBeans
- Maven
- Git e GitHub

## Time de desenvolvedores

- Gabriel Braz de Cadima

## Objetivo do software

O DomusControl é um sistema desktop para gerenciamento de dispositivos de automação residencial. O objetivo do software é permitir o cadastro, visualização e controle básico de dispositivos inteligentes associados a diferentes ambientes de uma residência.

## Funcionalidades do sistema

- Login de usuário com validação no banco de dados.
- Cadastro de novos usuários.
- Cadastro de dispositivos.
- Listagem de dispositivos cadastrados na Dashboard.
- Associação de dispositivos a ambientes.
- Visualização do estado dos dispositivos.
- Botões de ação para ligar e desligar dispositivos na interface.
- Integração com banco de dados MySQL.
- Interface gráfica desktop desenvolvida com Java Swing.

## Estrutura geral do projeto

O projeto utiliza uma organização em camadas:

- `view`: telas da aplicação.
- `view.components`: componentes visuais reutilizáveis.
- `view.theme`: configurações visuais e tema da aplicação.
- `model`: classes que representam os dados do sistema.
- `DAO`: classes responsáveis pelo acesso ao banco de dados.
- `database`: configuração de conexão com o banco de dados.

## Banco de dados

O sistema utiliza o banco `domuscontroldb`, contendo tabelas como:

- `usuario`
- `ambiente`
- `dispositivo`
- `rotina`
- `rotina_acao`
- `log_uso`

Para executar o sistema, é necessário configurar usuário e senha do MySQL na classe `ConnectionFactory`.

## Observações

Este projeto foi desenvolvido como parte do Projeto Integrador do curso de Desenvolvimento de Sistemas.
