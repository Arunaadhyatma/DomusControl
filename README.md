# DomusControl

Sistema desktop de automação residencial desenvolvido em Java, como Projeto Integrador do curso Técnico em Desenvolvimento de Sistemas (SENAC).

## Status do projeto

Em desenvolvimento. É um projeto acadêmico, criado durante meu aprendizado.

## Objetivo

Permitir o cadastro, a visualização e o controle básico de dispositivos inteligentes associados a diferentes ambientes de uma residência.

## Funcionalidades

- Login de usuário com validação no banco de dados.
- Cadastro de novos usuários.
- Cadastro de dispositivos (iluminação, segurança, climatização, sensor e tomada), associados a um ambiente.
- Listagem dos dispositivos na dashboard, associados aos seus ambientes.
- Ligar e desligar dispositivos pela interface (atualiza o estado no banco).

## Tecnologias

- Java (Swing) e Maven
- MySQL e JDBC
- Apache NetBeans (editor de interface) e Git/GitHub

## Estrutura do projeto

Organização em camadas:

- `view`: telas da aplicação.
- `view.components`: componentes visuais reutilizáveis.
- `view.theme`: cores e tema da aplicação.
- `model`: classes que representam os dados (Usuário, Ambiente, Dispositivo).
- `DAO`: acesso ao banco de dados, com `PreparedStatement`.
- `database`: criação da conexão com o MySQL.

## Como executar

Requisitos: JDK conforme o `pom.xml` (`maven.compiler.release`), Maven e MySQL.

1. Crie o banco `domuscontroldb` no MySQL e as tabelas usadas pelo sistema: `usuario`, `ambiente` e `dispositivo`.
2. Copie `db.properties.example` para `db.properties`, na raiz do projeto, e preencha usuário e senha do seu MySQL. Esse arquivo é ignorado pelo Git.
3. Execute a classe principal `view.ProjetoIntegrador` (pelo NetBeans ou com `mvn compile exec:java`).

## Limitações conhecidas

Por ser um projeto de estudo, ainda tem pontos a melhorar:

- As senhas dos usuários são salvas em texto puro no banco. O próximo passo planejado é guardar apenas o hash (por exemplo, com BCrypt).
- O campo de senha da tela de login ainda exibe o texto digitado.
- O banco prevê as tabelas `rotina`, `rotina_acao` e `log_uso`, mas essas funcionalidades ainda não foram implementadas.
- Os ambientes são cadastrados diretamente no banco; ainda não há tela para isso.
- Não há testes automatizados.

## Uso de inteligência artificial

Utilizei ferramentas de IA como apoio na construção das interfaces gráficas (telas e componentes visuais em Java Swing).

## Autor

Gabriel Braz de Cadima
