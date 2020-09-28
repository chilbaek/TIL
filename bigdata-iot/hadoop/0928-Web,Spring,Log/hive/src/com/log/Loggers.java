package com.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.biz.CarStatus;
@Service
@Aspect
public class Loggers {
	private Logger work_log = 
			Logger.getLogger("work"); 
	private Logger user_log = 
			Logger.getLogger("user"); 
	private Logger data_log = 
			Logger.getLogger("data"); 
	private Logger car_log = 
			Logger.getLogger("car"); 
	
	// before
	@Before("execution(* com.biz.CarBiz.*(..))")
	public void logging3(JoinPoint jp) {
		Object[] args = jp.getArgs();
		CarStatus cstatus = (CarStatus)args[0];
		car_log.debug(jp.getSignature().getName()+","+cstatus.getId()+","+cstatus.getSpeed()+","+
						cstatus.getTemp()+","+cstatus.getOiltemp());
	}
	
	// before
	@Before("execution(* com.*.ShopController.*(..))")
	public void logging1(JoinPoint jp) {
		Object[] args = jp.getArgs();
		//Click click = (Click)args[0];
		data_log.debug(jp.getSignature().getName());
	}
	// before
	@Before("execution(* com.*.MainController.*(..))")
	public void logging2(JoinPoint jp) {
		work_log.debug(jp.getSignature().getName()+","+"ABC");
	}

	
}





