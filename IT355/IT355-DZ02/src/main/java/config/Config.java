package config;

import aspect.InterceptorLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import service.impl.Chicken;
import service.impl.Dog;
import service.impl.Sheep;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Config {

    @Bean(name = "dog")
    public Dog dog() {
        return new Dog();
    }

    @Bean(name = "sheep")
    public Sheep sheep() {
        return new Sheep();
    }

    @Bean(name = "chicken")
    public Chicken chicken() {
        return new Chicken();
    }

    @Bean(name = "log")
    public InterceptorLog getAspect() {
        return new InterceptorLog();
    }

}
