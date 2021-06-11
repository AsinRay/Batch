package cn.bittx.job.conf;


import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="bizEntityManagerFactory",
        transactionManagerRef="bizTransactionManager",
        basePackages= { "cn.bittx.job.repo" })
public class JPAConf {

    @Resource
    private DataSource bizDataSource;

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean bizEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(bizDataSource)
                //.packages("com.javatodev.api.model.bank")
                .packages("cn.bittx.job.bean")
                .build();
    }

    @Bean
    public PlatformTransactionManager bizTransactionManager(LocalContainerEntityManagerFactoryBean bizEntityManagerFactory) {
        return new JpaTransactionManager(bizEntityManagerFactory.getObject());
    }



  /*  @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(your_datasource);
        entityManagerFactoryBean.setPackagesToScan(package_to_scan);
        //additional config of factory

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) throws URISyntaxException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }*/


    /*@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary () {
        return builder
                .dataSource(primaryDataSource)
                .properties(getVendorProperties(primaryDataSource))
                .packages("com.zxl.examples.entity") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build();
    }*/
}
