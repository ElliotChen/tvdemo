package tw.com.tradevan.web.action;

import org.slf4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 3513489693598603699L;

	public static final String INDEX = "index";
	
	public abstract Logger getLogger();
}
