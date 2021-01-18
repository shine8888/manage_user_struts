package manageuser.action;

import java.awt.List;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport{
private static final long serialVersionUID = 1L;

private java.util.List<StudentBean> students=null;
private List selectStudent=null;

@Override
public String execute() throws Exception {
System.out.println("uuuuuuu");
java.util.List<StudentBean> students=new ArrayList<StudentBean>();
students.add(new StudentBean("John","1","B.Tech"));
students.add(new StudentBean("Jony","2","M.Tech"));
students.add(new StudentBean("Mark Voucher","3","B.Tech"));
students.add(new StudentBean("Sandy","4","B.Tech"));
students.add(new StudentBean("Sancy Decosta","5","MCA"));
students.add(new StudentBean("Rithus Johny","6","M.Tech"));
students.add(new StudentBean("Kotansy","7","MCA"));
students.add(new StudentBean("Rans Conhty","8","B.Tech"));
students.add(new StudentBean("Reithom","9","M.Tech"));
students.add(new StudentBean("Kathy Seri Kotaan","10","B.Tech"));
setStudents(students);
return SUCCESS;
}

public List getSelectStudent() {
return selectStudent;
}

public void setSelectStudent(List selectStudent) {
this.selectStudent = selectStudent;
}

public java.util.List<StudentBean> getStudents() {
return students;
}

public void setStudents(java.util.List<StudentBean> students) {
this.students = students;
}
}
