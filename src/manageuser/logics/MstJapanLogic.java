package manageuser.logics;

import java.sql.SQLException;
import java.util.List;

import manageuser.beans.MstGroupBean;
import manageuser.beans.MstJapanBean;
import manageuser.dao.MstJapanDao;

public class MstJapanLogic {
	private MstJapanDao mstDao;

	public MstJapanLogic() {
		mstDao = new MstJapanDao();
	}

	public List<MstJapanBean> getAllMstJapan() {
		List<MstJapanBean> listJapan = null;
		try {
			listJapan = mstDao.getAllMstJapan();
		} catch (ClassNotFoundException | SQLException e) {
		}
		return listJapan;
	}
	
	public String getNameLevel(String codeLevel) {
		String nameLevel = "";
			List<MstJapanBean> list = getAllMstJapan();
			for (MstJapanBean mstJapanBean : list) {
				if(codeLevel.equals(mstJapanBean.getCodeLevel())) {
					nameLevel = mstJapanBean.getNameLevel();
				}
			}
			return nameLevel;
	}
	
}
