package concierto.aspectos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.mysql.cj.jdbc.Driver;

import concierto.musicos.Solista;

@Component
@Aspect
public class AvisadorDeAudiencia {

	//@Pointcut("execution(* *.tocar(..))")
	@Pointcut("execution(@concierto.anotaciones.Conectar * *.*(..))")
	public void sujetador() {}
	
	//sujetador() el la referencia al pointcut
	//@Before("sujetador()")
	public void apagarMoviles() {
		System.out.println("SEÑORES APAGUEN LOS MOVILES QUE VA A EMPEZAR EL CONCIERTO EN AROND");
	}
	
	//@After("sujetador()")
	public void encenderMoviles() {
		System.out.println("SEÑORES YA PUEDEN ENCENDER LOS MOVILES QUE EL COINCIERTO HA TERMINADO EN AROUND");
	}
	
	public Connection getConexion() {
		Connection salida= null;
		try {
			DriverManager.registerDriver(new Driver());
			salida=DriverManager.getConnection("jdbc:mysql://82.223.202.137:3306/empresas", "curso", "Cursocurso1;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salida;
		
	}
	
	@Around("sujetador()")
	public Object hacerTodo(ProceedingJoinPoint joinPoint) {
		Object salida=null;
		Connection conexion=getConexion();
		Solista solista=(Solista) joinPoint.getTarget();
		try {
			//Before
			
			solista.setConexion(conexion);
			apagarMoviles();
			salida=joinPoint.proceed();
			//AfterReturning
			System.out.println("el instrumento se ha arreglado");
		} catch (Throwable e) {
			//afterThrowing
			System.out.println("señores el instrumento se ha estropeado");
		}
		finally{
			//After
			encenderMoviles();
			try {
				conexion.close();
			} catch (SQLException e) {
			}
		}
		
		return salida;
		
	}
	
	
	
	
}












