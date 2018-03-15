package model;

public class EmployeeAddr {
	private int employAddrNo;
	private int employNo;
	private String address;
	public int getEmployAddrNo() {
		return employAddrNo;
	}
	public void setEmployAddrNo(int employAddrNo) {
		this.employAddrNo = employAddrNo;
	}
	public int getEmployNo() {
		return employNo;
	}
	public void setEmployNo(int employNo) {
		this.employNo = employNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeAddr [employAddrNo=" + employAddrNo + ", employNo=" + employNo + ", address=" + address + "]";
	}
	
	
}
