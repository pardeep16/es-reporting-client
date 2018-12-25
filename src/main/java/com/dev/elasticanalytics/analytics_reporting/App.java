package com.dev.elasticanalytics.analytics_reporting;

import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan("com.dev.elasticanalytics.analytics_reporting")
@SpringBootApplication
public class App implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	TransportClient elasticSearchClient;

	@Override
	public void run(String... strings) throws Exception {
		
		clusterHealth();
	}
	
	
	/*public void search() {
	    try {
	        
	        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(indices)
	        SearchResponse searchResponse = searchRequestBuilder.
	                setQuery(QueryBuilders.boolQuery()
	                        .should(QueryBuilders.termQuery("id","5"))
	                        .should(QueryBuilders.prefixQuery("content","oracle")))
	                .setFrom(0).setSize(100).setExplain(true).execute().actionGet();
	        SearchHits searchHits = searchResponse.getHits();
	        System.out.println();
	        System.out.println("Total Hits is " + searchHits.totalHits());
	        System.out.println();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/
	
	
	public void clusterHealth(){
		final ClusterHealthResponse clusterHealthResponse=elasticSearchClient.admin().cluster().prepareHealth().setWaitForGreenStatus().get();
		
		System.out.println(clusterHealthResponse.getStatus());
		
		elasticSearchClient.close();
	}
}