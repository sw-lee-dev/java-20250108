package testOne;

public class TestTwo {

	public static void main(String[] args) {
		// 정수 배열 array
		// 2차원 정수 배열 queries 각각의 query 를 가지며 [s, e] 형태
		// 각 query 마다 순서대로 s <= i <= e 인 모든 i 에 대해 array[index] 1을 더한다
		// array 를 리턴
		// 메서드의 반환 타입은 정수의 배열, 메서드명은 solution, 매개변수 타입은 array, queries
		// 접근은 모든 패키지 가능, 오버라이딩 가능, 구현부가 존재하는 인스턴스 메서드로 작성
		// array {0,1,2,3,4}
		// queries {{0,1},{1,2},{2,3}}
		// ->> {1,3,4,4,4}
		
		// query 는 2개만 가지는 형태의 배열 >> queries[i][0] , queries[i][1]

		int[] array = { 0, 1, 2, 3, 4 };
		int[][] queries = { { 0, 1 }, { 1, 2 }, { 2, 3 } };

//		for (int i = 0; i < array.length; i++) {
//			for (int j = i+1; j < queries.length; j++) {
//				for (int k = 0; k < 2; k++) {
//					if (queries[j][k] == array[i]) {
//						array[i] += 1;
//					}
//				}
//			}
//			System.out.print(array[i]);
//		}
//		
		System.out.println();
		
		for (int i = 0; i < queries.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (queries[i][0] <= j && j <= queries[i][1]) {
					array[j]++;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}
}
