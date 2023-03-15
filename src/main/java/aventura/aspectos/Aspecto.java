package aventura.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import aventura.caballeros.Caballero;
import aventura.excepciones.SinEspadaException;

@Aspect
@Component

public class Aspecto {
	@Pointcut("execution(* *.embarcar(..))")
	public void marcadorPointCut() {}
	
	//@Before("marcadorPointCut()")
	public void narrarEmbarque() {
		System.out.println("El "+this.getClass().getSimpleName()+ " se embarco para rescatar a la princesa Leonor de Borbón");
	}
	
	//@After("marcadorPointCut()")
	public void narrarDesembarque() {
		System.out.println("El "+this.getClass().getSimpleName()+ " derrotó al temible dragón de Daenerys Targaryen,\n todo el pueblo celebran la victoria de un \n caballero tan valiente llamado Denis el ruedas");
	}
	
	
	@Around("marcadorPointCut()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws SinEspadaException {
		Object puntoDePausa=null;
		Caballero caballero=(Caballero) joinPoint.getTarget();
		try {
			//Before
			narrarEmbarque();
			puntoDePausa=joinPoint.proceed();
			//AfterReturning
		} 
		catch (Throwable e) {
			 System.out.println(" No carga ");
			 //caballero.setEspada(true);
			 //AfterThrowing
			
		}
		finally{
			//After
			narrarDesembarque();
			
		}
		
		return puntoDePausa;
		
	}
	

}
