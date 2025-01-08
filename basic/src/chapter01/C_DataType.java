package chapter01;

public class C_DataType {

	public static void main(String[] args) {
		
		// 변수의 데이터 타입
		// 기본형 데이터 타입, 참조형 데이터 타입
		
		// 기본형 데이터 타입
		
		// 정수형 데이터 타입 : 실수부가 존재하지 않음, 부호를 가지고 있음.
		
		// byte : 1byte(8bit)의 크기를 가지는 정수형 데이터 타입
		// 범위 : -128 ~ +127
		byte byte1 = -100;
		System.out.print(byte1 + " ");
		// byte byte2 = 128; >> Type mismatch: cannot convert from int(정수 리터럴값에는 int 값이 지정됨) to byte
		
		// short : 2byte(16bit)의 크기를 가지는 정수형 데이터 타입
		// 범위 : -32,768 ~ +32,767
		short short1 = -129;
		System.out.print(short1 + " ");
		// short short2 = 40000; >> Type mismatch: cannot convert from int(정수 리터럴값에는 int 값이 지정됨) to short
		
		// int : 4byte(32bit)의 크기를 가지는 정수형 데이터 타입
		// 범위 : -2,147,483,648 ~ +2,147,483,647
		int int1 = 40000;
		System.out.print(int1 + " ");
		// int int2 = 2200000000; >> The literal 2200000000 of type int is out of range
		// int int2 = 2200000000L; >> Type mismatch: cannot convert from long to int
		
		// long : 8byte(64bit)의 크기를 가지는 정수형 데이터 타입
		long long1 = 2_200_000_000L;
		System.out.print(long1 + " ");
		
		// 실수형 데이터 타입 : 실수부를 가지는 데이터 타입, 부호를 가지고 있음.
		
		// float : 4byte(32bit)의 크기를 가지는 실수형 데이터 타입
		// 소수점 아래 6 ~ 7자리에서 오차가 발생
		// float float1 = 0.123456789; >> Type mismatch: cannot convert from double(실수 리터럴값에는 double 값이 지정됨) to float
		float float1 = 0.123456789F;
		System.out.println(float1);
		
		// double : 8byte(64bit)의 크기를 가지는 실수형 데이터 타입
		// 소수점 아래 15 ~ 17자리에서 오차가 발생
		double double1 = 0.123456789;
		System.out.println(double1);
		
		// 문자형 데이터 타입 : 문자 하나를 저장할 수 있는 데이터 타입, 부호 X
		
		// char : 2byte(16bit)의 크기를 가지는 문자형 데이터 타입
		// 범위 : 0 ~ 65,535(아스키코드에 의한 숫자 범위)
		// 문자를 리터럴로 표현할 땐 ''로 묶어서 표현
		char char1 = 'A';
		char char2 = 65; // 아스키코드
		char char3 = '\u0041'; // 유니코드(16진법)
		System.out.println(char1);
		System.out.println(char2);
		System.out.println(char3);
		
		// 논리형 데이터 타입 : 참과 거짓 값을 가지는 데이터 타입
		
		// boolean : 1byte(8bit)의 크기를 가지는 논리형 데이터 타입
		// true, false
		boolean boolean1 = true;
		boolean boolean2 = false;
		System.out.println(boolean1);
		System.out.println(boolean2);
		
		// 형변환 : 데이터 타입이 서로 다른 변수를 옮겨 담는것
		
		// 자동 형변환 : 작은 데이터 타입의 변수를 큰 데이터 타입의 변수에 옮겨 담을 때 발생
		// 강제 형변환 : 큰 데이터 타입의 변수를 작은 데이터 타입의 변수에 옮겨 담을 때 발생
		
		int number1 = 300;
		long number2 = number1;
		number1 = (int) number2;
		
		byte number3 = (byte) number2;
		System.out.println(number3); // 강제 형변환시 데이터 소실 발생(초과하는 양은 버림)
		
		double number4 = 3.1415;
		number1 = (int) number4;
		System.out.println(number1);
		
		number4 = number3;
		System.out.println(number4);
		
		// 배열 : 동일한 타입의 변수를 묶어서 저장하는 컨테이너
		// new 연산자를 이용해서 컨테이너를 먼저 생성해야함, 첫번째 메모리의 주소값 저장
		// 한번 생성된 컨테이너의 크기는 변경할 수 없음
		
		// 배열 변수 선언
		// 데이터 타입[] 배열 변수명;
		// 배열 생성
		// new 데이터 타입[배열의 길이];
		int[] numbers;
		numbers = new int[3];
		System.out.println(numbers);
		
		int[] numbers2 = {1, 2, 3}; // { } : 코드블럭
		int[] numbers3 = new int[] {1, 2, 3};
		System.out.println(numbers2);
		System.out.println(numbers3);
		
		// 배열의 요소에 접근 혹은 사용할 때는 '인덱스' 사용
		// 배열의 시작 인덱스는 0, 마지막 인덱스는 length(길이) -1
		int number = numbers3[1];
		System.out.println(number);
		numbers3[1] = 22;
		System.out.println(number);
		
		// 배열의 길이를 초과하는 인덱스에 접근할 시 예외 발생
		// System.out.println(numbers3[99]);
		
		// 배열의 길이를 확인하고자 할땐 .length
		System.out.println(numbers3.length); // 배열의 길이
		
		int lastIndex = numbers3.length - 1;
		System.out.println(numbers3[lastIndex]); // 배열의 마지막 인덱스 값
		
		int[] example1 = new int[] {0, 0, 0};
		int[] example2 = example1; // 주소값을 할당
		System.out.println(example1); // [I@279f2327
		System.out.println(example2); // [I@279f2327
		
		example1[0] = 99; // example1의 요소값만 변경
		System.out.println(example1[0]);
		System.out.println(example2[0]);
		
		System.out.println(example1); // [I@279f2327 >> example1의 주소값은 변경되지 않고 그 안의 요소값만 변경된 것.
		
		// 문자의 배열
		char[] chars = {'e', 'x', 'a', 'm'};
		System.out.println(chars);
		
		// 문자열 String 클래스 : 문자의 배열을 표현하는데 사용되는 참조형 데이터 타입
		// 선언
		// String 변수명;
		// 생성
		// new String(문자열);
		// 초기화
		// 변수명 = "문자열";
		String string1;
		string1 = "내이름맑음";
		String string2 = "오전오후";
		System.out.println(string1);
		System.out.println(string2);
		
		// String 객체는 불변성(변경이 불가능)을 가짐
		String string3 = "exam";
		System.out.println(chars);
		System.out.println(string3);
		chars[0] = 'd';
		// string3[0] = 'd'; 불가능
		System.out.println(chars);
		string3 = "dxam";
		System.out.println(string3);
		
		// String 클래스의 주요 기능
		String statement = " My Name Is Loki ";
		
		// 1. 문자열 결합
		// + 혹은 .concat(문자열) 으로 두 문자열을 연결할 수 있음
		System.out.println(statement + "@@@@");
		System.out.println(statement.concat("!!!!"));
		
		// 2. 문자열 비교
		// .equals(문자열) : 두 문자열이 동등한지 비교
		// .compareTo(문자열) : 두 문자열을 사전순으로 비교(대소문자 구분함)
		// .compareToIgnoreCase(문자열) : 두 문자열을 사전순으로 비교(대소문자 구분 X)
		System.out.println(statement.equals("My Name Is Loki"));
		System.out.println(statement.compareTo(" My Name Is Loki ")); // 괄호안의 문자열이 사전순으로 먼저 오는 문자면 양수, 뒤에 오는 문자면 음수, 동일하면 0
		
		// 3. 문자열의 길이
		// .length() : 문자열의 길이 반환
		System.out.println(statement.length());
		
		// 4. 문자열 변환
		// .toUpperCase() : 모두 대문자로 변환
		// .toLowerCase() : 모두 소문자로 변환
		// .trim() : 앞뒤 공백 제거
		// .replace(찾을 문자열, 바꿀 문자열) : 첫번째로 찾은 특정 문자열을 찾아 변경
		System.out.println(statement.toUpperCase());
		System.out.println(statement.toLowerCase());
		System.out.println(statement.trim());
		System.out.println(statement.replaceAll("Loki", "Iron_Man")); // 해당하는 모든 문자열을 찾아 변경
		
		// 5. 문자열 찾기
		// .indexOf(문자열) : 찾고자하는 문자열의 처음 찾은 위치의 인덱스 번호를 반환
		// .lastIndexOf(문자열) : 찾고자하는 문자열의 마지막 위치의 인덱스 번호를 반환
		statement = "내가 그린 기린 그림은 잘 그린 기린 그림이고 네가 그린 기린 그림은 잘 못그린 기린 그림이다.";
		System.out.println(statement.indexOf("그림"));
		System.out.println(statement.indexOf("사진")); // 없는 단어는 -1 반환
		
		// 6. 부분 문자열
		// .substring(시작 인덱스값), substring(시작 인덱스값, 종료 인덱스값) : 문자열을 원하는 크기만큼 추출
		System.out.println(statement.substring(13));
		System.out.println(statement.substring(13, 23));
		
		// 참조형 데이터 타입 : 주소를 가지는 변수의 데이터 타입
		
		// null을 가질 수 있음(null : 아무것도 지정되지 않은 상태, 미정)
		// 배열, 클래스, 인터페이스, 열거형이 참조형 데이터 타입에 속함
		// String string4 = null;
		// string4.substring(0); >> NullPointerException
	}
}