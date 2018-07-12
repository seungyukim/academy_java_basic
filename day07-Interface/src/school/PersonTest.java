package school;

/**
 * Person 과 상속관계인 Student 클래스를
 * 테스트하는 클래스이다.
 * @author PC38209
 *
 */
public class PersonTest {

	public static void main(String[] args) {

		// 1. 선언
		Person[] persons;
//		Person person;
//		Person student;
//		Person teacher;
//		Person employee;
		
		// 2. 초기화
		persons = new Person[3];
//		person = new Person("P01", "홍길동", 18);
		persons[0] = new Student("S02", "홍길동", 18, "도술");
		persons[1] = new Teacher("T03", "정약용", 25, "행정");
		persons[2] = new Employee("E04", "허균", 48, "문학예술지원부");
		
		// 3. 사용
		for (Person person: persons) {
			person.print();
		}
		
//		System.out.println(person);
//		System.out.println(student.toString());
//		System.out.println(teacher.toString());
//		System.out.println(employee.toString());
//		System.out.println("===========================================");
//		student.print();
//		teacher.print();
//		employee.print();

	}

}
