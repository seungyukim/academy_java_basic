package school;

public class Employee extends Person {

	// 1. 매개 변수 선언부
	private String dept;
	
	// 2. 생성자 선언부
	Employee() {
		
	}
	
	Employee(String dept) {
		this.dept = dept;
	}
	
	Employee(String id, String name, int age, String dept) {
		super(id, name, age);
		// 부모 클래스의 생성자의 초기화 기능을 빌려오는
		// super() 키워드는 생성자 정의 첫줄에 1번만 가능
		this.dept = dept;
	}
	
	/** dept 접근자 */
	public String getDept() {
		return dept;
	}

	/** dept 수정자 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	// 3. 메소드 선언부
	@Override
	public String toString() {
		String EmployeeStr = String.format(", 부서:%s", dept);
		return "직원 정보[" + super.toString() + EmployeeStr + "]";
	}

	@Override
	public void print() {
		System.out.println("== 직원 ==");
		System.out.println(this);
	}
	
	@Override
	public String attend() {
		// 직원 [아이디] 가 출근하였습니다.
		String empStr = String.format("직원 [%s] (이)가 [%s]에 출근하였습니다.", this.getId(), this.getDept());
		return empStr;
	}
	
//	@Override
//	public String lesson() {
//		// 직원 [아이디] (이)가 과목[과목명] 수업을 하고 있습니다.s
//		return String.format("직원 [%s] (이)가 과목[%s] 수업을 하고 있습니다.", this.getId(), this.getDept());
//	}
		
}
