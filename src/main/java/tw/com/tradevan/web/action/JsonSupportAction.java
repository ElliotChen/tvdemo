package tw.com.tradevan.web.action;

public abstract class JsonSupportAction extends BaseAction {
	public static final String JSON = "json";
	private Object jsonObject;

	public Object getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(Object jsonObject) {
		this.jsonObject = jsonObject;
	}
	
}
