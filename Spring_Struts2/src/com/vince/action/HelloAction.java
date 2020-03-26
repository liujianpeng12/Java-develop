package com.vince.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	
	private String name;
	
	public HelloAction(){
		System.out.println("create HelloAction!");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("name="+name);
		return SUCCESS;
	}
}
