package com.danielme.cdibeans.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danielme.cdibeans.services.ContractService;
import com.danielme.cdibeans.services.StringService;

@ApplicationScoped
@Path("/demo2")
public class DemoResource2 {

	private static final Logger logger = LoggerFactory.getLogger(DemoResource2.class);

	private StringService stringService;
	private ContractService contractService;
	private List<String> stringList;

	public DemoResource2() {

	}

	@Inject
	public DemoResource2(StringService stringService, @Named("ContractServiceImpl2") ContractService contractService,
			List<String> stringList) {
		super();
		this.stringService = stringService;
		this.contractService = contractService;
		this.stringList = stringList;
	}

	@GET
	public void getDemo(@Context HttpServletRequest request) {
		stringList.forEach(logger::info);
		logger.info(contractService.getClass().getSimpleName());
		logger.info("session [{}]", request.getSession().getId());
		logger.info(this.toString());
		logger.info(stringService.toString());
		contractService.foo();
	}


}
