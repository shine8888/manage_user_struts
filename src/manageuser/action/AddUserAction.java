package manageuser.action;
/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [AddUserController.java], [Mar 9, 2020] [Kiều Văn Quang]
 */





import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.beans.UserInforBean;
import manageuser.common.Common;
import manageuser.validate.GeneralValidate;





/**
 * Class AddUserInputController dùng để xử lý thêm người dùng vào trong database
 * @author Kiều Văn Quang
 *
 */
public class AddUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	GeneralValidate val = new GeneralValidate();
	Common common = new Common();
	private UserInforBean userInfor;

	public String execute() {

		try {
			common.setDataLogic();
		} catch (ClassNotFoundException |SQLException e) {
			
		}
		return SUCCESS;
	}
	
	public UserInforBean getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInforBean userInfor) {
		this.userInfor = userInfor;
	}
	
	
}
