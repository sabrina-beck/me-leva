# me-leva
Rede social de caronas criada como parte de um trabalho da disciplica de Banco de Dados da Unicamp.

# Instruções para ambiente de desenvolvimento

O projeto usa maven para controle de dependências e build. Para fazer o build do projeto use o comando:

```mvn clean install```

Para subir o servidor local, basta rodar a main da classe com.meleva.aplicacao.server.Sever. Isso subirá um servidor em http://localhost:8080. Você pode usar uma ide de sua preferência para subir o servidor ou rodar o próprio jar gerado no build do projeto. Se usar uma ide diferente de Eclipse e Intellij não se esqueça de adicionar os arquivos apropriados no gitignore

Para rodar os scripts de banco de dados, vá para o diretório meleva-db e execute

```mvn flyway:migrate```

Esse comando usará por padrão os dados de conexão que estão no arquivo flyway.properties, para rodar os scripts sql em ambiente de staging use o arquivo staging.properties

```mvn flyway:migrate -Dflyway.configFile=staging.properties```

Para passar dados de outro banco, ou crie o seu properties ou execute o seguinte comando

```mvn flyway:migrate -Dflyway.url=... -Dflyway.user=... -Dflyway.password=...```
