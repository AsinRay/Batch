package cn.bittx.job.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {

    @Bean
    //@ConditionalOnMissingBean(name = "dataSource")
    @ConfigurationProperties(prefix="spring.batch.ds")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    //@ConditionalOnMissingBean(name = "bizDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public DataSource bizDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /*
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties bizDatasourceProperties() {
        return new DataSourceProperties();
    }
    @Bean
    @Primary
    public DataSource bizDataSource() {
        return bizDatasourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
    */
}
