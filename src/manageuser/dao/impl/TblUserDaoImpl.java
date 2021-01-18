/**
 * Copyright(C) [2020]  [Luvina Sotfware Company]
 * [TblUserDaoImpl.java], [Mar 9, 2020] [Kiều Văn Quang]
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblUserDao;
import manageuser.entities.TblUserEntity;
import manageuser.entities.UserInforEntity;


/**
 * Class TblUserDaoImpl thực hiện xử lý truy vấn với Database
 * 
 * @author Kiều Văn Quang
 *
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao{

	/**
	 * @throws Exception 
	 * @see manageuser.dao.TblUserDao#getListUsers(int, int, int, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * 
	 */
	
	public String getUserLogin(String loginName, String password) throws Exception{
		String check = "";
		try {
			// Mở kết nối DB
			open();
			// Kiểm tra xem kết nối có tồn tại hay không
			if (conn != null) {
				// Khởi tạo câu truy vấn sql
				StringBuilder sql = new StringBuilder("");
				sql.append("Select  u.login_name from tbl_user u ");
				sql.append("Where u.login_name = ? AND u.password = ?");
				// Kiểm tra điều kiện xem id có tồn tại hay không
				// Khởi tạo lệnh PrepareStatement
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				// truyền vào giá trị cho lệnh preparestatement
				int index = 1;
				pre.setString(index++, loginName);
				// Kiểm tra điều kiện khi id tồn tại thì thêm giá trị vào để thực thi
				// sql
				pre.setString(index++, password);
				// Khởi tạo resultset để lấy kết quả từ câu truy vấn
				ResultSet rs = pre.executeQuery();
				
				while (rs.next()) {
		            check = rs.getString(1);
		         }
				// Khởi tạo đối tượng user
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			// Đóng kết nối DB
			close();
			// Trả về giá trị cho phương thức
		}
		return check;
	}

	@Override
	public TblUserEntity getTblUserByUserName(String userName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserInforEntity> getListUsers(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByEndDate)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getListColumn() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalUser(int groupId, String fullName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TblUserEntity getTblUserByLoginName(String loginName, int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TblUserEntity getExistEmail(String email, int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(TblUserEntity user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TblUserEntity getTblUserById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInforEntity getUserInforById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUserInfor(TblUserEntity user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTblUser(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int checkExistToDeleteUser(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


}
