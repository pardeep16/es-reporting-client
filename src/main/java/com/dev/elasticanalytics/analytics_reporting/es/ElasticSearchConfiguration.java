package com.dev.elasticanalytics.analytics_reporting.es;

import java.util.Properties;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ElasticSearchConfigProperties.class)
public class ElasticSearchConfiguration {
	
	private final ElasticSearchConfigProperties elasticSearchConfigProperties;

	public ElasticSearchConfiguration(ElasticSearchConfigProperties elasticSearchConfigProperties) {
		super();
		this.elasticSearchConfigProperties = elasticSearchConfigProperties;
	}
	
	@Bean
	public TransportClient elasticSearchClient() throws Exception{
		TransportClientFactory factory = new TransportClientFactory();
       // factory.setClusterNodes(this.elasticSearchConfigProperties.getClusterNodes());
       // factory.setProperties(createProperties());
        factory.afterPropertiesSet();
        TransportClient client = factory.getObject();
        return client;
	}
	
	
//	private Properties createProperties() {
//        Properties properties = new Properties();
//        properties.put("cluster.name", "my-application");
//        properties.put(", value)
//        return properties;
//    }
}
