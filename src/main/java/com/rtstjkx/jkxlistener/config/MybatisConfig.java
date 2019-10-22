package com.rtstjkx.jkxlistener.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig  {
    @Bean
    public SqlSessionFactory SqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置项目中实体类entity的存储路径
        sqlSessionFactoryBean.setTypeAliasesPackage("com.rtstjkx.jkxlistener.entity");
        //添加XML目录
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        //配置Mapper文件路径
        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath:mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        //Dao层文件路径
        mapperScannerConfigurer.setBasePackage("com.rtstjkx.jkxlistener.repository");
        return mapperScannerConfigurer;
    }
}
