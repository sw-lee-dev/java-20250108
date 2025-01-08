package chapter03;

import java.util.ArrayList;
import java.util.List;

// *제너릭* : 클래스나 메서드에서 사용할 데이터 타입을 외부에서 지정하는 방법 (실무에서 굉장히 많이 쓰임!!)

// Test1, Test2, Test3의 문제점(데이터 타입을 명시)
// 1. 코드 중복 발생 - 유지 보수성 및 개발 속도를 낮춤
// 2. 실사용의 불편 - 사용시 코드가 복잡해짐
class Test1 {
	String subject;
	int score;
}

class Test2 {
	String subject;
	double score;
}

class Test3 {
	String subject;
	char score;
}

// Test4의 문제점(최상위 클래스 사용으로 코드 중복을 최소화)
// 타입의 안전성을 낮춤 >> 컴파일 언어의 장점을 무산시킴
class Test4 {
	String subject;
	Object score;
}

// *제너릭 클래스 : 클래스 내부에 있는 데이터 타입을 컴파일 시에 결정하는 클래스
// class 클래스명<매개타입> {}
class Test5<T/*SCORE 도 가능*/> {
	String subject;
	T score;
}

class SuperClass {}
class MyClass extends SuperClass {}
class SubClass extends MyClass {}

// *제한된 매개타입 - T extends 클래스명 : 특정 클래스 혹은 특정 클래스를 상속한 클래스만 제너릭으로 지정할 수 있도록 제한
class ExtendsClass<T extends MyClass> {
	T variable;
}

public class F_Generic {
	
	// *제너릭 메서드 : 해당 메서드의 매개변수의 타입이나 반환 타입을 컴파일 시에 결정하고자 할 때 사용
	// [제어자...] <매개타입> 반환 타입 메서드명 ( 매개변수, ... ) { ... }
	static <T> void genericMethod(List<T> arg) {
		for(T item : arg) {
			
		}
	}

	public static void main(String[] args) {
		
		List<Test4> tests = new ArrayList<>();
		
		Test4 test1 = new Test4();
		test1.subject = "국어";
		test1.score = "우수";
		tests.add(test1);
		
		Test4 test2 = new Test4();
		test2.subject = "수학";
		test2.score = 100;
		tests.add(test2);
		
//		for(Test4 test : tests) {
//			? score = test.score; >> 무슨 타입으로 받을 것인가?
//		}
		
		// Object 타입으로 지정하면 모든 타입을 받을 순 있지만 사용시 타입을 지정함에 있어서 안전성이 떨어짐
//		int score = (int) tests.get(0).score;
		
		// 제너릭으로 지정하면 컴파일 시 타입을 결정하여 원하는 형태의 데이터 타입으로 사용할 수 있음
		// *제너릭의 타입을 전달할 땐 반드시 참조형 데이터 타입이어야 함*
		Test5<Integer> instance1 = new Test5<>(); // <Integer> 에 <int> 는 안됨
//		instance1.score = "우수"; >> 컴파일 에러 발생 : 지정 타입 Integer
		instance1.score = 100;
		
		// extends 키워드로 제한을 걸어둔 매개타입은 해당 클래스 혹은 하위 클래스만 제너릭으로 사용할 수 있음
		ExtendsClass<MyClass> instance2;
		ExtendsClass<SubClass> instance3;
//		ExtendsClass<SuperClass> instance4; >> 사용 X
//		ExtendsClass<String> instance5; >> 사용 X
		
		// ? 와일드카드 제너릭
		Test5<String> instance6 = new Test5<>();
		instance6.score = "우수";
		wildcardMethod(instance6);
		
		Test5<Integer> instance7 = new Test5<>();
		instance7.score = 100;
		wildcardMethod(instance7);
		
		List<SuperClass> superList = new ArrayList<>();
		List<MyClass> myList = new ArrayList<>();
		List<SubClass> subList = new ArrayList<>();
		
		// ? extends MyClass 로 제한이 걸렸기 때문에 MyClass 혹은 MyClass 하위 클래스로 되어있는 제너릭만 전달 가능
		// extendsMethod(superList);
		extendsMethod(myList);
		extendsMethod(subList);
		
		// ? superMyClass 로 제한이 걸렸기 때문에 MyClass 혹은 MyClass 상위 클래스로 되어있는 제너릭만 전달 가능
		superMethod(superList);
		superMethod(myList);
		// superMethod(subList);
		
		// 메서드의 매개타입은 직접 지정하지 않고 매개변수의 타입을 따라감
		genericMethod(myList); // 제너릭 메서드의 타입이 MyClass 의 타입을 따라감
		
	}
	// ? : 제너릭의 와일드카드로 모든 타입을 받을 수 있도록 함
	// 와일드카드는 메서드의 매개변수 혹은 반환 타입에 사용
	static void wildcardMethod(Test5<?> test) {
		System.out.println(test.score);
	}
	// ** ? extends 클래스명 : 특정 클래스 혹은 특정 클래스를 상속받은 클래스만 타입으로 받도록 제한 **
	static void extendsMethod(List<? extends MyClass> list) {}
	
	// ** ? super 클래스명 : 특정 클래스 혹은 특정 클래스의 상위 클래스만 타입으로 받도록 제한 **
	static void superMethod(List<? super MyClass> list) {}
}
