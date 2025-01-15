package testOne;

public class TestThree {

	public static void main(String[] args) {
		// 정수 number 자리수의 합을 리턴, 입력값이 0이하의 정수면 0을 반환
		// -2000000000 <= number <= 2000000000
		// 123456789 -> 45
		// -123456789 -> 0
		int number = 123456789;
		int sum = 0;
		
		if (number > 0) {
			sum += number / 100000000;
			number %= 100000000;
			sum += number / 10000000;
			number %= 10000000;
			sum += number / 1000000;
			number %= 1000000;
			sum += number / 100000;
			number %= 100000;
			sum += number / 10000;
			number %= 10000;
			sum += number / 1000;
			number %= 1000;
			sum += number / 100;
			number %= 100;
			sum += number / 10;
			number %= 10;
			sum += number / 1;
			System.out.println(sum);
		} else if (number < 0) {
			System.out.println(0);
		}
	}

}
