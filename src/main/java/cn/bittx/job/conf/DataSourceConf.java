package cn.bittx.job.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DataSourceConf {
    @Bean(name = "batchDataSource")
    public DataSource batchDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;

        /*return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                //.generateUniqueName(true)
                //.addScript("schema.sql")
                //.addScripts("user_data.sql","country_data.sql")
                .setName("Batch")
                .build();*/
    }
}
