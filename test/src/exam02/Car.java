package exam02;

public class Car implements Vehicle {
	private String vin;
	private String color;
	private boolean isStart;

	public Car(String vin, String color, boolean isStart) {
		this.vin = vin;
		this.color = color;
		this.isStart = isStart;
	}

	@Override
	public void accelate() {
		System.out.println("가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("정차합니다!");
	}

	@Override
	public void setStart() {
		if (!isStart) {
			System.out.println("시동이 걸렸습니다.");
		}
	}

	public String getVin() {
		return vin;
	}
	public String getColor() {
		return color;
	}
	public boolean isStart() {
		return isStart;
	}


}
