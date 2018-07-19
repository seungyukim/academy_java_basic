package mybatis.emp.vo;

public class Emp {

	private int empno;
	private String ename;
	private String job;
	private String hiredate;
	private double comm;
	private int mgr;
	private double sal;
	private int deptno;
	
	public Emp() {}
	
	public Emp(int empno, String ename, String job, String hiredate, double comm, int mgr, double sal, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.comm = comm;
		this.mgr = mgr;
		this.sal = sal;
		this.deptno = deptno;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "직원정보 [사번=" + empno + ", 이름=" + ename + ", 직무=" + job + ", 입사일=" + hiredate + ", 커미션=" + comm
				+ ", 매니저=" + mgr + ", 급여=" + sal + ", 부서번호=" + deptno + "]";
	}
	
	
}
