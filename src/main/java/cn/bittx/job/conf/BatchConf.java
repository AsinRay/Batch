package cn.bittx.job.conf;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
@Import(DataSourceConf.class)
public class BatchConf {


 /*   @Bean
    public BatchDataSourceInitializer   batchDataSourceInitializer(
            @Qualifier("dataSource") DataSource dataSource, ResourceLoader resourceLoader){
        BatchDataSourceInitializer batchDatabaseInitializer = new BatchDataSourceInitializer(dataSource, resourceLoader, new BatchProperties());
        return batchDatabaseInitializer;
    }*/

    @Bean
    BatchConfigurer configurer(@Qualifier("dataSource") DataSource dataSource){
        return new DefaultBatchConfigurer(dataSource);
    }
}
