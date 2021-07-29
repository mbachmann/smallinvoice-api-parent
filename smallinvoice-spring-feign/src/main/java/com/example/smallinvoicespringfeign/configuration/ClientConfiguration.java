package com.example.smallinvoicespringfeign.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.Retryer;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
@EnableConfigurationProperties
public class ClientConfiguration {
  @Value("${smallinvoiceapireference.security.bearerAuth.username:}")
  private String bearerAuthUsername;
  @Value("${smallinvoiceapireference.security.bearerAuth.password:}")
  private String bearerAuthPassword;
  @Value("${smallinvoiceapireference.security.oauth.access-token-url:https://api.smallinvoice.com/v2/auth/access-tokens}")
  private String accessTokenUri;

  public ClientConfiguration() {
  }

  @Bean
  @ConditionalOnProperty(
          name = {"smallinvoiceapireference.security.bearerAuth.username"}
  )
  public BasicAuthRequestInterceptor bearerAuthRequestInterceptor() {
    return new BasicAuthRequestInterceptor(this.bearerAuthUsername, this.bearerAuthPassword);
  }

  @Bean
  @ConditionalOnProperty({"smallinvoiceapireference.security.oauth.client-id"})
  public OAuth2FeignRequestInterceptor oauthRequestInterceptor(OAuth2ClientContext oAuth2ClientContext) {
    return new OAuth2FeignRequestInterceptor(oAuth2ClientContext, this.oauthResourceDetails());
  }

  @Bean
  @ConditionalOnProperty({"smallinvoiceapireference.security.oauth.client-id"})
  public OAuth2ClientContext oAuth2ClientContext() {
    return new DefaultOAuth2ClientContext();
  }

  @Bean
  @ConditionalOnProperty({"smallinvoiceapireference.security.oauth.client-id"})
  @ConfigurationProperties("smallinvoiceapireference.security.oauth")
  public ClientCredentialsResourceDetails oauthResourceDetails() {
    ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
    details.setAccessTokenUri(accessTokenUri);
    return details;
  }

  @Bean
  public Decoder feignDecoder() {
    HttpMessageConverter<Object> jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
    ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
    return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
  }

  @Bean
  public Encoder feignEncode() {
    HttpMessageConverter<Object> jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
    ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
    return new SpringEncoder(objectFactory);
  }

  public ObjectMapper customObjectMapper(){
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return objectMapper;
  }

  @Bean
  public Retryer feignRetryer(){
    return new Retryer.Default(100, 1000, 4);
  }

  @Bean
  public FeignErrorDecoder feignErrorDecoder() {
    return new FeignErrorDecoder();
  }

}
