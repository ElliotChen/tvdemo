package tw.com.tradevan.web.action;

import org.slf4j.Logger;

public abstract class BaseAction extends JsonSupportAction {
	public static final String INDEX = "index";
	public static final String JSON = "json";
	
	public abstract Logger getLogger();
}
