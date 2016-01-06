package com.action;


import org.xml.sax.InputSource;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;

public class LoginAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 1L;

	
	public String login() throws Exception{
		System.out.println("Good");
		parse();
		return SUCCESS;
	}

	public void parse() {
		try {
			SAXParser parser = new SAXParser();
			Handler handler = new Handler();
			parser.setContentHandler(handler);
			parser.setErrorHandler(handler);

			InputSource inputSource = new InputSource(Handler.class.getClassLoader().getResourceAsStream("audit.xml"));
			parser.parse(inputSource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
