package chapter01;

import java.util.Scanner;

public class F_Control_Switch {

	public static void main(String[] args) {
		
		// switch 문 : 특정 변수 혹은 표현식에 따라 실행할 코드 블럭의 범위를 결정하는것
//		switch (일반표현식) {
//		case 값1:
//			일반표현식이 값1과 같을때 시작할 코드 블럭 위치
//		case 값2:
//			일반표현식이 값2와 같을때 시작할 코드 블럭 위치
//			switch 내부에서 break 문을 만나면 switch 코드 블럭을 탈출 
//			break;
//		case 값3:
//			일반표현식이 값3과 같을때 시작할 코드 블럭 위치
//		default:
//			일반표현식이 case 의 값과 일치하는 것이 하나도 없거나 바로 위에서 break 문을 만나지 않으면 실행되는 코드
//		}
		
		// number 라는 정수형 변수에 사용자로부터 정수를 입력받아 할당
		// 0 이면 ABC 를 출력
		// 1 이면 BC 를 출력
		// 2 이면 C 를 출력
		// 3 이면 DE 를 출력
		// 0 - 3이 아니면 E 를 출력
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수 : ");
		int number = scanner.nextInt();
		
		switch (number) {
		case 0:
			System.out.print("A");
		case 1:
			System.out.print("B");
		case 2:
			System.out.print("C");
			break;
		case 3:
			System.out.print("D");
		default:
			System.out.print("E");
		}
		scanner.close();
		
	}

}