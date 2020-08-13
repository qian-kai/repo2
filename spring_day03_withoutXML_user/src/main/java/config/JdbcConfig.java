package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {

    @Value("{jdbc.driverName}")
    private String driverName;
    @Value("{jdbc.url}")
    private String url;
    @Value("{jdbc.username}")
    private String username;
    @Value("{jdbc.password}")
    private String password;

    @Bean
    public JdbcTemplate createTemplate(@Qualifier(value ="ds1") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "ds1")
    public DataSource createDataSource1(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///mytest?useSSL=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean(name = "ds2")
    public DataSource createDataSource2(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName("driverName");
        dataSource.setUrl(url);
        dataSource.setUsername("username");
        dataSource.setPassword("password");
        return dataSource;
    }
}
