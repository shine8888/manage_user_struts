package manageuser.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.beans.TblDetailUserJapanBean;

public class TblDetailUserJapanDao extends BaseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3728781818704802535L;

	public boolean insertDetailUserJapan(TblDetailUserJapanBean user) throws ClassNotFoundException, SQLException {
		// Khởi tạo biến check
		boolean check = false;
		// Mở try
		try {
			// Kiểm tra xem conn có tồn tại hay không
			if (conn != null) {
				// Khởi tạo câu truy vấn
				StringBuilder sql = new StringBuilder();
				// Gán thêm giá trị cho câu truy vấn
				sql.append("Insert IGNORE Into tbl_detail_user_japan(user_id,code_level,start_date, end_date,total)");
				sql.append(" values(?,?,?,?,?);");
				// Khởi tạo câu lệnh preparedStatement
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				// Khởi tạo index
				int index = 1;
				// Truyền các giá trị vào câu preparedStatement để thực hiện câu truy vấn
				pre.setInt(index++, user.getUserId());
				pre.setString(index++, user.getCodeLevel());
				pre.setDate(index++, user.getStartDate());
				pre.setDate(index++, user.getEndDate());
				pre.setInt(index++, user.getTotal());
				pre.executeUpdate();
			}
			check = true;
			// Mở bắt lỗi
		} catch (SQLException e) {
			// Thông báo lỗi
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			String className = this.getClass().getName();
			System.out.println(className + ". " + methodName + ". Error : " + e.getMessage());
			throw e;
		}
		return check;
	}
}
