package manageuser.action;
/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [AddUserController.java], [Mar 9, 2020] [Kiều Văn Quang]
 */





import com.opensymphony.xwork2.ActionSupport;





/**
 * Class AddUserInputController dùng để xử lý thêm người dùng vào trong database
 * @author Kiều Văn Quang
 *
 */
public class AddUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int groupId;

	public String execute() {
		

		
		System.out.println("Quang");
		return SUCCESS;
	}
	
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
