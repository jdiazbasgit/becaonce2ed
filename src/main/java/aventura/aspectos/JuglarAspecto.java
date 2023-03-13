package aventura.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import aventura.caballeros.DarkKnight;
import aventura.excepciones.SinEspadaException;

@Aspect
@Component
public class JuglarAspecto {

	@Pointcut("execution(* *.embarcar(..))")
	public void dondeApuntaElPointcut() {}
	
	//@Before("dondeApuntaElPointcut()")
	public void narrarEmbarque() {
		System.out.println("El "+this.getClass().getSimpleName()+ " se embarcó en gloriosa aventura,\n la de rescatar a su reina futura");
	}
	
	//@After("dondeApuntaElPointcut()")
	public void narrarDesembarque() {
		System.out.println("El "+this.getClass().getSimpleName()+ " derrotó al temible dragón,\n celebremos su victoria con esta canción");
	}
	
	
	@Around("dondeApuntaElPointcut()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws SinEspadaException {
		Object puntoDePausa=null;
		DarkKnight darkKnight=(DarkKnight) joinPoint.getTarget();
		try {
			//Before
			narrarEmbarque();
			puntoDePausa=joinPoint.proceed();
			//AfterReturning
		} 
		catch (Throwable e) {
			 System.out.println("uuuuuuuuuuuuups! no funciona");
			 //darkKnight.setEspada(true);
			 //AfterThrowing
			
		}
		finally{
			//After
			narrarDesembarque();
			
		}
		
		return puntoDePausa;
		
	}
}
