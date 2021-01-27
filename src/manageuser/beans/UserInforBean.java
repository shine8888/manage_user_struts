package manageuser.beans;

import java.util.List;

public class UserInforBean {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String fullName;
	private String email;
	private String tel;
	private String birthday;
	private String groupName;
	private int groupId;
	private String nameLevel;
	private String endDate;
	private String total;
	private String password;
	private String salt;
	private String fullNameKana;
	private String loginName;
	private String startDate;
	private String codeLevel;
	private List<String> listTime;
	private String confirmPassword;
	private List<Integer> listBirthday;
	private List<Integer> listStartDate;
	private List<Integer> listEndDate;
	private String score;
	private int detailUserJapanId;
	private String year, month, day;
	private String yearStart, monthStart, dayStart;
	private String yearEnd, monthEnd, dayEnd;
	public String getYearStart() {
		return yearStart;
	}

	public void setYearStart(String yearStart) {
		this.yearStart = yearStart;
	}

	public String getMonthStart() {
		return monthStart;
	}

	public void setMonthStart(String monthStart) {
		this.monthStart = monthStart;
	}

	public String getDayStart() {
		return dayStart;
	}

	public void setDayStart(String dayStart) {
		this.dayStart = dayStart;
	}

	public String getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}

	public String getMonthEnd() {
		return monthEnd;
	}

	public void setMonthEnd(String monthEnd) {
		this.monthEnd = monthEnd;
	}

	public String getDayEnd() {
		return dayEnd;
	}

	public void setDayEnd(String dayEnd) {
		this.dayEnd = dayEnd;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	// Khởi tạo Constructor 
	public UserInforBean() {
	}

	// Khởi tạo các phương thức getter, setter
	public int getDetailUserJapanId() {
		return detailUserJapanId;
	}

	public void setDetailUserJapanId(int detailUserJapanId) {
		this.detailUserJapanId = detailUserJapanId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public List<Integer> getListBirthday() {
		return listBirthday;
	}

	public void setListBirthday(List<Integer> listBirthday) {
		this.listBirthday = listBirthday;
	}

	public List<Integer> getListStartDate() {
		return listStartDate;
	}

	public void setListStartDate(List<Integer> listStartDate) {
		this.listStartDate = listStartDate;
	}

	public List<Integer> getListEndDate() {
		return listEndDate;
	}

	public void setListEndDate(List<Integer> listEndDate) {
		this.listEndDate = listEndDate;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<String> getListTime() {
		return listTime;
	}

	public void setListTime(List<String> listTime) {
		this.listTime = listTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getNameLevel() {
		return nameLevel;
	}

	public void setNameLevel(String nameLevel) {
		this.nameLevel = nameLevel;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFullNameKana() {
		return fullNameKana;
	}

	public void setFullNameKana(String fullNameKana) {
		this.fullNameKana = fullNameKana;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String beginDate) {
		this.startDate = beginDate;
	}

	public String getCodeLevel() {
		return codeLevel;
	}

	public void setCodeLevel(String codeLevel) {
		this.codeLevel = codeLevel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}