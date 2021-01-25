package manageuser.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.beans.UserInforBean;
import manageuser.constant.Constant;


public class TblUserDao extends BaseDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5091769496276022749L;
	
	/**
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public String getUserLogin(String loginName, String password) throws SQLException, ClassNotFoundException{
		String check ="";
		try {
			openConnect();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT u.login_name, u.password ");
			sql.append("FROM tbl_user u ");
			sql.append("where u.login_name = ? ");
			sql.append("and u.password = ? ");
			PreparedStatement pre = conn.prepareStatement(sql.toString());
			int i = 0;
			pre.setString(++i, loginName);
			pre.setString(++i, password);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
	            check = rs.getString(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			// Đóng kết nối DB
			closeConnect();
			// Trả về giá trị cho phương thức
		}
		return check;
	}
	
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @param groupId
	 * @param fullName
	 * @param sortType
	 * @param sortByFullName
	 * @param sortByCodeLevel
	 * @param sortByEndDate
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<UserInforBean> getListUser(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws ClassNotFoundException, SQLException {
		List<UserInforBean> listUser = new ArrayList<UserInforBean>();
		try {
			openConnect();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append(
						"SELECT u.user_id, u.full_name, u.birthday, g.group_name, "
						+ "u.email, u.tel, mj.name_level, du.end_date, du.total ");
				sql.append("FROM tbl_user u ");
				sql.append("INNER JOIN mst_group g ");
				sql.append("ON g.group_id = u.group_id ");
				sql.append("LEFT JOIN tbl_detail_user_japan du ");
				sql.append("ON du.user_id = u.user_id ");
				sql.append("LEFT JOIN mst_japan mj ");
				sql.append("ON mj.code_level = du.code_level ");
				sql.append("where u.full_name like ? ");
				if (groupId != 0) {
					sql.append("AND g.group_id = ? ");
				}
				switch (sortType) {
				// TH sort theo full_name
				case Constant.SORT_FULLNAME:
					sql.append("ORDER BY u.full_name ").append(sortByFullName);
					sql.append(", mj.name_level ").append(sortByCodeLevel);
					sql.append(", du.end_date ").append(sortByEndDate);
					break;
				// TH sort theo code_level
				case Constant.SORT_CODELEVEL:
					sql.append("ORDER BY mj.name_level ").append(sortByCodeLevel);
					sql.append(", u.full_name ").append(sortByFullName);
					sql.append(", du.end_date ").append(sortByEndDate);
					break;
				// TH sort theo end_date
				case Constant.SORT_ENDDATE:
					sql.append("ORDER BY du.end_date ").append(sortByEndDate);
					sql.append(", u.full_name ").append(sortByFullName);
					sql.append(", mj.name_level ").append(sortByCodeLevel);
					break;
				}

				sql.append("\n LIMIT ? ");
				sql.append("\n OFFSET ? ");
				// Thao tác với DB
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				int i = 0;
				pre.setString(++i, "%" + fullName + "%");
				if (groupId != 0) {
					pre.setInt(++i, groupId);
				}
				pre.setInt(++i, limit);
				pre.setInt(++i, offset);
				// Thực thi câu lệnh
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					int count = 1;
					// Tạo đối tượng
					UserInforBean userInfo = new UserInforBean();
					// set các giá trị vào đối tượng
					userInfo.setUserId(rs.getInt(count++));
					userInfo.setFullName(rs.getString(count++));
					userInfo.setBirthday(rs.getString(count++));
					userInfo.setGroupName(rs.getString(count++));
					userInfo.setEmail(rs.getString(count++));
					userInfo.setTel(rs.getString(count++));
					userInfo.setNameLevel(rs.getString(count++));
					userInfo.setEndDate(rs.getString(count++));
					userInfo.setTotal(rs.getString(count++));
					listUser.add(userInfo);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			
			throw e;
		} finally {
			closeConnect();
			
		}
		return listUser;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param fullName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int getTotalUsers(int groupId, String fullName) throws ClassNotFoundException, SQLException {
		int total = 0;
		try {
			openConnect();
			if (conn != null) {
				StringBuilder sql = new StringBuilder();
				sql.append("SELECT COUNT(*) ");
				sql.append("FROM tbl_user u ");
				sql.append("INNER JOIN mst_group g ");
				sql.append("ON g.group_id = u.group_id ");
				sql.append("WHERE u.full_name like ? ");
				if (groupId != 0) {
					sql.append("AND u.group_id = ? ");
				}

				PreparedStatement pre;
				pre = conn.prepareStatement(sql.toString());
				int i = 0;
				pre.setString(++i, "%" + fullName + "%");
				if (groupId != 0) {
					pre.setInt(++i, groupId);
				}

				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					total = rs.getInt(1);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			closeConnect();
		}
		return total;
	}
}
