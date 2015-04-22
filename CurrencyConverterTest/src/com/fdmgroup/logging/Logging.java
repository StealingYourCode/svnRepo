package com.fdmgroup.logging;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.fdmgroup.dao.CurrencyDAO;
import com.fdmgroup.dto.Currency;

@Aspect
public class Logging {
	
	static Logger log = 
			Logger.getLogger(Logging.class);	
	
	public Logging(){
		PropertyConfigurator.configure("H:/JAVA/workspace/CurrencyConverterTest/log4j.properties");
	}
	
//	@Pointcut("execution(* *(..))")
//	public void logEverything(){
//		log.trace("Something happened");
//		System.out.println("Something happened (console)");
//	}
	
	@Before("execution(* read(..))")
	public void logEntry()
	{
		log.trace("Entering a read");
//		System.out.println("Entering a read method");
	}
	
	@AfterReturning(pointcut="execution(com.fdmgroup.dto.Currency read(..))",
			returning="returnedObject")
	public void logExit(Currency returnedObject){
		log.trace("Retrieving conversion rate for "+ returnedObject.getCurrencyName() );
//		System.out.println("Retrieving conversion rate for "+ returnedObject.getCurrencyName() );
	}
	
	
	
	

	
}
