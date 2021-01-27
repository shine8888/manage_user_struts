package manageuser.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import manageuser.beans.MstJapanBean;
import manageuser.constant.Constant;
import manageuser.logics.MstJapanLogic;

public class Common implements SessionAware{
	public SessionMap<String, Object> session;
	public Map<String, Object> sessionMap = ActionContext.getContext().getSession();
	
	public void setSession(String key, Object value) {
		sessionMap.put(key, value);
	}

	public String getSession(String key) {
		String result = "";
		sessionMap.get(key);
		return result;
		
	}
	
	public void destroySession(String key) {
		if (null != sessionMap) {
			sessionMap.remove(key);
		}
	}

	public static String encodePass(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] mesageDigest = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mesageDigest.length; i++) {
			sb.append(Integer.toString((mesageDigest[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public static String replaceWildcard(String str) {
		str = str.replace("%", "\\%");
		str = str.replace("_", "\\_");
		return str;
	}
	
	public static boolean comperaString(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}
		return false;
	}
	
	public static int getOffset(int limit, int currentPage) {
		int offset = (currentPage - 1) * limit;
		return offset;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static List<Integer> getListYear(int beginYear, int endYear) {
		// Khởi tạo một listYear với kiểu dữ liệu là Integer
		List<Integer> listYear = new ArrayList<Integer>();
		// Khởi chạy vòng lặp để thêm giá trị vào mảng listYear
		for (int i = beginYear; i <= endYear; i++) {
			// Thêm giá trị
			listYear.add(i);
		}
		// Trả về mảng giá trị listYear
		return listYear;

	}
	
	public static int getYearNow() {
		// Khởi tạo hàm Date
		Date date = new Date();
		// Lấy giá trị cho năm hiện tại
		int year = date.getYear() + 1900;
		// Trả về năm hiện tại
		return year;
	}
	
	public static List<Integer> getListMonth() {
		// Khởi tạo một listMonth với kiểu dữ liệu là Integer
		List<Integer> listMonth = new ArrayList<Integer>();
		// Khởi chạy vòng lặp để thêm giá trị vào mảng listMonth
		for (int i = 1; i <= 12; i++) {
			// Thêm giá trị
			listMonth.add(i);
		}
		// Trả về mảng giá trị listMonth
		return listMonth;
	}
	
	public static List<Integer> getListDay() {
		// Khởi tạo một List Day
		List<Integer> listDay = new ArrayList<Integer>();
		// Khởi chạy vòng for để thêm giá trị vào listDay
		for (int i = 1; i <= 31; i++) {
			// Thêm giá trị cho listDay
			listDay.add(i);
		}
		// Trả về giá trị cho listDay
		return listDay;
	}
	
	public static List<Integer> getDateNow() {
		// Khởi tạo listDateNow
		List<Integer> listDateNow = new ArrayList<Integer>();
		Date dNow = new Date();
		listDateNow.add(dNow.getYear()+1900);
		listDateNow.add(dNow.getMonth()+1);
		listDateNow.add(dNow.getDate());
		// Trả về listDateNow
		return listDateNow;
	}
	
	public void setDataLogic() throws ClassNotFoundException, SQLException {
		// Khởi tạo các đối tượng mstGroup, mstJapan
		MstJapanLogic mstJapan = new MstJapanLogic();

		// Khởi tạo các listMstGroup, listMstGroupName
		// Khởi tạo listMstJapan
		List<MstJapanBean> listMstJapan = mstJapan.getAllMstJapan();

		// Khởi tạo và lấy list các giá trị cho các ô selectbox Năm/Tháng/Ngày
		ArrayList<Integer> listYearEndDate = (ArrayList<Integer>) Common.getListYear(Constant.YEAR_BEGINING,
				Constant.YEAR_ENDDATE);
		ArrayList<Integer> listYear = (ArrayList<Integer>) Common.getListYear(Constant.YEAR_BEGINING, Constant.YEAR_END);
		ArrayList<Integer> listMonth = (ArrayList<Integer>) Common.getListMonth();
		ArrayList<Integer> listDay = (ArrayList<Integer>) Common.getListDay();
		List<Integer> listDateNow = getDateNow();

		// Gán các list lên request
		this.setSession("year", listYear);
		this.setSession("listMstJapan", listMstJapan);
		this.setSession("listYear", listYearEndDate);
		this.setSession("listMonth", listMonth);
		this.setSession("listDay", listDay);
		this.setSession("datenow", listDateNow);

	}
	
}

