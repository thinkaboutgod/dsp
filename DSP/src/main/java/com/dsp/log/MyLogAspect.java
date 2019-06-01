package com.dsp.log;


import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@Aspect
@EnableAspectJAutoProxy
public class MyLogAspect {
	
	@AfterReturning("execution(* com.dsp.service..*.*(..)) && @annotation(com.dsp.log.MyLog)")
//	@Transactional
	public void insertLog(JoinPoint joinPoint) throws Throwable {
		//dao.saveLog();
		//Class controller = Class.forName(joinPoint.getTarget().getClass().getName());
		
		System.out.println(joinPoint.getArgs().getClass());
		Object[] objects=joinPoint.getArgs();
		
		Class[] classes=new Class[objects.length];
		
		System.out.println(objects.length);
		
		for(int i=0;i<objects.length;i++) {
			System.out.println(objects[i].getClass().getName());
			classes[i]=objects[i].getClass();
		}
		
		System.out.println(joinPoint.getSignature().getName());
		
		Method method = joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(),classes);
		
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		Method method2 = ms.getMethod();
		System.out.println(method2.getName());
		
		MyLog log = method.getAnnotation(MyLog.class);
		
		System.out.println(log);
		
//		System.out.println(joinPoint.getSignature().getName() + "保存日志ing........" + "\t\t操作类型: "+ log.operationType() +"\t\t操作细节: "+log.operationDetail());
		System.out.println(method.getName() + "保存日志ing........" + "\t\t操作类型: "+ log.operationType() +"\t\t操作细节: "+log.operationDetail());
//		System.out.println(method2.getName() + "保存日志ing........" + "\t\t操作类型: "+ log2.operationType() +"\t\t操作细节: "+log2.operationDetail());
		
	}
	
	
	
}
