package tw.com.tradevan.web.action;

public class DemoAction extends BaseAction{
	public String index() throws Exception {
		this.setJsonObject("JSON..........");
		return "json";
	}
}
