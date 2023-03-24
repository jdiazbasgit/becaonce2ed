package sniffer.aspectos;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.Data;

@Aspect
@Component
@Data
public class LoggerAspecto {

	private String log = "\n";
	
	@Pointcut("@annotation(sniffer.anotaciones.SniffThis)")
	//@Pointcut("execution(* panaderia.panaderos.*.*(..)) && @annotation(sniffer.anotaciones.SniffThis)")
	//@Pointcut("within(panaderia.panaderos.*) || @annotation(sniffer.anotaciones.SniffThis)")
	//@Pointcut("@annotation(sniffer.anotaciones.SniffThis) || within(@sniffer.anotaciones.SniffThis *)")
	//@Pointcut("execution(* panaderia.panaderos..*(..))")
	//@Pointcut("execution(* *(..)) && @annotation(sniffer.anotaciones.SniffThis)")
	//@Pointcut("within(panaderia.panaderos.Panadero)")
	public void dondeApuntaElPointcut() {}
	
	@Around("dondeApuntaElPointcut()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) throws Exception {
		Object puntoDePausa=null;
		String metodo= joinPoint.getSignature().getName();
		String clase= joinPoint.toLongString();
		String argumentos = "";
		Object[] nombreArg6= joinPoint.getArgs();
		for (Object argumento : nombreArg6) {
			argumentos = argumentos+argumento.toString()+" ";
		}
		try {
			grabarLogger(metodo, argumentos, clase, "Accediendo a ejecución  -----> ");
			puntoDePausa=joinPoint.proceed();
		} 
		catch (Throwable e) {
			grabarLogger(metodo, argumentos, clase, e.getMessage()+" <<¡Excepción lanzada!>>  --<>--  ");
			throw new Exception(e.getMessage());
		}
		finally{
			grabarLogger(metodo, argumentos, clase, "Ejecución terminada  <-----    ");
		}
		return puntoDePausa;
	}
	

	public void grabarLogger(String nombre, String argumentos, String clase, String antesDespues) {
		grabaTextoEnArchivo("log.txt", "///("+this.getClass().getSimpleName()+") "+antesDespues+" ["+fechaActual()+"] \n"+clase+"\nMétodo: "+ nombre+" Parámetros: "+argumentos +"\n");
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
}
