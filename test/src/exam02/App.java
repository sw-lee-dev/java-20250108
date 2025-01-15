package exam02;

public class App {

	public static void main(String[] args) {
		
		ManualCar manualCar = new ManualCar("01가1234", "blue", false, 0);
		AutomaticCar automaticCar = new AutomaticCar("10가1234", "blue", false);
		PassengerTrain passengerTrain = new PassengerTrain("KTX001", "서울", "부산", false, 200);
		FreightTrain freightTrain = new FreightTrain("Cargo001", "부산", "구미", false, 100.0);
		
		manualCar.accelate();
		manualCar.stop();
		manualCar.setStart();
		System.out.println(manualCar.getColor());
		System.out.println(manualCar.getVin());
		manualCar.setGear();
		
		automaticCar.accelate();
		automaticCar.stop();
		automaticCar.setStart();
		System.out.println(automaticCar.getColor());
		
		passengerTrain.accelate();
		passengerTrain.stop();
		passengerTrain.setStart();
		System.out.println(passengerTrain.getDepatureStation());
		System.out.println(passengerTrain.getPassengerCount());
		
		freightTrain.accelate();
		freightTrain.stop();
		freightTrain.setStart();
		System.out.println(freightTrain.getArrivalStation());
		System.out.println(freightTrain.getCargoWeight());
	}

}
