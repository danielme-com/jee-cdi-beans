package com.danielme.cdibeans.services;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class DemoProducer {

	@Produces
	@ApplicationScoped
	List<String> produceStrings() {
		return Arrays.asList("string 1", "string 2");
	}

	@Produces
	@Named("className")
	String produceClassName(@Named("ContractServiceImpl") ContractService contractService) {
		return contractService.getClass().getSimpleName();
	}

}
