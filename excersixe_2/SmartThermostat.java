package excersixe_2;

public class SmartThermostat extends SmartDevice implements Adjustable {

	
	private int temperture;
	
	
	
	
	
	public SmartThermostat(String deviceName, boolean isOn) {
		super(deviceName, isOn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setLevel(int level) {
		if (level >= 60 && level <=80) {
			level = temperture;
		}
		
	}

	@Override
	void performSelfDiagnostic() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void turnOn() {
		System.out.println("HVAC System Starting...");
		super.turnOn();
		
	}

}
