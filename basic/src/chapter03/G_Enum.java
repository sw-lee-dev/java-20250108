package chapter03;

import java.time.LocalDateTime;
import java.time.Month;

// 열거형 (Enum) : 서로 관련된 상수들의 집합을 나타내는 특수한 클래스
// enum 열거형타입이름 { 상수... }

enum Color1 {
	// 지정하고자 하는 상수를 ,(COMMA)로 나열 (기본적인 사용방법)
	RED, ORANGE, YELLOW, GREEN, BLUE, NAVY, PURPLE
}

enum Color2 {
	// 생성자 호출을 열거된 상수 위치(인스턴스 필드)에서 호출함
	RED("#ff0000", "rgb(255, 0, 0)"),
	GREEN("#00ff00", "rgb(0, 255, 0)"),
	BLUE("#0000ff", "rgb(0, 0, 255)");
	
	// 열거형도 클래스이기 때문에 필드, 생성자, 메서드를 모두 가질 수 있음
	// enum 의 필드는 상수로 사용되기 때문에 변경되면 안됨
	// 캡슐화 작업이 필요
	private final String hex;
	private final String rgb;
	
	// 생성자의 접근제어자 private
	// 인스턴스 생성 자체를 외부에서 못하게 막는것
	private Color2(String hex, String rgb) {
		this.hex = hex;
		this.rgb = rgb;
	}
	
	public String getHex() {
		return hex;
	}
	
	public String getRgb() {
		return rgb;
	}
}

public class G_Enum {

	public static void main(String[] args) {

		Color1 color1 = Color1.RED;
		System.out.println(color1);
		
		// 열거형을 사용하면 조건 비교(동등 비교)에 편하게 사용 가능
		if (color1 == Color1.RED) {
			System.out.println("빨강색!");
		}
		
		// 열거형을 사용하면 상수를 묶음으로 관리할 수 있음
		Color2 color2 = Color2.BLUE;
		System.out.println(color2);
//		System.out.println(color2.hex);
//		System.out.println(color2.rgb);
//		color2.hex = "#000099";
//		System.out.println(color2.hex);
		System.out.println(color2.getHex());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		Month month = localDateTime.getMonth();
		
		switch(month) {
		case Month.APRIL:
			System.out.println("작업");
		}
		
	}

}
