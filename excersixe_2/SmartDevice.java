package excersixe_2;

public abstract class SmartDevice implements Powerable{

	protected String deviceName;
	protected boolean isOn;
	
	public SmartDevice(String deviceName, boolean isOn) {
		this.deviceName = deviceName;
		this.isOn = false;
	}
	
	static int activeDevicesCount = 0;
	
	
	abstract void performSelfDiagnostic();

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		
	}

	public static int getActiveDevicesCount() {
		return activeDevicesCount;
	}

}
