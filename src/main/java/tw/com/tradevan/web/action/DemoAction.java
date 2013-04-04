package tw.com.tradevan.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoAction extends BaseAction{
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
