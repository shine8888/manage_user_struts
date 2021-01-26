/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [LogoutController.java], [Mar 9, 2020] [Kiều Văn Quang]
 */
package manageuser.action;


import com.opensymphony.xwork2.ActionSupport;

import manageuser.common.Common;
import manageuser.constant.Constant;


/**
 * Class LogoutController dùng để xử lý việc đăng xuất khỏi hệ thống
 * 
 * @author Kiều Văn Quang
 *
 */
public class LogoutAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		Common common = new Common();
		common.destroySession(Constant.LOGIN_NAME);
		return SUCCESS;
	}

}
