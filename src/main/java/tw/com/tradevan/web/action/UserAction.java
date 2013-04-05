package tw.com.tradevan.web.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tw.com.tradevan.dao.UserDao;
import tw.com.tradevan.domain.User;
import tw.com.tradevan.service.UserManager;

public class UserAction extends BaseCrudAction<User, String, UserDao, UserManager> {
	private static final long serialVersionUID = -5648499573250174891L;
	private static final Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	@Override
	public Logger getLogger() {
		return logger;
	}
}
