package io.github.lvbo.learn.spring.boot.mmh.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author lvbo
 * @version V1.0
 * @date 2019-07-17 10:43
 */
@Configuration
public class FlywayConfig {

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDataSource;

    @PostConstruct
    public void migrateFlyway() {
        FluentConfiguration mysqlFluentConfiguration = new FluentConfiguration();
        mysqlFluentConfiguration.dataSource(mysqlDataSource);
        mysqlFluentConfiguration.cleanDisabled(true);
        mysqlFluentConfiguration.locations("db/migration");
        Flyway mysqlFlyway = new Flyway(mysqlFluentConfiguration);
        mysqlFlyway.migrate();
    }
}
