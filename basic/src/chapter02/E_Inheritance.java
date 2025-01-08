package chapter02;

// 상속 : 객체지향 프로그래밍의 특성 중 하나
// 원래 존재하던 클래스를 '확장'하여 재사용할 수 있도록 하는 것(추가 수정같은 의미)
// 코드의 중복을 제거하여 코드 재사용성, 유지 보수성, 확장성을 높일 수 있음
// extends 키워드를 사용

// class SubClass extends SuperClass { ... }
class Human {
	String name;
	int age;
	
	Human() {}
	
	// 부모 클래스의 생성자는 상속되지 않음
	Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void sleep() {
		System.out.println(name + "이 잠을 잔다");
	}
	
	final void eat() {
		System.out.println("밥을 먹습니다.");
	}
}

class Korean extends Human {
	static String country = "대한민국";

	@Override
	void sleep() {
		System.out.println("01시에 잠을 잔다");
	}
}

// Java 에서는 단일 상속만 지원
// 다중 상속에서 발생할 수 있는 다이아몬드 문제가 발생하지 않도록 하기 위함
// 다이아몬드 문제 : 다중 상속으로 인해 동일한 이름의 메서드를 상속받은 상태에서 어떤 메서드를 선택해야 할지 모호해지는 문제
// 1. 인터페이스를 사용하여 다중 상속 효과를 볼 수 있음
// 2. 중첩 상속을 사용하여 다중 상속 효과를 볼 수 있음
class Firefighter extends Korean/*, Human >> 다중 상속 문제가 발생*/ {
//	String name; 눈에 보이진 않지만 부모 클래스에 있기 때문에 같이 가지고 있음
//	int age; 눈에 보이진 않지만 부모 클래스에 있기 때문에 같이 가지고 있음
	String position;
	
//	void sleep() { 눈에 보이진 않지만 부모 클래스에 있기 때문에 같이 가지고 있음
//		System.out.println(name + "이 잠을 잔다");
//	}
	
	// Human 클래스에서 상속받은 sleep 메서드를 오버로딩한 것 >> 다형성 적용
	void sleep(int time) {
		System.out.println(name + "이 " + time + "시에 잠을 잔다");
	}
	
	void firefight() {
		System.out.println("소방활동을 한다");
	}
}

class Police extends Human {
	String rank;
	
	Police() {
		// super() : 부모 클래스의 생성자를 지칭하는 키워드
		// 제일 첫 구문에 위치해야함
		super("이향", 32);
		// super : 부모 클래스를 지칭하는 키워드
//		super.name = "이향";
//		age = 32;
		rank = "경감";	
	}
	
	void patrol() {
		System.out.println("순찰을 한다");
	}
}

// Java 의 모든 클래스는 Object 클래스를 최상위 클래스로 상속받아 사용함

class SalesMan extends Human {
	int sales;
	
	void sale(int amount) {
		sales += amount;
	}
	// 오버라이딩 (Overriding) : 하위 클래스에서 상위 클래스의 메서드를 '재정의' 하는 것
	// 규칙
	// 1. 상위 클래스에서 선언된 메서드와 이름, 매개변수 조합, 반환 타입이 모두 같아야함
	// @Override : 컴파일러에게 현재 작업이 오버라이딩 작업임을 알려줌
	@Override
	void sleep() {
		// 오버라이딩을 통해서 코드의 유연성을 증가시킬수 있음 >> 다형성의 일부
		System.out.println("영업 사원이 잠을 잔다.");
		// 오버라이딩을 통해서 코드의 재사용성을 증가시킬수 있음
		super.sleep();
		// System.out.println(name + "이 잠을 잔다");
	}
	
	// 2. 상위 클래스에서 선언된 메서드가 final 로 선언되면 재정의가 불가능
	//	void eat() {
	//		
	//	}
	// 3. 좁은 의미의 접근 제어자로는 상속 불가능
}

final class FinalSuper {
	int a;
}

// final 로 정의된 클래스는 상속받을 수 없음. 즉, FinalSuper 클래스는 있는 그대로 쓰도록 지정한 것
//class FinalSub extends FinalSuper {
//	
//}

public class E_Inheritance {

	public static void main(String[] args) {
		
		Firefighter firefighter = new Firefighter();
		firefighter.name = "이도";
		System.out.println(firefighter.name);
		
		Police police = new Police();
		police.sleep();
		firefighter.sleep();
		
		SalesMan salesMan = new SalesMan();
		salesMan.sleep();		
	}

}