package aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LaMaquinaDelTiempo {
	
	@Pointcut("execution(* *.*(..))")
	public void sujetador() {
		
	}
	public void nosequehaceaqui() {
		System.out.println("pff que me perdi a estas horas de la noche que hago la terea");
	}
	
	@Around("sujetador()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) {
		System.out.println("leer_1");
		System.out.println("me perdi");
		System.out.println("fechas");
		return null;
	}
	

}
