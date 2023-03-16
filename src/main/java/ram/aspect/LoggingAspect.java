package ram.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(* *.*.EmployeeService.addEmployee(..))")
	private void anyLogBefore() {}
	
	/*@After("anyLogBefore()")*/
	@Around("execution(* *.*.EmployeeService.addEmployee(..))")
	public void logBefore(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("logBefore() is running!");
			System.out.println("Before " + joinPoint.getSignature().getName() + " method");
			System.out.println("********");
			
			System.out.println(joinPoint.proceed());
			System.out.println(joinPoint.getTarget().getClass().getSimpleName()); //result:: ram.service.EmployeeService@5c33f1a9
			System.out.println(joinPoint.getKind()); //result:: method-execution
			System.out.println(joinPoint.toString()); //result:: execution(void ram.service.EmployeeService.addEmployee())
			System.out.println(joinPoint.getArgs()[0].getClass().getSimpleName()); //result:: [Ljava.lang.Object;@1623b78d
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	/*@Before("execution(* *.*.EmployeeService.addEmployee(..))")
	public void antes(){
		System.out.println("logBefore() is running!");
		System.out.println("Before " + joinPoint.getSignature().getName() + " method");
		System.out.println("********");
		
	}
	
	@After("execution(* *.*.EmployeeService.addEmployee(..))")
	public void despues(){
		System.out.println(joinPoint.getTarget()); //result:: ram.service.EmployeeService@5c33f1a9
		System.out.println(joinPoint.getKind()); //result:: method-execution
		System.out.println(joinPoint.toString()); //result:: execution(void ram.service.EmployeeService.addEmployee())
		System.out.println(joinPoint.getArgs()); //result:: [Ljava.lang.Object;@1623b78d
	}*/
}
