package exam02;

public class Train implements Vehicle {
	private String trainNumber;
	private String depatureStation;
	private String arrivalStation;
	private boolean isStart;
	
	public Train(String trainNumber, String depatureStation, String arrivalStation, boolean isStart) {
		this.trainNumber = trainNumber;
		this.depatureStation = depatureStation;
		this.arrivalStation = arrivalStation;
		this.isStart = isStart;
	}

	@Override
	public void accelate() {
		System.out.println("가속합니다.");
	}

	@Override
	public void stop() {
		System.out.println("정차합니다.");
	}

	@Override
	public void setStart() {
		if (!isStart) {
			System.out.println("시동이 걸렸습니다.");
		}
	}

	public String getTrainNumber() {
		return trainNumber;
	}
	public String getDepatureStation() {
		return depatureStation;
	}
	public String getArrivalStation() {
		return arrivalStation;
	}
	public boolean isStart() {
		return isStart;
	}

}
