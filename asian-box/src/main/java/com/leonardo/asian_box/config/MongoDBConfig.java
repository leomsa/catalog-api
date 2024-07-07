package com.leonardo.asian_box.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {
    @Bean
    public  MongoDatabaseFactory mongoConfigure (){
        return  new SimpleMongoClientDatabaseFactory("mongodb://root:6897@192.168.1.8:27017/product-catalog");
    }

    @Bean
    public MongoTemplate mongoTemplate (){
        return new MongoTemplate(mongoConfigure());
    }
}
