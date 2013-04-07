package tw.com.tradevan.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder implements ApplicationContextAware {
	private static ApplicationContext CONTEXT = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		CONTEXT = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return CONTEXT;
	}
}
