package oilwell.personnelpkg;

import oilwell.enumpkg.*;
import oilwell.machinerypkg.Machinery;

public class Personnel {

	private boolean isAvailable;
	
	private final PersonnelNames personnelName;
	
	private Machinery currentMachine;
	
	
	
	public Personnel(PersonnelNames personnelName) {
		this.isAvailable = true;
		this.personnelName = personnelName;
		this.currentMachine = null;
	}
	
	
	
	public boolean getAvailability() {
		return this.isAvailable;
	}
	
	public PersonnelNames getPersonnelName() {
		return this.personnelName;
	}
	
	public Machinery getCurrentMachine() {
		return this.currentMachine;
	}
	
	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setCurrentMachine(Machinery machine) {
		this.currentMachine = machine;
	}
	
	
	
	public void takeControlOfMachine(Machinery machine) {
		this.setCurrentMachine(machine);
		this.getCurrentMachine().setControllerName(this.getPersonnelName());
		this.setAvailability(false);
		System.out.println(this.getPersonnelName() + "\t\t-\tujal sa vedenia\t\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
	}
	
	public void leaveMachine() {
		System.out.println(this.getPersonnelName() + "\t\t-\topustil stroj\t\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.getCurrentMachine().setControllerName(null);
		this.setCurrentMachine(null);
		this.setAvailability(true);
	}
	
}
