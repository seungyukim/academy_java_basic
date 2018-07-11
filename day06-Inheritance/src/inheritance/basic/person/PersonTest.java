package inheritance.basic.person;

/**
 * Person 과 상속관계인 Student 클래스를
 * 테스트하는 클래스이다.
 * @author PC38209
 *
 */
public class PersonTest {

	public static void main(String[] args) {

		// 1. 선언
		Person person;
		Student student;
		Teacher teacher;
		Employee employee;
		
		// 2. 초기화
		person = new Person("P01", "홍길동", 18);
		student = new Student("S02", "홍길동", 18, "도술");
		teacher = new Teacher("T03", "정약용", 25, "행정");
		employee = new Employee("E04", "허균", 48, "문학예술지원부");
		
		// 3. 사용
		System.out.println(person);
		System.out.println(student);
		System.out.println(teacher);
		System.out.println(employee);
		
	}

}
