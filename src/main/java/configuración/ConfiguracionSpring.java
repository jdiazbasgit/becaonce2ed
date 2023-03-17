package configuración;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"alumnoCotilla","profesor"})
@EnableAspectJAutoProxy
public class ConfiguracionSpring {

}
