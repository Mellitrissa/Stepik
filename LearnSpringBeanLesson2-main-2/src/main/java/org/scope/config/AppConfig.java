package org.scope.config;

import org.scope.models.Cat;
import org.scope.models.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.scope")
public class AppConfig {

    @Bean
    @Scope("prototype")
    public Cat catBean() {
        return new Cat();
    }

    @Bean
    public Dog dogBean() {
        return new Dog();
    }
}
