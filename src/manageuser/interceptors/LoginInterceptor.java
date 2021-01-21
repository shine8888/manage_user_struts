/**
 * Copyright (C) Luvina Development
 */
package manageuser.interceptors;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import manageuser.action.LoginAction;
import manageuser.common.Common;
import manageuser.constant.Constant;


/**
 * @author kieuvanquang
 *
 */
public class LoginInterceptor extends AbstractInterceptor{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4009050561119814970L;

	Common common = new Common();
	
	private static final Log log = LogFactory.getLog(LoginInterceptor.class);

	public void init() {
		log.info("Intializing LoginInterceptor");
	}

	public void destroy() {
	}
	
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		String user = (String) session.get(Constant.LOGIN_NAME);
		if (user == null) {
			if (invocation.getAction().getClass().equals(LoginAction.class)) {
				return invocation.invoke();
			}
			return "login";
		} else {
			return invocation.invoke();
		}
	}
}
