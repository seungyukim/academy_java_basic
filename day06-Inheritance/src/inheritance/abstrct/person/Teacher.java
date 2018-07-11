package inheritance.abstrct.person;

public class Teacher extends Person {

	// 1. 매개 변수 선언부
	String subject;
	
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
	
	
}
