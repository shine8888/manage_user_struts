/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [ListUserController.java.java], [Mar 9, 2020] [Kiều Văn Quang]
 */
package manageuser.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.beans.MstGroupBean;
import manageuser.beans.UserInforBean;
import manageuser.common.Common;
import manageuser.constant.Constant;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.TblUserLogic;

/**
 * Class ListUserController thực hiện việc hiển thị list user khi tìm kiếm
 * 
 * @author Kiều Văn Quang
 */
public class ListUserAction extends ActionSupport {

	private static final long serialVersionUID = 6167313450665361319L;
	private String action, sortType, sortValue;
	private String fullName;
	private int pre, next;
	private int groupId, currentPage;
	private String urlSort, urlPaging;
	Common common = new Common();

	private HttpServletRequest request = ServletActionContext.getRequest();
	String url = "";
	StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
	String queryString = request.getQueryString();
	
	public String execute() throws Exception {

		TblUserLogic tblUserLogic = new TblUserLogic();
		MstGroupLogic groupLogic = new MstGroupLogic();
		try {
			List<UserInforBean> listUser = new ArrayList<UserInforBean>();
			List<Integer> listPaging = new ArrayList<Integer>();
			List<MstGroupBean> listGroup = groupLogic.getAllMstGroup();
			int offset = Constant.DEFAULT_OFFSET;
			int limit = Integer.parseInt(getText(Constant.LIMIT_RECORD));
			int limitPage = Integer.parseInt(getText(Constant.LIMIT_PAGE));
			String sortByFullName = Constant.SORT_ASC;
			String sortByCodeLevel = Constant.SORT_ASC;
			String sortByEndDate = Constant.SORT_DESC;

			if (sortType == null) {
				sortType = Constant.SORT_FULLNAME;
			}

			if (sortValue == null) {
				sortValue = Constant.DEFAUT_FULLNAME;
			}

			if (currentPage == 0) {
				currentPage = Constant.DEFAUT_CURRENT_PAGE;
			}

			if (fullName == null) {
				fullName = Constant.DEFAUT_FULLNAME;
			}

			if (action == null) {
				action = Constant.DEFAULT;
			}
			switch (action) {
			case Constant.SORT:
			case Constant.PAGING:
				if (Constant.SORT_FULLNAME.equals(sortType)) {
					sortByFullName = sortValue;
				}
				if (Constant.SORT_CODELEVEL.equals(sortType)) {
					sortByCodeLevel = sortValue;
				}
				if (Constant.SORT_ENDDATE.equals(sortType)) {
					sortByEndDate = sortValue;
				}
				break;
			case Constant.DEFAULT:
				break;
			}

			int totalRecord = tblUserLogic.getTotalUsers(groupId, fullName);
			if (totalRecord != 0) {
				int totalPage = tblUserLogic.getTotalPage(totalRecord, limit);
				if (currentPage > totalPage) {
					currentPage = totalPage;
				}
				offset = Common.getOffset(limit, currentPage);
				listUser = tblUserLogic.getListUser(offset, limit, groupId, fullName, sortType, sortByFullName,
						sortByCodeLevel, sortByEndDate);
				listPaging = tblUserLogic.getListPaging(totalRecord, limit, currentPage);
				if (listPaging != null) {
					if (currentPage > limitPage) {
						pre = listPaging.get(0) - limitPage;
					}
					if (listPaging.get(listPaging.size() - 1) < totalPage) {
						next = listPaging.get(0) + limitPage;
					}
				}
			}

			ServletActionContext.getRequest().setAttribute(Constant.LIST_USER, listUser);
			ServletActionContext.getRequest().setAttribute(Constant.LIST_GROUP, listGroup);
			ServletActionContext.getRequest().setAttribute(Constant.LIST_PAGING, listPaging);

			common.setSession(Constant.GROUP_ID, String.valueOf(groupId));
			common.setSession(Constant.FULL_NAME, fullName);
			common.setSession(Constant.CURRENT_PAGE, String.valueOf(currentPage));
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPRE() {
		return pre;
	}

	public void setPRE(int pRE) {
		pre = pRE;
	}

	public int getNEXT() {
		return next;
	}

	public void setNEXT(int next) {
		next = next;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}

	public String getUrlSort() {
		return urlSort;
	}

	public void setUrlSort(String urlSort) {
		this.urlSort = urlSort;
	}

	public String getUrlPaging() {
		return urlPaging;
	}

	public void setUrlPaging(String urlPaging) {
		this.urlPaging = urlPaging;
	}
}