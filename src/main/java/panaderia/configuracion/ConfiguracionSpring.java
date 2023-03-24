package panaderia.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ComponentScan("panaderia.panaderos")
@ComponentScan({"panaderia.panaderos","sniffer.aspectos"})
@EnableAspectJAutoProxy
public class ConfiguracionSpring {}
