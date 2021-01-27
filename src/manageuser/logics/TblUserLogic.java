package manageuser.logics;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import manageuser.beans.TblUserBean;
import manageuser.beans.UserInforBean;
import manageuser.common.Common;
import manageuser.constant.Constant;
import manageuser.dao.TblUserDao;


public class TblUserLogic extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TblUserDao tblUserDao = new TblUserDao();

	public boolean checkLogin(String loginName, String password)
			throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		boolean result = false;
		loginName = Common.replaceWildcard(loginName);
		String check = tblUserDao.getUserLogin(loginName, password);
		if (check.equals(loginName)) {
			return result=true;
		}
		return result;
	}

	public List<UserInforBean> getListUser(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws ClassNotFoundException, SQLException {
		List<UserInforBean> listUser = new ArrayList<UserInforBean>();
		fullName = Common.replaceWildcard(fullName);
		listUser = tblUserDao.getListUser(offset, limit, groupId, fullName, sortType, sortByFullName, sortByCodeLevel,
				sortByEndDate);
		return listUser;
	}

	public int getTotalUsers(int groupId, String fullName) throws ClassNotFoundException, SQLException {
		fullName = Common.replaceWildcard(fullName);
		int total = tblUserDao.getTotalUsers(groupId, fullName);
		return total;
	}

	public int getTotalPage(int totalRecord, int limit) {
		int totalPage = (int) Math.ceil((totalRecord * 1.0) / limit);
		return totalPage;
	}

	public List<Integer> getListPaging(int totalRecord, int limit, int currentPage) {
		List<Integer> listPaging = new ArrayList<Integer>();
		int totalPage = this.getTotalPage(totalRecord, limit);
		int limitPage = Integer.parseInt(getText(Constant.LIMIT_PAGE));

		int currentGroup = (int) Math.ceil(currentPage * 1.0 / limitPage);
		int minPageGroup = (currentGroup - 1) * limitPage + 1;
		int maxPageGroup = minPageGroup + limitPage - 1;
		if (maxPageGroup > totalPage) {
			maxPageGroup = totalPage;
		}
		if (maxPageGroup > totalPage) {
			maxPageGroup = totalPage;
		}
		for (int i = minPageGroup; i <= maxPageGroup; i++) {
			listPaging.add(i);
		}
		return listPaging;
	}
	
	public boolean checkExistLoginName(String loginName, int id) throws ClassNotFoundException, SQLException {
		// Khởi tạo biến check
		boolean check = false;
		// Khởi tạo đối tượng TblUserDao
		TblUserDao userDao = new TblUserDao();
		// Gán lại giá trị cho count
		TblUserBean user = userDao.getTblUserByLoginName(loginName, id);
		// Kiểm tra xem user có tồn tại hay không
		if (user != null) {
			// Trả về giá trị true
			return check = true;
		}
		// Trả về giá trị cho phương thức
		return check;
	}

	/**
	 * @see manageuser.logics.TblUserLogic#checkExistEmail(java.lang.String, int)
	 * 
	 */
	public boolean checkExistEmail(String email, int id) throws ClassNotFoundException, SQLException {
		// Khởi tạo biến check
		boolean check = false;
		// Khởi tạo đối tượng TblUserdao
		TblUserDao userDao = new TblUserDao();
		// Gán giá trị cho count
		TblUserBean user = userDao.getExistEmail(email, id);
		// Kiểm tra điều kiện nếu count khác 0
		if (user != null) {
			// Trả về giá trị true
			return check = true;
		}
		// Trả về giá trị cho phương thức
		return check;
	}
}
