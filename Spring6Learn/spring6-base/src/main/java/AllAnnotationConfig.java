import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import xyz.ziang.AnnotationConfigLearn;

@ComponentScan("xyz.ziang")
@Configuration
public class AllAnnotationConfig {
    @Bean
    public AnnotationConfigLearn annotationConfigLearn() {
        return new AnnotationConfigLearn();
    }
}
