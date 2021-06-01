package com.gokuecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ComponentScan(basePackages = "com.gokuecommerce")
@SpringBootApplication
@EnableAutoConfiguration
@EnableFeignClients
public class Application  extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
  
  public static void main(String[] args) {
    SpringApplication.run(Application.class,
                          args);
  }
  @Override
  public void configure(WebSecurity web) throws Exception {
          web.ignoring().antMatchers("/v2/api-docs",
                  "/swagger-resources/**",
                  "/swagger-ui.html",
                  "/webjars/**");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
          registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
          registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
      }
}
