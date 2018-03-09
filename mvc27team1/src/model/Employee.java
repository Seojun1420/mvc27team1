package model;

public class Employee {
	private int employee_no;
	private String employee_id;
	private String employee_pw;
	public int getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(int employee_no) {
		this.employee_no = employee_no;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_pw() {
		return employee_pw;
	}
	public void setEmployee_pw(String employee_pw) {
		this.employee_pw = employee_pw;
	}
	@Override
	public String toString() {
		return "Employee [employee_no=" + employee_no + ", employee_id=" + employee_id + ", employee_pw=" + employee_pw
				+ "]";
	}

	
	
}
