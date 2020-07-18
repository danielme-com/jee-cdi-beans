package com.danielme.cdibeans.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danielme.cdibeans.services.ContractService;
import com.danielme.cdibeans.interceptors.LogCallInterceptor;
import com.danielme.cdibeans.services.QualifierService;
import com.danielme.cdibeans.services.QualifierService1;
import com.danielme.cdibeans.services.StringService;

@ApplicationScoped
@Path("/demo")
@Interceptors({ LogCallInterceptor.class })
public class DemoResource {

	private static final Logger logger = LoggerFactory.getLogger(DemoResource.class);

	@Inject
	private StringService stringService;
	@Inject
	@Named("ContractServiceImpl2")
	private ContractService contractService;
	@Inject
	List<String> stringList;

	@Inject
	@Any
	Instance<ContractService> contracts;

	@Inject
	@QualifierService1
	QualifierService qualifierService;

	//http://localhost:8080/cdibeans/api/demo
	@GET
	public void getDemo(@Context HttpServletRequest request) {
		contracts.forEach(c -> logger.info(c.getClass().getSimpleName()));
		stringList.forEach(logger::info);
		logger.info(contractService.getClass().getSimpleName());
		logger.info("session [{}]", request.getSession().getId());
		logger.info(this.toString());
		logger.info(stringService.toString());
		contractService.foo();
	}

}
