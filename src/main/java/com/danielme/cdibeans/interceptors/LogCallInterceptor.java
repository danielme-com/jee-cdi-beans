package com.danielme.cdibeans.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogCallInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LogCallInterceptor.class);

	@AroundInvoke
	private Object log(InvocationContext context) throws Exception {
		logger.info("method {} called", context.getMethod().toString());
		return context.proceed();
	}

}
