package chapter01;

public class E_Control_If {

	public static void main(String[] args) {
		
		// 코드 블럭
		// 코드들의 묶음 (여러 구문을 하나의 묶음(기능)으로 취급)
		// {}로 표시
		{
			int a = 10;
			int b = 20;
			int result = a + b;
			System.out.println(result);
			
			// int a = 0;
		} // 코드 블럭으로 묶음으로서 하나의 단위로 만듦
		int a = 0;
		{
			// int a = 0; // 메인에 종속되어 있기 때문
			int b = 0;
		}
		
		// 제어문 : 조건에 따라서 코드의 흐름을 결정하는 것
		
		// 조건문 : 특정 조건이 만족하면 해당 코드 블럭을 실행하는 것
		
		// if 문 : 주어진 논리표현식(조건)이 true 이면 코드 블럭을 실행하게 하는 것
		// if (논리표현식) { 논리표현식이 true 일때 실행할 코드 블럭 }
		
		System.out.println("if문 시작");
		
		int number = -10;
		
		if (number > 0) {
			System.out.println("양수");
		}
		
		System.out.println("if문 종료");
		
		// else 문 : if 문의 논리표현식이 false 일때 코드 블럭을 실행하게 하는 것
		// if (논리표현식) { true 일때 실행할 코드 블럭 }
		// else { false 일때 실행할 코드 블럭 }
		
		// 주의!
		// 1. else 문은 반드시 if 문 이후에 와야함(if 문에 종속, else 문 단독 사용 불가능)
		// 2. else 문에는 논리표현식을 작성하지 않음
		
		System.out.println("if-else문 실행");
		
		number = -5;
		
		if (number > 0) {
			System.out.println("양수");
		} else {
			System.out.println("양수가 아님");
		}
		
		System.out.println("if-else문 종료");

		System.out.println("여러 조건");
		
		number = 1;
		
		if (number > 0) System.out.println("양수");
		else if (number < 0) System.out.println("음수");
		else System.out.println("0");
		/* else if 문을 실제로는 else 문 안의 if 문이다. else 문은 if 문에 종속되기 때문에 코드블럭으로 묶을 필요 없음.
		 * else 
		 * {
		 * 	if () {}
		 * 	else {}
		 * }
		 */
		System.out.println("여러 조건 종료");
		
		// 국적 - 대한민국, 나이 - 성인(> 19) ,성별 - 남성 >> 현역
		String country = "대한민국";
		int age = 23;
		String gender = "남성";
		
		// if (country.equals("대한민국")) {
		//	 if (age > 19) {
		//		if (gender.equals("남성")) {
		//			System.out.println("현역");
		//		}
		//	 }
		// }
		
		// if (country.equals("대한민국") && age > 19 && gender.equals("남성")) {
		// 	 System.out.println("현역");
		// }
		
		boolean isActive = country.equals("대한민국") && age > 19 && gender.equals("남성");
		// if (isActive) { System.out.println("현역"); }
		// System.out.println("종료");
		if (!isActive) return;
		System.out.println("현역");
	}

}