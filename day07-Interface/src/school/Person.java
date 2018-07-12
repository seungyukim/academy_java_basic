package school;

/**
 * 일반적인 사람의 정보를 저장하는 클래스
 * -------------------------------
 * 캡슐화를 적용하여 멤버변수 필드를 모두 private 으로 선언
 * id   : String
 * name : String
 * age  : int
 * -------------------------------
 * 각 필드마다 접근자/수정자(getter/setter) 작성
 * @author PC38209
 *
 */
public abstract class Person implements Attendance{

	// 1. 멤버 변수 선언부
	private String id;
	private String name;
	private int age;
	
	// 2. 생성자 선언부
	// (1) 기본생성자 : 생성자 선언부를 완전히 생략하면
	//               자동으로 기본생성자 선언이 들어가짐
	/**
	 * 기본생성자
	 */
	Person() {
		
	}
	
	// (2) 매개변수를 받는 생성자가 선언되고
	//     기본 생성자 선언이 누락된 경우는 자동으로
	//     기본 생성자를 만들어주지 않음
	/**
	 * id 필드만을 매개변수로 받는 생성자
	 * @param id
	 */
	Person(String id) {
		this();
		this.id = id;
	}
	
	/**
	 * id, name 필드를 매개변수로 받는 생성자
	 * @param id
	 * @param name
	 */
	Person(String id, String name) {
		this(id);
		this.name = name;
	}
	
	/**
	 * 모든 필드를 매개변수로 받는 생성자
	 * @param id
	 * @param name
	 * @param age
	 */
	Person(String id, String name, int age) {
		this(id, name);
		this.age = age;
	}
	
	// 접근자 수정자 생성
	/** id 접근자 */
	public String getId() {
		return id;
	}

	/** id 수정자 */
	public void setId(String id) {
		this.id = id;
	}

	/** name 접근자 */
	public String getName() {
		return name;
	}

	/** name 수정자 */
	public void setName(String name) {
		this.name = name;
	}

	/** age 접근자 */
	public int getAge() {
		return age;
	}

	/** age 수정자 */
	public void setAge(int age) {
		this.age = age;
	}

	// 3. 메소드 선언부
	// toString() 재정의
	@Override
	public String toString() {
		return String.format("ID:%s, NAME:%s, AGE:%d", id, name, age);
	}
	
	
	// person 의 정보 출력 메소드
	/**
	 * Person 의 정보를 출력 : 메소드 header 만 있고 
	 * 구현부인 메소드 body 를 생략하면 추상메소드로
	 * 만들 수 있다.
	 */
	public abstract void print();
	
	
}
