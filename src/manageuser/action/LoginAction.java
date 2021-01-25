package manageuser.action;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.common.Common;
import manageuser.constant.Constant;
import manageuser.logics.TblUserLogic;


public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037016283515292615L;
	private String user;
	private String password;
	private String name;
	Common common = new Common();
	private TblUserLogic tbl = new TblUserLogic();
	


	public void validate() {
		if (null == user || "".equals(user.trim())) {
			addActionError(getText(Constant.ER001_LOGIN_NAME));
		}
		if (null == password || "".equals(password.trim())) {
			addActionError(getText(Constant.ER001_PASSWORD));
		}

	}
	
	public String execute() throws Exception {
		if (!tbl.checkLogin(user, password)) {
			addActionError(getText(Constant.ER016_LOGIN_NAME));
			return LOGIN;
		} else {
			common.setSession(Constant.LOGIN_NAME, user);
			return SUCCESS;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}