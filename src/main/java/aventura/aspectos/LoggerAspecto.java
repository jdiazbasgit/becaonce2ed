package aventura.aspectos;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import aventura.excepciones.SinEspadaException;
import lombok.Data;

@Aspect
@Component
@Data
public class LoggerAspecto {

	private String log = "\n";
	
	@Pointcut("@annotation(aventura.anotaciones.SniffThis)")
	//@Pointcut("within(aventura.*)")
	//@Pointcut("execution(* *.*(..))")
	//@Pointcut("call(@aventura.anotaciones.SniffThis * *.*(..))")
	public void dondeApuntaElPointcut() {}
	

	public void grabarLogger(String nombre, String argumentos, String clase, String antesDespues) {
		
		grabaTextoEnArchivo("log.txt", "///("+this.getClass().getSimpleName()+") "+antesDespues+" ["+fechaActual()+"] \n"+clase+"\nMétodo: "+ nombre+" Parámetros: "+argumentos +"\n");
		
		//System.out.println("///("+this.getClass().getSimpleName()+") "+antesDespues+" ["+fechaActual()+"] "+nombre+"\n");
		
		//setLog(getLog()+"///("+this.getClass().getSimpleName()+") "+antesDespues+" ["+fechaActual()+"] "+nombre+"\n");		
	}
	
	public void grabaTextoEnArchivo(String archivo, String textoAGrabar) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(archivo, true);
				PrintWriter printWriter = new PrintWriter(fileOutputStream);) {
			printWriter.println(textoAGrabar);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public String fechaActual() {
	Calendar calendario = Calendar.getInstance();
	String fecha = Integer.toString(calendario.get(Calendar.MILLISECOND)) + "ms:" 
			+ Integer.toString(calendario.get(Calendar.SECOND)) + "s:" 
			+ Integer.toString(calendario.get(Calendar.MINUTE)) + "m:" 
			+ Integer.toString(calendario.get(Calendar.HOUR_OF_DAY)) + "h - " 
			+ Integer.toString(calendario.get(Calendar.DATE)) + "/"
			+ Integer.toString(calendario.get(Calendar.MONTH) + 1) + "/"
			+ Integer.toString(calendario.get(Calendar.YEAR));
	return fecha;
	}
	
	
	
	@Around("dondeApuntaElPointcut()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws SinEspadaException {
		Object puntoDePausa=null;
		//DarkKnight darkKnight=(DarkKnight) joinPoint.getTarget();
		String metodo= joinPoint.getSignature().getName();
		//String clase = joinPoint.getTarget().getClass().toString();
		//String nombreArg2= joinPoint.getKind();
		//String nombreArg4= joinPoint.toShortString();
		String clase= joinPoint.toLongString();
		//String nombreArg5= joinPoint.toString();
		String argumentos = "";
		Object[] nombreArg6= joinPoint.getArgs();
		for (Object argumento : nombreArg6) {
			argumentos = argumento.toString()+" ";
		}
		

		try {
			//Before
			grabarLogger(metodo, argumentos, clase, "Accediendo a ejecución  -----> ");
			puntoDePausa=joinPoint.proceed();
			//AfterReturning
		} 
		catch (Throwable e) {
			grabarLogger(metodo, argumentos, clase, e.getMessage()+" <<¡Excepción lanzada!>>  --<>--  ");
			throw new SinEspadaException();
			 //System.out.println("("+this.getClass().getSimpleName()+") no deberÃ­as ver esto");
			 //AfterThrowing
			
		}
		finally{
			//After
			grabarLogger(metodo, argumentos, clase, "Ejecución terminada  <-----    ");
			//System.out.println(getLog());
		}
		
		return puntoDePausa;
		
	}
	
}
