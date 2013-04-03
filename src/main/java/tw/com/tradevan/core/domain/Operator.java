package tw.com.tradevan.core.domain;

public class Operator {
	public static final Operator SYSTEM_OP = new Operator("system", "SYSTEM");
	private String oid;
	private String name;
	
	public Operator() {
		super();
	}
	
	public Operator(String oid, String name) {
		super();
		this.oid = oid;
		this.name = name;
	}

	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
