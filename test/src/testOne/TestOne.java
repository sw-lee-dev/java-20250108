package testOne;

public class TestOne {
	// numList[] , 첫 번째로 나오는 음수의 인덱스를 반환 , 음수가 없다면 -1
	// 반환 타입 int(인덱스 번호) , 메서드명은 solution , 매개변수 타입은 정수의 배열 , 접근은 모든 패키지 사용
	// 오버라이딩 가능 구현부가 존재하는 인스턴스 메서드
	// 5 <= numList 의 길이 <= 100
	// -10 <= numList 의 원소 <= 100
	// [12, 4, 15, 46, 38, -2, 15] -> 5
	// [13, 22, 53, 24, 15, 6 ] -> -1
	// [-2, -3, 1, 0, 2] -> 0
	// [0, -1, -2, 2, 3] -> 1
	// [0, 1, 2, 3, 4] -> -1
		
	public static void main(String[] args) {
		int[] numList = {12, 4, 15, -46, 38, 2, 15, 5};
		
		int result = 0;
		
		for (int i = 0; i < numList.length; i++) {
			if (numList[i] < 0) {
				result = i;
				break;
			}
			result = -1;
		}
		System.out.println(result);
	}
}
