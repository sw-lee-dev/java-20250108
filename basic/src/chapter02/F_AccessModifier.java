package chapter02;

// 접근제어자 (access modifier) : 클래스나 메서드, 필드에 대해서 외부 접근에 대한 제어를 하는것
// public : 모든 패키지에서 접근 가능
// protected : 같은 패키지 내부 혹은 외부 패키지의 자손 클래스에서 접근 가능
// default (package) : 같은 패키지 내부에서만 접근 가능
// private : 같은 클래스 내부에서만 접근 가능

// 특정 클래스파일(.java 파일)에서 public 클래스는 파일명과 일치해야 하고 하나만 지정할 수 있음
//public class ExampleClass { >> The public type ExampleClass must be defined in its own file
//	
//}

class AccessModifierSub1 {
	
	void method() {
		
		F_AccessModifier instance = new F_AccessModifier();
		// 현재 위치 : 같은 패키지
		// public, protected, package 접근 제어자는 같은 패키지 내부에서 접근 가능
		instance.publicInt = 0;
		instance.protectedInt = 0;
		instance.packageInt = 0;
		// private 접근 제어자는 같은 패키지인 다른 클래스에서 접근 불가능
		// instance.privateInt = 0; // The field F_AccessModifier.privateInt is not visible >> 존재는 하지만 볼 수 없다.
	}
	
}

public class F_AccessModifier {
	
	public int publicInt;
	protected int protectedInt;
	int packageInt;
	private int privateInt;

	public static void main(String[] args) {
		
		F_AccessModifier instance = new F_AccessModifier();
		instance.publicInt = 0;
		instance.protectedInt = 0;
		instance.packageInt = 0;
		instance.privateInt = 0;

	}

}
