package manageuser.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.beans.TblUserBean;
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
	
	@SuppressWarnings("finally")
	public TblUserBean getExistEmail(String email, int id) throws ClassNotFoundException, SQLException {
		// Khởi tạo total
		TblUserBean user = null;
		// Mở try
		try {
			// Mở kết nối DB
			openConnect();
			// Kiểm tra xem kết nối có tồn tại hay không
			if (conn != null) {
				// Khởi tạo câu truy vấn sql
				StringBuilder sql = new StringBuilder("");
				sql.append("Select u.email from tbl_user u ");
				sql.append("Where u.email = ? ");
				if (id != 0) {
					sql.append("and u.user_id = ? ;");
				}
				// Khởi tạo lệnh PrepareStatement
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				// truyền vào giá trị cho lệnh preparestatement
				int index = 1;
				pre.setString(index++, email);
				if (id != 0) {
					pre.setInt(index++, id);
				}
				// Khởi tạo resultset để lấy kết quả từ câu truy vấn
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					user = new TblUserBean();
					user.setEmail(rs.getString("email"));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// Ném lỗi đi cho phương thức khác gọi đến nhận biết
			throw e;
		} finally {
			// Đóng kết nối DB
			closeConnect();
			// Trả về giá trị cho phương thức
			return user;
		}
	}
	
	@SuppressWarnings("finally")
	public TblUserBean getTblUserByLoginName(String loginName, int id) throws ClassNotFoundException, SQLException {
		// Khởi tạo total
		TblUserBean user = null;
		// Mở try
		try {
			// Mở kết nối DB
			openConnect();
			// Kiểm tra xem kết nối có tồn tại hay không
			if (conn != null) {
				// Khởi tạo câu truy vấn sql
				StringBuilder sql = new StringBuilder("");
				sql.append("Select  u.login_name, u.user_id from tbl_user u ");
				sql.append("Where u.login_name = ? ");
				// Kiểm tra điều kiện xem id có tồn tại hay không
				if (id > 0) {
					sql.append("And u.user_id = ?;");
				}
				// Khởi tạo lệnh PrepareStatement
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				// truyền vào giá trị cho lệnh preparestatement
				int index = 1;
				pre.setString(index++, loginName);
				// Kiểm tra điều kiện khi id tồn tại thì thêm giá trị vào để thực thi
				// sql
				if (id > 0) {
					pre.setInt(index++, id);
				}
				// Khởi tạo resultset để lấy kết quả từ câu truy vấn
				ResultSet rs = pre.executeQuery();
				// Khởi tạo đối tượng user
				while (rs.next()) {
					user = new TblUserBean();
					user.setLoginName(rs.getString("login_name"));
					user.setUserId(rs.getInt("user_id"));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// Ném lỗi đi cho phương thức khác gọi đến nhận biết
			throw e;
		} finally {
			// Đóng kết nối DB
			closeConnect();
			// Trả về giá trị cho phương thức
			return user;
		}
	}

	
	public int insertUser(TblUserBean user) throws ClassNotFoundException, SQLException {
		// Khởi tạo giá trị id
		int id = 0;
		// Mở bắt lỗi
		try {
			// Kiểm tra xem kết nối có tồn tại hay không
			if (conn != null) {
				// Tạo mảng chứa tên cột là user_id của bảng Tbl_User
				String columnNames[] = new String[] { "user_id" };
				// Khởi tạo câu sql
				StringBuilder sql = new StringBuilder();
				// Gán các giá trị cho câu sql
				sql.append("Insert IGNORE Into Tbl_user(group_id, login_name, pass, full_name, ");
				sql.append("full_name_kana, email, tel, birthday, rule, salt)");
				sql.append(" values(?,?,?,?,?,?,?,?,?,?);");
				// Khởi tạo câu lệnh PreparedStatement
				PreparedStatement pre = conn.prepareStatement(sql.toString(), columnNames);
				// Khởi tạo index giá trị bằng 1
				int index = 1;
				// Truyền các giá trị vào câu lệnh preparedStatement để thực hiện truy vấn
				pre.setInt(index++, user.getGroupId());
				pre.setString(index++, user.getLoginName());
				pre.setString(index++, user.getPassword());
				pre.setString(index++, user.getFullName());
				pre.setString(index++, user.getFullNameKana());
				pre.setString(index++, user.getEmail());
				pre.setString(index++, user.getTel());
				pre.setDate(index++, (Date) user.getBirthday());
				pre.setInt(index++, user.getRule());
				pre.setString(index++, user.getSalt());
				// Kiểm tra sau khi thực hiện câu truy vấn
				pre.execute();
				ResultSet rs = pre.getGeneratedKeys();
				if (rs.next()) {
					id = rs.getInt(1);
				}
			}
			// Mở bắt lỗi
		} catch (Exception e) {
			// Thông báo lỗi
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			String className = this.getClass().getName();
			System.out.println(className + ". " + methodName + ". Error : " + e.getMessage());
			// Ném lỗi
			throw e;
		}
		// Trả về giá trị cho phương thức
		return id;
	}
}
