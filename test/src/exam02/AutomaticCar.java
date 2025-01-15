package exam02;

public class AutomaticCar extends Car {

	public AutomaticCar(String vin, String color, boolean isStart) {
		super(vin, color, isStart);
	}
	
	@Override
	public void accelate() {
		System.out.println("자동 변속기 자동차가 가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("자동 변속기 자동차가 정차합니다!");
	}


}
