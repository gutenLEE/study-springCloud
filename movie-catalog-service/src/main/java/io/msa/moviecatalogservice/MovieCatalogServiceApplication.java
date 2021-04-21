package io.msa.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
public class MovieCatalogServiceApplication {

    @Bean
    @LoadBalanced // telling restTemplate don't go to a service directly whatever URL i am giving you. it is not actual URL
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

/*    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(MovieCatalogServiceApplication.class, args);
    }

}
