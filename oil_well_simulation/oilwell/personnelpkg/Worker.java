package oilwell.personnelpkg;

import oilwell.enumpkg.*;
import oilwell.machinerypkg.*;

public class Worker extends Personnel{
	
	public Worker(PersonnelNames workerName) {
		super(workerName);
	}
	
	
	
	public void transportMachineToDrilling() {
		this.getCurrentMachine().setActive(true);
		System.out.println(this.getPersonnelName() + "\t\t-\tpriviezol na miesto vrtu\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
	}
	
	public void removeMachineFromDrilling() {
		this.getCurrentMachine().setActive(false);
		System.out.println(this.getPersonnelName() + "\t\t-\todviezol z miesta vrtu\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.leaveMachine();
	}
	
	public void getMachineFromStorage(Machinery machine) {
		this.takeControlOfMachine(machine);
		System.out.println(this.getPersonnelName() + "\t\t-\tpriviezol zo skladu\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.getCurrentMachine().setInStorage(false);
	}
}
