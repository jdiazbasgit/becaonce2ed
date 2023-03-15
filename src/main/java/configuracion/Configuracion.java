package configuracion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

	

	@Configuration	
	@ComponentScan({"caballero","juglar"})
	@EnableAspectJAutoProxy
	
	public class Configuracion {
	
}
