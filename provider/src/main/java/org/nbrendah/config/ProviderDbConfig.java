package org.nbrendah.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "providerEntityManagerFactory", transactionManagerRef = "providerTransactionManager", basePackages = {"org.nbrendah.travel" })
public class ProviderDbConfig {
	
	@Primary
	@Bean(name = "providerDataSourceProperties")
	@ConfigurationProperties("provider.datasource")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean(name = "providerDataSource")
	@ConfigurationProperties("provider.datasource.configuration")
	public HikariDataSource dataSource(@Qualifier("providerDataSourceProperties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	
	@Primary
	@Autowired
	@Bean(name = "providerNamedParamJdbcTemplate")
	public NamedParameterJdbcTemplate cdrNamedParamJdbcTemplate(
			@Qualifier("providerDataSource") DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Primary
	@Bean(name = "providerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("providerDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("org.nbrendah.travel").persistenceUnit("provider").build();

	}
	
	@Primary
	@Bean(name = "providerTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("providerEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
