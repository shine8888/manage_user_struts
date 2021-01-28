package manageuser.logics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.beans.MstGroupBean;
import manageuser.dao.MstGroupDao;


public class MstGroupLogic {
	MstGroupDao groupDao = new MstGroupDao();

	public List<MstGroupBean> getAllMstGroup() throws SQLException {
		List<MstGroupBean> listMstGroup = new ArrayList<MstGroupBean>();
		listMstGroup = groupDao.getAllMstGroup();
		return listMstGroup;
	}
	
	
	
}
