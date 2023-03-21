package aventura.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import aventura.caballeros.DarkKnight;
import aventura.excepciones.SinEspadaException;

@Aspect
@Component
public class JuglarAspecto {

	@Pointcut("execution(public * aventura.caballeros.DarkKnight.embarcar(..))")
	public void dondeApuntaElPointcut() {}
	
//	@Before("dondeApuntaElPointcut()")
//	public void narrarPorAdvicesSeparadosBefore() {
//		System.out.println("se embarca");
//	}
//	@AfterReturning("dondeApuntaElPointcut()")
//	public void narrarPorAdvicesSeparadosAfterReturning() {
//		System.out.println("vuelve de la misiï¿½n");
//	}
//	@AfterThrowing("dondeApuntaElPointcut()")
//	public void narrarPorAdvicesSeparadosAfterThrowing() {
//		System.out.println("no tenï¿½a espada :(");
//	}
	
	
	public void narrarEmbarque(String nombreCaballero) {
		System.out.println("("+this.getClass().getSimpleName()+") El "+nombreCaballero+ " se embarcó en gloriosa aventura,");
		System.out.println("("+this.getClass().getSimpleName()+ ") la de rescatar a su reina futura");
	}
	public void narrarDesembarque(String nombreCaballero) {
		System.out.println("\n("+this.getClass().getSimpleName()+") El "+nombreCaballero+" derrotó al temible dragón,");
		System.out.println("("+this.getClass().getSimpleName()+") celebremos su victoria con esta canción");
	}
	
	
	
	@Around("dondeApuntaElPointcut()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws SinEspadaException {
		Object puntoDePausa=null;
		DarkKnight darkKnight=(DarkKnight) joinPoint.getTarget();
		try {
			//Before
			narrarEmbarque(darkKnight.getClass().getSimpleName());
			puntoDePausa=joinPoint.proceed();
			//AfterReturning
			narrarDesembarque(darkKnight.getClass().getSimpleName());
		} 
		catch (Throwable e) {
			 System.out.println("\n("+this.getClass().getSimpleName()+") Nuestro "+darkKnight.getClass().getSimpleName()+" se olvidó la espada,");
			 System.out.println("("+this.getClass().getSimpleName()+") el pobre es más simple que una fabada\n");			 
			 //AfterThrowing			
		}
		finally{
			//After			
		}
		
		return puntoDePausa;
		
	}
}
