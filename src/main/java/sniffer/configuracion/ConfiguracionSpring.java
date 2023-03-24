package sniffer.configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("sniffer.anotaciones")
@EnableAspectJAutoProxy
public class ConfiguracionSpring {}
