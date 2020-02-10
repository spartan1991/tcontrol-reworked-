package com.vcprojects.tcontrol.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.vcprojects.tcontrol.*"})

public class JPAConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tcontrol?useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("vovik1991");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/tcontrol?useLegacyDatetimeCode=false&serverTimezone=UTC");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "vovik1991");
        properties.put("hibernate.connection.autoReconnect", "true");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    @Bean
    @SuppressWarnings("deprecation")
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan("com.vcprojects.model");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory());
        return transactionManager;
    }
}

/* ******************************USERS & ROLES****************************** */
/*

CREATE TABLE users(
   id INT(6) NOT NULL,
   login VARCHAR(50) DEFAULT NULL,
   email VARCHAR(50) DEFAULT NULL,
   password VARCHAR(50) DEFAULT NULL,
   country VARCHAR(50) DEFAULT NULL,
   registered DATETIME DEFAULT NOW(),
   status VARCHAR(50) DEFAULT "user",
   access VARCHAR(20) DEFAULT "yes",
   PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE roles(
  id INT NOT NULL AUTO_INCREMENT,
  role VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=UTF8MB4;

CREATE TABLE user_roles(
  user_id INT(6) NOT NULL,
  role_id INT(6) NOT NULL,
  KEY user (user_id),
  KEY role (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

*/

/* **********************************DATA********************************** */
/*

CREATE TABLE data(
   id INT NOT NULL,
   device VARCHAR(50) DEFAULT "N/A",
   sensor1 VARCHAR(24) DEFAULT "0",
   sensor2 VARCHAR(24) DEFAULT "0",
   sensor3 VARCHAR(24) DEFAULT "0",
   dateTime DATETIME DEFAULT NOW(),
   PRIMARY KEY(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4;


//--------------------------------------------------------//

UPDATE registered_users SET status="admin" WHERE id=13; // change

UPDATE registered_users SET status="sub-admin" WHERE id=14;

select * from registered_users where status="user" AND access="yes";

select * from registered_users where registration_date>='2019-08-12 17:30';

*/