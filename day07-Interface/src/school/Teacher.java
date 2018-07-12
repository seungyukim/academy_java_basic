package school;

public class Teacher extends Person implements Lesson {

	// 1. 매개 변수 선언부
	private String subject;
	
	// 2. 생성자 선언부
	Teacher() {
		
	}
	
	Teacher(String subject) {
		this.subject = subject;
	}
	
	Teacher(String id, String name, int age, String subject) {
		super(id, name, age);
		// 부모 클래스의 생성자의 초기화 기능을 빌려오는
		// super() 키워드는 생성자 정의 첫줄에 1번만 가능
		this.subject = subject;
	}
	
	/** subject 접근자 */
	public String getSubject() {
		return subject;
	}

	/** subject 수정자 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	// 3. 메소드 선언부
	@Override
	public String toString() {
		String TeacherStr = String.format(", 과목:%s", subject);
		return "교수 정보[" + super.toString() + TeacherStr + "]";
	}
	
	@Override
	public void print() {
		System.out.println("== 교수 ==");
		System.out.println(this);
	}
	
	@Override
	public String attend() {
		// 교사 [아이디] 가 출근하였습니다.
		String tchStr = String.format("교사 [%s] (이)가 출근하였습니다.", this.getId());
		return tchStr;
	}
	
	@Override
	public String lesson() {
		// 교사 [아이디] (이)가 과목[과목명] 수업을 하고 있습니다.
		return String.format("교사 [%s] (이)가 과목[%s] 수업을 하고 있습니다.", this.getId(), this.getSubject());
	}
	
}
