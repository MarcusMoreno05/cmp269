package excersixe_2;

public class SmartLight extends SmartDevice implements Adjustable  {

	private int brightness;
	
	
	
	
	
	@Override
	public void turnOn() {
		activeDevicesCount++;
		
	}

	@Override
	public void turnOff() {
		activeDevicesCount--;
		
	}
	
	public SmartLight(String deviceName, boolean isOn) {
		super(deviceName, isOn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setLevel(int level) {
		if (isOn==false) {
			System.out.println("Cannot adjust: Device is OFF.");
		}
		level = brightness;
	}

	@Override
	void performSelfDiagnostic() {
		System.out.println("Checking LED health...");
		
	}

}
