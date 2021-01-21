package manageuser.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.beans.MstGroupBean;



public class MstGroupDao extends BaseDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7784489310337528054L;
	
	@SuppressWarnings("finally")
	public List<MstGroupBean> getAllMstGroup() throws SQLException{
		List<MstGroupBean> listGroup = new ArrayList<MstGroupBean>();
		try {
			openConnect();
			if (conn != null) {
				String sql = "SELECT * FROM mst_group ORDER BY group_id";
//				sql.append("");
				PreparedStatement pre = conn.prepareStatement(sql.toString());
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					MstGroupBean mstGroupBean = new MstGroupBean();
					mstGroupBean.setGroupId(rs.getInt(1));
					mstGroupBean.setGroupName(rs.getString(2));
					listGroup.add(mstGroupBean);
				}
			}
		} catch (SQLException e) {
			String method= new Object() {}.getClass().getEnclosingMethod().getName();
			System.out.println(this.getClass().getName() + "." + method + ": " + e.getMessage());
			throw e;
		} finally {
			closeConnect();
			return listGroup;
		}
	}
	
	public MstGroupBean getMstGroupById(int groupId) throws SQLException, ClassNotFoundException{
		MstGroupBean mstGroup = new MstGroupBean();
		try {
			openConnect();
			String sql = "SELECT * FROM mst_group WHERE group_id = ?";
			PreparedStatement pre = conn.prepareStatement(sql.toString());
			int i = 0;
			pre.setInt(++i, groupId);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				mstGroup.setGroupId(rs.getInt("group_id"));
				mstGroup.setGroupName(rs.getString("group_name"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			String method= new Object() {}.getClass().getEnclosingMethod().getName();
			System.out.println(this.getClass().getName() + "." + method + ": " + e.getMessage());
			throw e;
		} finally {
			closeConnect();
		}
		return mstGroup;
	}
}
