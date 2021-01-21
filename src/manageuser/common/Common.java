package manageuser.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class Common implements SessionAware{
	
	public SessionMap<String, Object> session;
	public Map<String, Object> sessionMap = ActionContext.getContext().getSession();
	
	public void setSession(String key, String value) {
		sessionMap.put(key, value);
	}

	public String getSession(String key) {
		String result = "";
		sessionMap.get(key);
		return result;
		
	}
	
	public void deleteSession(String key) {
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
	
}

