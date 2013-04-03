package tw.com.tradevan.core.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.core.domain.Operator;
import tw.com.tradevan.domain.User;


public abstract class ThreadLocalHolder {
	private static final Logger logger = LoggerFactory.getLogger(ThreadLocalHolder.class);
	public static final User DEFAULT_USER = new User("System", new Date());
	private static ThreadLocal<User> USER_HOLDER = new ThreadLocal<User>();
	private static ThreadLocal<Operator> OPERATOR_HOLDER = new ThreadLocal<Operator>();
	public static User getUser() {
		return USER_HOLDER.get();
	}
	
	public static void setUser(User user) {
		USER_HOLDER.set(user);
		if (user == null) {
			OPERATOR_HOLDER.set(null);
		} else {
			OPERATOR_HOLDER.set(new Operator(user.getOid(), user.getName()));
		}
	}
	
	public static void removeUser() {
		USER_HOLDER.remove();
		OPERATOR_HOLDER.remove();
	}
	
	public static Operator getOperator() {
		return null != OPERATOR_HOLDER.get()?OPERATOR_HOLDER.get():Operator.SYSTEM_OP;
	}
}
