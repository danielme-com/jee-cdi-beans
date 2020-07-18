package com.danielme.cdibeans.services;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class StringService implements Serializable {
	
	private static final long serialVersionUID = -870359121196178116L;

	public String print() {
		return "Hello";
	}

}