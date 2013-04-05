package tw.com.tradevan.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoAction extends JsonSupportAction{
	private static final long serialVersionUID = -6262189591468213151L;
	private static final Logger logger = LoggerFactory.getLogger(DemoAction.class);
	public String index() throws Exception {
		this.setJsonObject("JSON..........");
		return "json";
	}

	@Override
	public Logger getLogger() {
		return logger;
	}
}
