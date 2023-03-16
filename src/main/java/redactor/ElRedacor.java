package redactor;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import configuraciontraza.ConfiguracionSpring;
import traza.TrazaInterface;

@Component
@Aspect
public class ElRedacor {

	public static void main(String[] args) {
		
		ApplicationContext redactor = new AnnotationConfigApplicationContext(ConfiguracionSpring.class);
		TrazaInterface traza = (TrazaInterface) redactor.getBean("traza");
		//System.out.println("La traza");
	}

}
