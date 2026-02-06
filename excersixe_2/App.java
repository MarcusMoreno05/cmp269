package excersixe_2;
import java.util.ArrayList;

public class App {
	 public static void main(String[] args) {
		
		 ArrayList<SmartDevice> homeHub = new ArrayList<>();
		 SmartLight livingRoom = new SmartLight("Living Room",false);
	        SmartLight kitchen = new SmartLight("Kitchen",false);
	        SmartThermostat hallway = new SmartThermostat("Hallway",false);

	        homeHub.add(livingRoom);
	        homeHub.add(kitchen);
	        homeHub.add(hallway);

	        livingRoom.turnOn();
	        hallway.turnOn();

	        kitchen.setLevel(75);
		 
	        System.out.println("Active Devices: " + SmartDevice.getActiveDevicesCount());
		 
		 for (SmartDevice p : homeHub) {
			    p.performSelfDiagnostic();
			}

	 }
}
