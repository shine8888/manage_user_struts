package manageuser.action;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.dao.impl.TblUserDaoImpl;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037016283515292615L;
	private String user;
	private String password;
	private String name;
	private TblUserDaoImpl tbl = new TblUserDaoImpl();
	
	public void validate() {
	      if (user == null || user.trim().equals("")) {
	         addActionError("「画面項目名」を入力してください");
	         System.out.println(122345);
	      }
	      
	      if (password == null || password.trim().equals("")) {
	    	  addActionError("画面項目名」を入力してください");
		      }
	   }

	public String execute() {
		String ret = ERROR;
		try {
			String check = tbl.getUserLogin(user, password);
			if (check.equals(user)) {
				return ret = "success";
			} else {
				addActionError("「アカウント名」または「パスワード」は不正です。");
				return ret="input";
			}
		} catch (Exception e) {
		}

		return ret;
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