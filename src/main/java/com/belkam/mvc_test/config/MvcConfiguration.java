
package com.belkam.mvc_test.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.belkam.mvc_test")
@EnableJpaRepositories("com.belkam.mvc_test.repository")
public class MvcConfiguration {




}
