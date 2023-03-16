package aspectos;

import java.util.GregorianCalendar;

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

	@Around("sujetador()")
	public void hacerTodo1(ProceedingJoinPoint joinPoint) {
		
		
		
		try {
			
			System.out.println("pff que me perdi a estas horas de la noche que hago la terea");
			joinPoint.proceed();
			
			GregorianCalendar fchas = new GregorianCalendar();
			System.out.println("pff "+ fchas.DATE);

			Thread.sleep(64);
			
		} catch (Throwable e) {

			System.out.println("me perdi");
			System.out.println("fechas");
			
			e.printStackTrace();
		}
		finally {
			System.out.println("estos es des pues del finally");
		}
	}

	

}
