package com.dev.elasticanalytics.analytics_reporting.es;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.elasticsearch")
public class ElasticSearchConfigProperties {

	/**
     * Elasticsearch cluster name.
     */
    @SuppressWarnings("unused")
	private String clusterName = "elasticsearch";

    /**
     * Comma-separated list of cluster node addresses.
     */
    @SuppressWarnings("unused")
	private String clusterNodes;

    /**
     * Additional properties used to configure the client.
     */
   // private Map<String, String> properties = new HashMap<>();
	
}
