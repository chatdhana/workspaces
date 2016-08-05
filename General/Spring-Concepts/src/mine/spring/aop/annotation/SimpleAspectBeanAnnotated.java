package mine.spring.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SimpleAspectBeanAnnotated {

	@Before("execution(public void mine.spring.aop.CustomerService(..))")
	public void beforeAdvice() {
		System.out.println("Executing Before Advice");
	}

	@AfterReturning("execution(public void mine.spring.aop.CustomerService(..))")
	public void afterReturningAdvice() {
		System.out.println("Executing After Returning Advice");
	}

	@AfterThrowing("execution(public void mine.spring.aop.CustomerService(..))")
	public void afterThrowingAdvice() {
		System.out.println("Executing After Throwing Advice");
	}

	@After("execution(public void mine.spring.aop.CustomerService(..))")
	public void afterFinallyAdvice() {
		System.out.println("Executing After (Finally) Advice");
	}

	@Around("execution(public void mine.spring.aop.CustomerService(..))")
	public void aroundAdvice(ProceedingJoinPoint pjp) {
		System.out.println("Executing Around Advice: Before call");
		try {
			pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Executing Around Advice: After call");
	}
}
