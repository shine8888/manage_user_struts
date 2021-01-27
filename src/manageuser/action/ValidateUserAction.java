package manageuser.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.beans.UserInforBean;
import manageuser.common.Common;
import manageuser.validate.GeneralValidate;

public class ValidateUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7967865863525366574L;
	private UserInforBean userInfor;
	private int groupId;
	GeneralValidate val = new GeneralValidate();
	Common common = new Common();

	public void validate() {
		userInfor  = new UserInforBean();
		List<String> listError = val.validateUser(userInfor);
//		for (String error : listError) {
//			addActionError(error);
//		}
		System.out.println(userInfor.getGroupId());
		common.setSession("userInfor", userInfor);
	}



	public UserInforBean getUser() {
		return userInfor;
	}

	public void setUser(UserInforBean userInfor) {
		this.userInfor = userInfor;
	}

}
