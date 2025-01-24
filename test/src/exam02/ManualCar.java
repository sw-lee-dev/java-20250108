package exam02;

import java.util.Scanner;

public class ManualCar extends Car {
	private Integer gear;
	
	public ManualCar(String vin, String color, boolean isStart, Integer gear) {
		super(vin, color, isStart);
		this.gear = gear;
	}

	@Override
	public void accelate() {
		System.out.println("수동 변속기 자동차가 가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("수동 변속기 자동차가 정차합니다!");
	}

	public Integer getGear() {
		return gear;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void setGear() {
		while (true) {
			try {
				System.out.print("기어를 선택해주세요. : ");
				gear = Integer.parseInt(scanner.nextLine());
				if (validate()) {
					System.out.println(gear + "단으로 변경했습니다.");
					break;
				} continue;
			} catch (Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
	}
	
	public boolean validate() {
		if (!isNotMinus() || !gearCheck()) {
			System.out.println("0~6까지 숫자를 선택해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotMinus() {
		if (gear < 0) return false;
		return true;
	}
	
	private boolean gearCheck() {
		if (gear > 6) return false;
		return true;
	}
}
