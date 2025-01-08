package chapter02;

// JVM : 자바 가상 기계
// 실제 컴파일된 코드를 실행하는 기계
// 별도의 메모리 구조를 가짐

// Method Area (메서드 영역) : 모든 곳에서 접근 가능한 영역, 코드를 읽고 각 클래스의 구조를 저장하고 있음

// Heap Area (힙 영역) : 모든 곳에서 접근 가능한 영역, 인스턴스 혹은 배열과 같은 new 연산자를 통해 생성된 객체들이 저장되는 영역

// Stack Area (스택 영역) : 각 스레드(실행중인 프로세스)별로 독립적으로 존재하는 영역, 메서드 호출과 로컬 변수에 대한 정보가 저장됨, 각 코드 블럭마다 하나의 스택이 생성됨

class EC2 {						// 클래스의 변수와 메서드 모두 method area 에 저장됨
	int iv; // instance variable
	static int cv; // class variable
	
	void im() { // instance method
		int lv = 10;
		EC2 itc = new EC2();
	}
	
	static void cm() { // class method
		int clv = 10;
	}
}

public class B_JVM {
	
	static void method1(int arg) {
		arg++;
	}
	
	static void method2(EC2 arg) {
		arg.iv++;
	}

	public static void main(String[] args) { // stack 이 main 부터 시작됨(아래부터 쌓임)
		
		int lv1 = 20;			// main stack1 에 lv1 공간을 생성하고 20만큼의 값을 저장
		double lv2 = 3.5;		// main stack1 에 lv2 공간을 생성하고 3.5만큼의 값을 저장
		
		if (lv1 > 0) {			// if stack
			int cb = 30;		// if stack 에 cb 공간이 생기고 30만큼의 값을 저장
			lv1 = cb;			// main stack1 의 lv1 공간의 값이 20에서 30으로 변경되어 저장됨
		}						// 코드 블럭이 끝남과 동시에 if stack 이 삭제됨
		
		EC2 itc1 = new EC2();	// stack2 에 itc1 의 공간을 생성하고 new EC2() 중 인스턴스와 관련된 정보가 heap area 에 저장되고(iv, im), heap area 에 생성된 주소값이 stack2 에 할당됨
		EC2 itc2 = new EC2();	// stack2 에 itc2 의 공간을 생성하고 new EC2() 중 인스턴스와 관련된 정보가 heap area 에 저장되고(iv, im), heap area 에 생성된 주소값이 stack2 에 할당됨
		
		itc1.iv = 10;			// stack2 에 할당된 itc1 주소의 heap area 의 iv 에 찾아가서 값을 저장
		itc2.iv = -99;			// stack2 에 할당된 itc2 주소의 heap area 의 iv 에 찾아가서 값을 저장
		
		itc1.cv = 3000;			// class EC2 의 cv 에 3000만큼의 값이 저장됨
		
		itc1.im();				// 함수를 호출해서 새로운 stack3 이 생성됨, int 만큼의 lv 공간을 만들고 10만큼의 값을 저장함. stack3 에 EC2 itc 만큼의 공간을 생성하고 인스턴스와 관련된 정보가 heap area 에 저장되고(iv, im) 그 주소값을 stack3 에 할당
								// 함수 호출이 끝나면 stack3 에 생성되었던 정보는 삭제됨, heap area 은 남아있음(관리가 안되면 메모리 초과할 수 있음 -> 가비지 컬렉션이 필요없는 부분을 지워버림으로서 좀 더 수월하게 메모리를 관리할 수 있음)
		
		int a = 99;
		method1(a);				// 99++ 이지만 메서드 종료와 함께 스택이 삭제되서 a 값에 변화는 없음
		System.out.println(a);
		
		EC2 b = new EC2();
		b.iv = 99;
		method2(b);				// 99++ 가 주소값에 할당이 되어서 b 의 값이 100으로 변경됨
		System.out.println(b.iv);
		
	}

}










