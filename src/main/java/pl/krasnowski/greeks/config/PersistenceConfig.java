package pl.krasnowski.greeks.config;

import java.util.Properties;

import javax.sql.DataSource;

//<dependency>
//<groupId>org.apache.commons</groupId>
//<artifactId>commons-dbcp2</artifactId>
//</dependency>
//</dependencies>
//import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

//@Configuration
//@EnableAutoConfiguration
//@EnableTransactionManagement
public class PersistenceConfig {
	String[] packagesToScan = { "pl.krasnowski.greeks.model.buildings", "pl.krasnowski.greeks.model.isle", "pl.krasnowski.greeks.model.users", "pl.krasnowski.greeks.model.world",
			"pl.krasnowski.greeks.dao", "pl.krasnowski.greeks.services", "pl.krasnowski.greeks.dao", "pl.krasnowski.greeks" };
	@Autowired
	private Environment env;

	@Bean
	public AnnotationConfigApplicationContext context() {
		return new AnnotationConfigApplicationContext(this.getClass());
	}

	@Bean
	public DataSource restDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));
		return dataSource;
	}

//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(sessionFactory);
//		return txManager;
//	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@SuppressWarnings("serial")
	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.globally_quoted_identifiers", "false"); // was causing error with entities - quoted names of entities
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			}
		};
	}
}