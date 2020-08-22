# Wallet Spring Boot Application #

### Project Overview ###

To build a simple wallet microservice running on the JVM that manages credit/debit
transactions on behalf of players.

### Application structure ###

The application is implemented as a Spring Boot application using an in memory H2 Database Engine to store the data. 
The application is structured in a controller package with an AccountController,PlayerController and TransactionController, 
that exposes multiple REST endpoints. A model package with the data model and its associated enums and classes. This data 
model contains three entity class - Account,Player and Transaction.
A repository package with AccountRepository,TransactionRepository and PlayerRepository to access the database.
The main class in the application is com.wallet.cloud.skel.SkelApplication. Running this class will start the application 
and insert two players object and their respective mapped  Account object in one-to-one relationship into the database.

There is also implemented JUnit testcases in com.wallet.cloud.skel.AccountControllerTest,
com.wallet.cloud.skel.PlayerControllerTest,com.wallet.cloud.skel.TransactionControllerTest,

### Task ###
1) Current balance per player with Paging
Sample URL- http://localhost:9443/app/api/v1/players?number=0&size=4&sort=ASC      HTTP.GET  (Gives List of all players along with account details)

2) Insert new player and map to new Account
Sample URL- http://localhost:9443/app/api/v1/players     HTTP.POST
Content-type=application/json 
Sample Body in JSON - 
{
        "name": "Player3",
        "gender": "FEMALE",
        "age": 28,
        "account": {
            "accountNumber": "300",
            "balance": 10000,
            "id": 3
        },
        "id": 3
    }
	
3) Get list of all accounts with Paging
Sample URL- http://localhost:9443/app/api/v1/accounts?number=0&size=4&sort=ASC     HTTP.GET  

4) Credit per player. The caller will supply a transaction id that must be unique for all
transactions. If the transaction id is not unique, the operation must fail. 

Sample URL- http://localhost:9443/app/api/v1/accounts/credit/Player1/4000/1   HTTP.PUT
URL Structure-http://localhost:9443/app/api/v1/accounts/credit/{PlayerName}/{credit_amount}/{Unique_Transaction_Id}

5)  Debit /Withdrawal per player A debit transaction will only succeed if there are
sufficient funds on the account (balance - debit amount >= 0).
The caller will supply a transaction id that must be unique for all transactions. If the
transaction id is not unique, the operation must fail. 

Sample URL- http://localhost:9443/app/api/v1/accounts/debit/Player1/4000/2   HTTP.PUT
URL Structure-http://localhost:9443/app/api/v1/accounts/debit/{PlayerName}/{debit_amount}/{Unique_Transaction_Id}

6) Transaction History per player

Sample URL- http://localhost:9443/app/api/v1/transactions/transactionhistorybyplayername/Player1  HTTP.GET
Url Structure: http://localhost:9443/app/api/v1/transactions/transactionhistorybyplayername/{PlayerName}

7)Transaction History by accountNumber
Sample URL- http://localhost:9443/app/api/v1/transactions/transactionhistorybyaccountnumber/100   HTTP.GET
Url Structure: http://localhost:9443/app/api/v1/transactions/transactionhistorybyaccountnumber/{AccountNumber}

8) To persist data after restart of application , I have added this properties in application.properties file,hence storing 
the data in local file :
spring.jpa.hibernate.ddl-auto: update
spring.datasource.url: jdbc:h2:file:~/data/testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;

Note: If you are restarting the application in this mode above ,please remove or comment out in SkelApplication.java below lines:
 @Bean
  ApplicationRunner initItems(){
  }
  to avoid error in application restart.
  
Note: JUNIT test will only run successfully,when in application.properties file :
spring.datasource.url: jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;IGNORECASE=TRUE 
  
### Installation ###

Clone or download the repository from https://github.com/partha20in/Wallet

The project is prepared to be used with Gradle and Eclipse IDE. (Gradle plugin buildship is by default included in Eclipse). You can of course use any other IDE if you like.

Project is configured to use JavaSE-11.

Project is tested using Eclipse IDE for Enterprise Java Developers Version: 2020-06 (4.16.0) but you can use other version.


This is how you import the project into Eclipse:

1. Choose File->Import..., select Existing Gradle Project.
1. Set Project root directory to where you cloned the repository.
1. Import Options, choose Gradle Wrapper.


### Starting application/ Run Tests ###

Right click on com.wallet.cloud.skel.SkelApplication and select Run As -> Java Application
Right click on com.wallet.cloud.skel.AccountControllerTest and select Run As -> JUnit Test
Right click on com.wallet.cloud.skel.PlayerControllerTest and select Run As -> JUnit Test
Right click on com.wallet.cloud.skel.TransactionControllerTest and select Run As -> JUnit Test


