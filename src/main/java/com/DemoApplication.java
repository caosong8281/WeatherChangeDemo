package com;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.common.HttpClientUtils;

@SpringBootApplication
@EnableAutoConfiguration //自动加载配置信息
public class DemoApplication implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override 
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(7001);
	}
	
	@Bean
	  public RestTemplate httpsRestTemplate(HttpComponentsClientHttpRequestFactory httpsFactory) {
	    RestTemplate restTemplate = new RestTemplate(httpsFactory);
	    restTemplate.setErrorHandler(
	        new ResponseErrorHandler() {
	          @Override
	          public boolean hasError(ClientHttpResponse clientHttpResponse) {
	            return false;
	          }	 
	          @Override
	          public void handleError(ClientHttpResponse clientHttpResponse) {
	            // 默认处理非200的返回，会抛异常
	          }
	        });
	    return restTemplate;
	  }
	 
	  @Bean(name = "httpsFactory")
	  public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory()
	      throws Exception {
	    CloseableHttpClient httpClient = HttpClientUtils.acceptsUntrustedCertsHttpClient();
	    HttpComponentsClientHttpRequestFactory httpsFactory =
	        new HttpComponentsClientHttpRequestFactory(httpClient);
	    httpsFactory.setReadTimeout(40000);
	    httpsFactory.setConnectTimeout(40000);
	    return httpsFactory;
	  }
	
	
}
