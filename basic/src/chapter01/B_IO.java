package chapter01;

import java.util.Scanner;

public class B_IO {

	public static void main(String[] args) {
		
		// 콘솔 출력
		// System.out.print(출력할 데이터) : 콘솔에 출력 후 라인변경 X
		// System.out.println(출력할 데이터) : 콘솔에 출력 후 라인변경 O
		System.out.print(1227);
		System.out.print(931);
		System.out.println(1227);
		System.out.println(931);
		
		// 콘솔 입력
		// java.util.Scanner 클래스의 인스턴스(객체) 생성해서 .nextXXX() 메서드(기능)로 입력을 받음.
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner);
		
		System.out.print("입력 : ");
		final int INPUT = scanner.nextInt();
		System.out.println("사용자가 입력한 값 : " + INPUT);
		
		// 시스템으로부터 받은 자원을 반환하는 작업
		scanner.close();
		
	}

}
