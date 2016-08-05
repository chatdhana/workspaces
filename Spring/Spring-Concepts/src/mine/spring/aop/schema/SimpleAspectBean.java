package mine.spring.aop.schema;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleAspectBean {

	public void beforeAdvice() {
		System.out.println("Executing Before Advice");
	}

	public void afterReturningAdvice() {
		System.out.println("Executing After Returning Advice");
	}
	
	public void afterReturningAdviceWithArg(Object retVal) {
		System.out.println("Executing After Returning Advice (With return value arg):" + retVal.toString());
	}
	
	public void afterThrowingAdvice() {
		System.out.println("Executing After Throwing Advice");
	}

	public void afterThrowingAdviceWithArg(Throwable exceptionObj) {
		System.out.println("Executing After Throwing Advice (With exception thrown arg):" + exceptionObj.toString());
	}

	public void afterFinallyAdvice() {
		System.out.println("Executing After (Finally) Advice");
	}

	public void afterFinallyAdviceWithArg(String name) {
		System.out.println("Executing After (Finally) Advice (with argument):" + name);
	}

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
