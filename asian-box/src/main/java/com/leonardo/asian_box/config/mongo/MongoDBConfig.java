package com.leonardo.asian_box.config.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Value("${mongodb.apiKey}")
    private String apiKey;

    @Value("${mongodb.privateKey}")
    private String privateKey;

    @Bean
    public MongoDatabaseFactory mongoDbFactory() {
        String connectionString = String.format("mongodb+srv://%s:%s@cluster0.hkwjjc0.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0", apiKey, privateKey);

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        return new SimpleMongoClientDatabaseFactory(MongoClients.create(settings), "product-catalog");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}
