package aventura.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"aventura.aspectos","aventura.caballeros"})
@EnableAspectJAutoProxy
public class ConfiguracionSpring {

	
}
