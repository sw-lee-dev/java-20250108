package chapter02;

// 생성자(Constructor) : 클래스의 인스턴스가 생성되는 순간에 호출되는 메서드
// 클래스와 같은 이름을 가짐, 반환 타입이 존재하지 않음(무조건 주소가 들어가는것이기 때문이라고 생각하라)
// 클래스명(매개변수, ...) { 인스턴스가 생성될때 수행할 작업 }
class Human1 {
	String name;
	int age;
	String gender;
	
	// final 로 선언된 인스턴스 변수는 생성자에서 반드시 초기화해야함
	// 즉, 필수값(required)이 된다.
	final String ADDRESS;
	
	int[] numbers; // ㅁ. 참조형 인스턴스 변수
	
	// ㄷ. 만약 다른 생성자(매개변수가 존재하는 생성자)만 존재한다면 기본 생성자는 자동으로 생성되지 않음
	Human1() {
		// ㅂ. this() : 해당 클래스의 다른 생성자를 호출하는 키워드
		// 반드시 생성자에서만 사용가능, 생성자의 제일 첫 구문으로 들어와야함
		this("홍길동"); // 에러내용 : Constructor call must be the first statement in a constructor >> 생성자에서 다른 생성자를 호출하려면 반드시 제일 상단에 위치해야함
		
		// ㄱ. 생성자의 목적
		// 1. 인스턴스를 생성할 때 특정 작업을 수행하고 싶을 때
		System.out.println("Human1의 인스턴스가 생성됩니다.");
		
		// 2. *인스턴스를 생성과 동시에 인스턴스 변수를 초기화하고 싶을 때*
		// ㄴ. 의존성을 내부에서 주입하는 행위(클래스를 작성하는 순간에 발생) / 의존성 역전 원칙을 위배 >> 이것을 해결하기 위해서 오버로딩을 이용해 인스턴스를 생성함과 동시에 값을 넣도록 해줌
		name = "홍길동"; // ㄴ. 하나라도 문제가 생기면 인스턴스가 생성되지 않기 때문에 주의
		age = 20;
		gender = "남";
		// ADDRESS = "부산";
	}
	
	Human1(String name) {
		// ㅂ. this : 현재 자기자신의 인스턴스를 지칭하는 키워드(클래스 자기자신임)
		// 인스턴스 변수나 인스턴스 메서드를 정확히(명확하게) 지칭할 때 사용됨
		this.name = name; // this.name = 인스턴스 변수를 지칭 / name = 매개변수를 지칭
		age = 20;
		gender = "남";
		ADDRESS = "부산";
	}
	
	Human1(String name1, int age1, String gender1) {
		// ㄴ. 의존성을 모두 외부에서 주입하는 행위
		name = name1;
		age = age1;
		gender = gender1;
		ADDRESS = "부산";
		numbers = new int[] {1, 2, 3}; // ㅁ. 참조형이라 주소가 복사됨
	}
	
	Human1(Human1 human1) {
		name = human1.name;
		age = human1.age;
		gender = human1.gender;
		ADDRESS = human1.ADDRESS;
		numbers = human1.numbers; // ㅁ. 주소가 복사됨
	}
}

public class D_Constructor {

	public static void main(String[] args) {
		
		// ㄷ. 만약 클래스에 생성자를 정의하지 않으면 컴파일러가 자동으로 기본 생성자를 제공함(기본 생성자 : 인스턴스만 만드는 행위만 제공)
		Human1 human1 = new Human1();
		human1.name = "이성계";
		human1.age = 60;
		human1.gender = "남";
		
		Human1 human2 = new Human1();
		System.out.println(human2.name);
		
		Human1 human3 = new Human1("이성계");
		System.out.println(human3.name);
		
		Human1 human4 = new Human1("이방과", 30, "여");
		System.out.println(human4.name);
		System.out.println(human4.age);
		System.out.println(human4.gender);
		
		// ㄹ. 주소만 복사되는 형태 (독립적이지 않음)
		Human1 human5 = human4;
		// ㄹ. 새로운 주소를 생성해서 값을 복사하는 형태 (독립적임)
		Human1 human6 = new Human1(human4);
		
		human4.numbers[0] = 99; // ㅁ. 주소가 동일하기 때문에 human4 나 human6 나 같은 주소를 바라보고 있다
		System.out.println(human4.numbers[0]);
		System.out.println(human5.numbers[0]);
		System.out.println(human6.numbers[0]); // ㅁ. 얕은 복사
		
	}
}