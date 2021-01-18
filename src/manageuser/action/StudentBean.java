package manageuser.action;

import java.io.Serializable;

public class StudentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -947424692301875895L;
	String studentName;
	String studentRoll;
	String studentCourse;
	
	StudentBean(){
		
	}
	StudentBean(String name, String roll, String course){
		this.studentName=name;
		this.studentRoll=roll;
		this.studentCourse=course;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(String studentRoll) {
		this.studentRoll = studentRoll;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}
	
}