# Test Hibernate Connection with Gradle

The purpose of this project is to learn the basic of Hibernate using Gradle;
In this project will be used **Native Hibernate APIs**, **Annotation Mappings**
and **Criteria Queries**.

Please see [HIBERNATE Official Site](https://hibernate.org) for more informations.

## Requirements

### Base
* Java Used Version: 11
* [Gradle](https://gradle.org/) Used Version: 5.6.2
* [MySql](https://www.mysql.com) Used version: 8.0.15


### Dependencies

* [mysql-connector-java](https://bintray.com/bintray/jcenter/mysql%3Amysql-connector-java) Used Version: 8.0.17
* [hibernate-c3p0](https://bintray.com/bintray/jcenter/org.hibernate%3Ahibernate-c3p0/5.4.0.Final) Used Version: 5.4.0.Final
* [hibernate-core](https://bintray.com/bintray/jcenter/org.hibernate%3Ahibernate-core/5.4.0.Final) Used Version: 5.4.0.Final
* [junit](https://bintray.com/bintray/jcenter/junit%3Ajunit) Used Version: 4.12

## Configuration

rename the file  **src/main/resources/default_hibernate.cfg.xml** as **src/main/resources/hibernate.cfg.xml** and change the follow parameters with those of your MySql server
```
...
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/***DBNAME***?useSSL=false</property>
<property name="hibernate.connection.username">***USERNAME***</property>
<property name="hibernate.connection.password">***PASSWORD***</property>
...
```

### MySql Table

here the user Table to place into the Db
```
CREATE TABLE `users` (
  `username` varchar(10) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
)
```

## Changes 
Please see the [CHANGES](CHANGES.md) files for details

## Authors

* **[SirZiphon](https://github.com/SirZiphon)** - Initial work

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details
