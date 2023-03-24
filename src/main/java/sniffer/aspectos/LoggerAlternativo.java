package sniffer.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggerAlternativo {

  @Around("@annotation(sniffer.anotaciones.SniffThis)")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();

    Object result = joinPoint.proceed();

    long endTime = System.currentTimeMillis();
    System.out.println("Tiempo de ejecución para " + joinPoint.getSignature().getName() + " ha sido " + (endTime - startTime) + " ms");

    return result;
  }

}
