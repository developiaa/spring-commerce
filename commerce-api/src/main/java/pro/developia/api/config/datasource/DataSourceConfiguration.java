package pro.developia.api.config.datasource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        basePackages = "pro.developia.api.repository"
)
@RequiredArgsConstructor
public class DataSourceConfiguration {

    public static final String MATER_DATASOURCE = "masterDataSource";
    public static final String SLAVE_DATASOURCE = "slaveDataSource";
    private final JpaProperties jpaProperties;

    @Bean(MATER_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.master.hikari")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(SLAVE_DATASOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.slave.hikari")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    @Primary
    @DependsOn({MATER_DATASOURCE, SLAVE_DATASOURCE})
    public DataSource routingDataSource(
            @Qualifier(MATER_DATASOURCE) DataSource masterDataSource,
            @Qualifier(SLAVE_DATASOURCE) DataSource slaveDataSource) {
        RoutingDataSource routingDataSource = new RoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>() {
            {
                put("master", masterDataSource);
                put("slave", slaveDataSource);
            }
        };

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        return routingDataSource;
    }

    @Bean
    @Primary
    @DependsOn("routingDataSource")
    public LazyConnectionDataSourceProxy dataSource() {
        return new LazyConnectionDataSourceProxy(routingDataSource(masterDataSource(), slaveDataSource()));
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        String PACKAGES_TO_SCAN = "pro.developia.commerce";
        String PERSISTENCE_UNIT_NAME = "master";

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties.getProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    @Primary
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory entityManagerFactory = entityManagerFactory().getObject();
        assert entityManagerFactory != null;
        return new JpaTransactionManager(entityManagerFactory);
    }

}
