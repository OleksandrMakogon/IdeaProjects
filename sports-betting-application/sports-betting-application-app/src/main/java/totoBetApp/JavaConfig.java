package totoBetApp;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"totoBetApp"})
@EnableAspectJAutoProxy
@PropertySource("classpath:emails.properties")
public class JavaConfig {

   /* @Bean
    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public TotoService totoService(){
        return new TotoService();
    }

    @Bean
    public View consoleView(){
        return new UI();
    }

    @Bean(name = "totoAppController")
    public TotoAppController totoAppController(){
        return new TotoAppController(totoService(), consoleView());
    }*/

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
