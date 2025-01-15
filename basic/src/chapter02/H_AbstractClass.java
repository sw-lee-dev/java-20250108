package chapter02;

// 추상 클래스 : 추상 메서드를 포함할 수 있는 클래스
// 추상 클래스 자체로는 인스턴스를 생성할 수 없음, 반드시 추상 클래스를 상속받은 하위 클래스로 인스턴스를 생성해야 함
// abstract class 추상 클래스명 { ... }

// 추상 메서드 : 선언부만 존재하고 구현부는 존재하지 않는 메서드
// 반드시 추상 클래스 내부(클래스 중에서만)에서만 선언할 수 있음
// 반드시 추상 클래스를 상속받은 하위 클래스에서 재정의(오버라이딩)하여 구현해야함
// abstract 반환 타입 추상 메서드명(매개변수, ...);

// abstract : 추상 클래스 혹은 추상 메서드를 정의하는 제어자
// abstract 가 붙은 클래스는 인스턴스를 생성할 수 없음
// abstract 가 붙은 메서드는 구현부를 가질수 없음

abstract class Occupation {
	int annual;
	int income;
	
	// 추상 클래스에서 생성자는 인스턴스를 생성하는 목적이 아님(인스턴스 생성이 불가능)
	// 하위 클래스에서 호출하여 사용할 수 있도록 제공하는 목적
	// 단, 기본 생성자가 없는 상태에서 생성자를 정의한다면 하위 클래스에 생성자 작성을 강요함 
	Occupation(int annual, int income) {
		this.annual = annual;
		this.income = income;
	}
	
	// 추상 메서드는 하위 클래스에서 오버라이딩을 강요함
	abstract void work();
	
	// 추상 클래스도 일반 메서드를 가질 수 있음
	// 일반 메서드는 오버라이딩을 강요하진 않음(할 수는 있음)
	void sleep() {
		System.out.println("잠을 잡니다.");
	}
}

// 추상 클래스도 단일 상속만 가능함
class Developer extends Occupation {
	String position;
	
	Developer(int annual, int income, String position) {
		super(annual, income);
		this.position = position;
	}
	
	void work() {
		System.out.println("프로그램을 개발합니다.");
	}
	
	void eat(String food) {
		System.out.println(food + "을 먹습니다.");
	}
}

class TourGuide extends Occupation {
	String country;
	
	TourGuide(int annual, int income, String country) {
		super(annual, income);
		this.country = country;
	}

	@Override
	void work() {
		System.out.println(country + "에서 관광을 설명합니다.");
	}
	
	@Override
	void sleep() {
		System.out.println("관광지에서 잠을 잡니다.");
	}
}

public class H_AbstractClass {

	public static void main(String[] args) {
		// Occupation occupation = new Occupation(10, 100); >> Cannot instantiate the type Occupation, 추상 클래스는 인스턴스 생성 X
		Developer developer = new Developer(10, 100, "백엔드"); // 다형성을 이용해 업캐스팅해서 인스턴스를 생성
		TourGuide tourGuide = new TourGuide(1, 20, "대한민국"); // 다형성을 이용해 업캐스팅해서 인스턴스를 생성
		developer.work();
		System.out.println(tourGuide.annual);
		tourGuide.sleep();
	}
}

// 제어자 조합
// static 이 붙은 변수 : 일반적으로 public + static + final (자주 사용)
// private + final 이 붙은 변수 : 생성자에서 필수로 초기화함을 의미
// private + final 이 붙은 메서드 : final 이 의미가 없음(접근 자체가 불가능하기 때문)
// private + abstract 가 붙은 메서드 : 있을 수 없음, 상충되는 관계, 불가능한 조합
// final + abstract 가 붙은 클래스와 메서드 : 있을 수 없음, 상충되는 관계, 불가능한 조합