package aventura.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@AspectJ
@Configuration
@ComponentScan({"aventura.aspectos","aventura.caballeros","aventura.anotaciones"})
@EnableAspectJAutoProxy
public class ConfiguracionSpring {}
