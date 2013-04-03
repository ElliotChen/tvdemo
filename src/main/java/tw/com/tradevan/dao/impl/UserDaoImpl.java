package tw.com.tradevan.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import tw.com.tradevan.core.dao.impl.AbstractBaseDao;
import tw.com.tradevan.dao.UserDao;
import tw.com.tradevan.domain.User;
@Repository
public class UserDaoImpl extends AbstractBaseDao<User, String> implements UserDao{
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public Logger getLogger() {
		return logger;
	}

}
