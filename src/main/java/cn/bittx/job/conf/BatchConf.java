package cn.bittx.job.conf;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

@Configuration
public class BatchConf extends DefaultBatchConfigurer {
    @Override
    @Autowired
    public void setDataSource(@Qualifier("batchDataSource") DataSource dataSource) {
        super.setDataSource(dataSource);
    }

   /* @Bean
    public BatchDatabaseInitializer batchDatabaseInitializer(@Qualifier("batchDataSource") DataSource dataSource, ResourceLoader resourceLoader){
        BatchDatabaseInitializer batchDatabaseInitializer = new BatchDatabaseInitializer(dataSource, resourceLoader, new BatchProperties());
        return batchDatabaseInitializer;
    }*/

  /*  @Bean
    BatchConfigurer configurer(@Qualifier("batchDataSource") DataSource dataSource){
        return new DefaultBatchConfigurer(dataSource);
    }*/
}
