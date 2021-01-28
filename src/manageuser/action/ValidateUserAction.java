package manageuser.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.beans.UserInforBean;
import manageuser.common.Common;
import manageuser.logics.MstJapanLogic;
import manageuser.validate.GeneralValidate;

public class ValidateUserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7967865863525366574L;
	private UserInforBean userInfor = new UserInforBean();
	GeneralValidate val = new GeneralValidate();
	MstJapanLogic mstLogic = new MstJapanLogic();
	Common common = new Common();

	public UserInforBean getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInforBean userInfor) {
		this.userInfor = userInfor;
	}

	@Override
	public String execute() throws Exception {
		if ("N0".equals(userInfor.getCodeLevel())) {
			userInfor.setNameLevel(null);
		}
		userInfor.setNameLevel(mstLogic.getNameLevel(userInfor.getCodeLevel()));
		common.setSession("user", userInfor);
		return SUCCESS;
	}

	public void validate() {
		String time1 = userInfor.getYear() + "/" + userInfor.getMonth() + "/" + userInfor.getDay();
		String time2 = userInfor.getYearStart() + "/" + userInfor.getMonthStart() + "/" + userInfor.getDayStart();
		String time3 = userInfor.getYearEnd() + "/" + userInfor.getMonthEnd() + "/" + userInfor.getDayEnd();
		List<String> list = new ArrayList<String>();
		list.add(time1);
		if ("0/0/0".equals(time2) || "0/0/0".equals(time3)) {
			time2 = null;
			time3 = null;
		}
		list.add(time2);
		list.add(time3);
		userInfor.setListTime(list);
		List<String> listError = val.validateUser(userInfor, userInfor.getUserId());
		for (String error : listError) {
			addActionError(error);
		}
		common.setSession("userInfor", userInfor);
	}

}
