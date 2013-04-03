package tw.com.tradevan.core.domain.support;

public interface Condition {
	public String toSqlString();
	public ConditionEnum getConditionEnum();
}
