package com.gcchr.system.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@ComponentScan({"com.gcchr.system"})
@EnableMongoRepositories(basePackages = {"com.gcchr.system.dal.repository"})
public class MongoConfiguration extends AbstractMongoConfiguration
{
    @Value("${mongo.db.name}")
    private String dbName;

    @Value("${mongo.db.host}")
    private String host;

    @Value("${mongo.db.port}")
    private Integer port;

    @Override protected String getDatabaseName()
    {
        return this.dbName;
    }

    @Override public Mongo mongo() throws Exception
    {
        return new MongoClient(this.host, this.port);
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception
    {
        final org.springframework.data.mongodb.core.MongoTemplate template = super.mongoTemplate();
        template.setWriteConcern(WriteConcern.SAFE);

        return template;
    }

    @Override
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception
    {
        return new SimpleMongoDbFactory(mongo(), getDatabaseName());
    }
}
