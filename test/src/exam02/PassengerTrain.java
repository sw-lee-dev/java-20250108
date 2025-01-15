package exam02;

public class PassengerTrain extends Train {
	private int passengerCount;

	public PassengerTrain(String trainNumber, String depatureStation, String arrivalStation, boolean isStart,
			int passengerCount) {
		super(trainNumber, depatureStation, arrivalStation, isStart);
		this.passengerCount = passengerCount;
	}

	public int getPassengerCount() {
		return passengerCount;
	}
	
	@Override
	public void accelate() {
		System.out.println("여객 열차가 천천히 가속합니다.");
	}

	@Override
	public void stop() {
		System.out.println("여객 열차가 천천히 정차합니다.");
	}

}
