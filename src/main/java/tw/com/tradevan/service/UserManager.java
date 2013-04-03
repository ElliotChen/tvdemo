package tw.com.tradevan.service;

import tw.com.tradevan.core.service.EntityManager;
import tw.com.tradevan.dao.UserDao;
import tw.com.tradevan.domain.User;

public interface UserManager extends EntityManager<User, String, UserDao> {

}