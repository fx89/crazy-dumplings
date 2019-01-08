# crazy-dumplings
Crazy Dumplings will be a top-down multiplayer shooter which runs on various platforms, including web browsers


# usage
The back end apps are Spring Boot applications which require application.properties files containing some wiring configuration, some data source properties, etc. To start either application, one must provide the paths to the proper application.properties files to the command line. For instance:
```
--spring.config.location=~/work/crazy-dumplings/root/config/generic/application.properties
--spring.config.location=~/work/crazy-dumplings/root/config/management-endpoint-for-game-assets/application.properties
```

It is reccommended to keep a generic application.properties file containing common properties for use in all of the applications, along with application-specific application.properties files, containing application-specific properties.

Below is an example of the generic application.properties file. The connection properties for the security database are contained in this file since the security module is a dependency of all back-end apps. 

```
crazydumplings.security.dataservice              = SpringDataSecurityDataService
spring.datasource.security.jdbcUrl               = jdbc:mysql://localhost:3306/crazy_dumplings__security
spring.datasource.security.username              = deleted
spring.datasource.security.password              = removed
spring.datasource.security.driverClassName       = com.mysql.cj.jdbc.Driver
spring.datasource.security.dialect               = org.hibernate.dialect.MySQLDialect
spring.datasource.security.show_sql              = true
logging.level.org.springframework.web            = DEBUG
logging.level.org.springframework.security       = DEBUG
logging.level.org.springframework.data           = DEBUG
```

Below is a listing of the properties for the management endpoint for security. Actually, it's just the listening port for now:

```
server.port=8092
```

Below is a listinf of the properties for the management endpoint for game assets. This app needs the connection details for the game world registry database, as well as some wiring information to tell it which data service to use (MOCK or SPRING_JPA_HIBERNATE).

```
server.port=8093
crazydumplings.gameworldregistry.dataservice                               = SpringDataGameWorldRegistryDataService
crazydumplings.gameworldregistry.dataservice.springdata.implementationtype = SPRING_JPA_HIBERNATE
spring.datasource.gameworldregistry.jdbcUrl         = jdbc:mysql://localhost:3306/crazy_dumplings__game_world_registry
spring.datasource.gameworldregistry.username        = root
spring.datasource.gameworldregistry.password        = $handover0Z
spring.datasource.gameworldregistry.driverClassName = com.mysql.cj.jdbc.Driver
spring.datasource.gameworldregistry.dialect         = org.hibernate.dialect.MySQLDialect
spring.datasource.gameworldregistry.show_sql        = true
```

