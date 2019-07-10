package io.github.lvbo.learn.spring.boot.mmh.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "io.github.lvbo.learn.spring.boot.mmh.dao.hbase", sqlSessionTemplateRef  = "hbaseSqlSessionTemplate")
public class DataSourceHbaseConfig {

    @Bean(name = "hbaseDataSource")
    @ConfigurationProperties("spring.datasource.druid.hbase")
    public DataSource hbaseDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "hbaseSqlSessionFactory")
    public SqlSessionFactory hbaseSqlSessionFactory(@Qualifier("hbaseDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/hbase/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "hbaseTransactionManager")
    public DataSourceTransactionManager hbaseTransactionManager(@Qualifier("hbaseDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "hbaseSqlSessionTemplate")
    public SqlSessionTemplate hbaseSqlSessionTemplate(@Qualifier("hbaseSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
