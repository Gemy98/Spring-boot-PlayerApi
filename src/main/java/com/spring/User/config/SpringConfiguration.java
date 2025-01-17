package com.spring.User.config;


import com.spring.User.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SpringConfiguration implements RepositoryRestConfigurer {



    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
      RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

      HttpMethod[] preventMethod = {HttpMethod.GET,HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};

      config.
              getExposureConfiguration()
              .forDomainType(User.class)
              .withItemExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod))
              .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(preventMethod));


    }
}
