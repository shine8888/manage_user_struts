package manageuser.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.beans.MstJapanBean;

public class MstJapanDao extends BaseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599580314574775270L;

	public ArrayList<MstJapanBean> getAllMstJapan() throws ClassNotFoundException, SQLException {
		// Khởi tạo list MstJapanEntity
		ArrayList<MstJapanBean> listMstJapan = new ArrayList<MstJapanBean>();
		try {
			// Mở kết nối
			openConnect();
			// Khởi tạo câu truy vấn sql
			StringBuilder sql = new StringBuilder();
			// Thêm câu truy vấn
			sql.append("Select code_level, name_level ");
			sql.append("From Mst_Japan;");
			// Khởi tạo câu lệnh PreparedStatement
			PreparedStatement pre = conn.prepareStatement(sql.toString());
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				// Khởi tạo đối tượng mst japan
				MstJapanBean mstJapan = new MstJapanBean();
				int i = 1;
				// Lấy các giá trị cho đối tượng mstJapan
				String codeLevel = rs.getString(i++);
				String nameLevel = rs.getString(i++);
				// Set các giá trị lấy được vào trong đối tượng mstJapan
				mstJapan.setCodeLevel(codeLevel);
				mstJapan.setNameLevel(nameLevel);
				// Thêm đối tượng mstJapan vào trong listMstJapan
				listMstJapan.add(mstJapan);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Thông báo lỗi
			throw e;
		} finally {
			closeConnect();
		}
		// trả về listMstJapan
		return listMstJapan;
	}
}
