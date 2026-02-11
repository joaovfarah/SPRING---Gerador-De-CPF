[JAVA__BADGE]:https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Postgre__BADGE]:https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[Spring__BADGE]:https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white

<h1 align="center" style="font-weight: bold;">Gerador de CPF 💻</h1>

![Java][JAVA__BADGE]
![Spring][Spring__BADGE]
![Postgre][Postgre__BADGE]

<p>
  Este sistema permite a geração e validação de números de CPF de diversas formas. Ele oferece quatro funcionalidades principais:
</p>
<ol>
  <li><strong>Geração aleatória:</strong> o usuário pode gerar um CPF completamente aleatório.</li>
  <li><strong>Geração por estado:</strong> o usuário pode escolher o estado de origem, e o sistema gerará um CPF correspondente.</li>
  <li><strong>Geração personalizada:</strong> o usuário informa os nove primeiros dígitos, e o sistema calcula os dois dígitos verificadores.</li>
  <li><strong>Validação de CPF:</strong> o usuário digita os onze dígitos de um CPF, e o sistema verifica se ele é válido. Caso não seja, o sistema corrige e retorna um CPF válido com os dígitos verificadores ajustados.</li>
</ol>
<p>
  Este sistema foi desenvolvido com Java e Spring. A validação do usuário e a exibição de alguns trechos do código foram implementadas utilizando Spring Security, e o banco de dados utilizado é o PostgreSQL.
</p>
<h2 id="tecnologias">💻 Tecnologias</h2>

- Java
- Spring
- PostgreSQL

<h2 id="começar">🚀  Como Começar</h2>

<h3>Clone o Repositório</h3>

```bash
git clone https://github.com/daniel-sd03/gerador-cpf.git
```
## Configuração

### Application.properties

O arquivo de configuração `application.properties` deve ser configurado com as informações do banco PostgreSQL. Para isso, você deve preencher o arquivo `application.properties` na pasta `src/main/resources` com as seguintes informações:

```properties
# Exemplo de configuração do banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://<HOST>:<PORT>/<NOME_DO_BANCO>
spring.datasource.username=<SEU_USUARIO>
spring.datasource.password=<SUA_SENHA>

# Configuração do JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

```
<h2 id="aviso">⚠️ Aviso</h2>

<p>
  Este projeto foi desenvolvido exclusivamente para fins educativos e de aprendizado. O uso do código para fins ilegais ou prejudiciais não é de responsabilidade do autor. O usuário é responsável pelo uso do sistema e deve garantir que ele esteja em conformidade com as leis e regulamentos locais.
</p>

<h2 id="colaboradores">🤝 Colaboradores</h2>
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/joaovfarah">
        <sub>
          <b>João Victor Farah</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
