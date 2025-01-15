package exam02;

import java.util.Scanner;

public class ManualCar extends Car {
	private int gear;
	
	public ManualCar(String vin, String color, boolean isStart, int gear) {
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

	public int getGear() {
		return gear;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void setGear() {
		while (true) {
			System.out.print("기어를 선택해주세요. : ");
			gear = scanner.nextInt();
			if (validate()) {
				System.out.println(gear + "단으로 변경했습니다.");
				break;
			} else continue;
		}
	}
	
	public boolean validate() {
		if (!isNotMinus()) {
			System.out.println("0~6까지 숫자를 선택해주세요.");
			return false;
		}
		if (!gearCheck()) {
			System.out.println("0~6까지 숫자를 선택해주세요.");
			return false;
		}
		return true;
	}
	
	private boolean isNotMinus() {
//		if (gear < 0) return false;
//		return true;
		return gear != -1;
	}
	
	private boolean gearCheck() {
		if (gear > 6) return false;
		return true;
	}
}
