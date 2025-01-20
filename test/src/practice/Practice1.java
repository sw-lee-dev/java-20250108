package practice;

public class Practice1 {

	public static void main(String[] args) {
		int[][] block = {
				{0,1,2,3,4},
				{5,6,7,8,9},
				{1,2,3,4,5},
				{6,7,8,9,0},
				{0,1,2,3,4}};
		int w = 1;
		int h = 3;
		int sum = 0;
		System.out.println(block[w][h]);
		
		int[] wChange = {-1, -1, 1, 1};
		int[] hChange = {-1, 1, 1, -1};
		
		for (int i = 1; i < block.length - 1; i++) {
			for (int j = 0; j < 4; j++) {
				w = w + (i*wChange[j]);
				h = h + (i*hChange[j]);
				if (w >= 0 && w < block.length && h >= 0 && h < block.length) {
					sum += block[w][h];
				}
				w = 1;
				h = 3;
			}
		}
		System.out.println(sum);
		System.out.println(sum + block[w][h]);
	}

}
