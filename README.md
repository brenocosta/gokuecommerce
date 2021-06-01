**Arquitetura**
1. - Neste desenvolviemnto foi utilizado arquitetura de mult modulos para separar cada camada do projeto melhorando no reaproveitamento de código
alem de separa bem as responsabilidades.
2. - O projeto permite sua utilização como client em projetos java, atraves de um deploy criando um projeto jar para cada modulo e possivel
fazer a importação e utilizar os serviços bastando somente inejetar o bean do serviçe, otimizando o desenvolvimento em outros projetos caso seja necessario
consulmir algum serviço do gokuecommerce

**Tecnologias Utilizadas**

1. - Java 8
2. - Spring Boot
3. - Spring Data
4. - Spring Security
5. - Spring Cloud Feing
6. - Mysql
7. - Redis para cache
8. - Docker
9. - log-back


**Instalação**

A instalação local do projeto gokuecommerce e bem simples
1. - Instalação JAVA JDK8
      Link Download: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
      Fazer o download de acordo com sistema operacional.
2. - Configuração de variaveis de ambiente
      https://upperdev.com/tutorial-como-instalar-o-java-8-jdk/  
3. Configuração de banco de dados MSYQL Download
      https://downloads.mysql.com/archives/installer/
   no processo de intalação do mysql seguir todo passo a passo com as configurações padrões recomendadas
   Fazer o download de acordo com sistema operacional.
  
**Execultando Projeto**

Para inicializar o projeto bastar execultar a class principal do projeto
![image](https://user-images.githubusercontent.com/6999602/120252476-05336980-c25b-11eb-8ce2-c885bf3c5989.png)


![image](https://user-images.githubusercontent.com/6999602/120252975-89d2b780-c25c-11eb-9014-a2ff0e9d9f1b.png)

Após o processo de inicialização do projeto o banco de dados sera criado automaticamente e suas tabelas


**Acessando Swagger**
http://localhost:8080/swagger-ui.html#/

![image](https://user-images.githubusercontent.com/6999602/120253318-6b20f080-c25d-11eb-82e1-53f8015a4861.png)






  
