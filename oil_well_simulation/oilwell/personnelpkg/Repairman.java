package oilwell.personnelpkg;

import oilwell.enumpkg.*;
import oilwell.machinerypkg.Machinery;

public class Repairman extends Personnel{

	public Repairman(PersonnelNames workerName) {
		super(workerName);
	}
	
	
	
	public void refillFuelTank(Machinery machine, Repairman helper) {
		this.takeControlOfMachine(machine);
		if(Machinery.getStorageFuel() - this.getCurrentMachine().getFuelTankSize() < 0) {
			System.out.println(this.getCurrentMachine().getMachineName() + "\t\t-\tneda sa tankovat - minulo sa palivo z cisterny.\n");
			helper.refillFuelTank();
		}
		this.getCurrentMachine().setFuel(this.getCurrentMachine().getFuelTankSize());
		Machinery.changeAmountOfStorageFuel(Machinery.getStorageFuel() - this.getCurrentMachine().getFuelTankSize());
		System.out.println(this.getPersonnelName() + "\t\t-\tnatankoval stroj\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.leaveMachine();
	}
	
	public void refillFuelTank() {
		this.setAvailability(false);
		System.out.println(this.getPersonnelName() + "\t\t-\todisiel doplnit palivo do cisterny.\n");
		Machinery.changeAmountOfStorageFuel(500);
		System.out.println(this.getPersonnelName() + "\t\t-\tnaplnil cisternu palivom.\n");
		this.setAvailability(true);
	}
	
	public void repairDamagedMachine(Machinery machine) {
		this.takeControlOfMachine(machine);
		this.getCurrentMachine().setFunctioning(true);
		System.out.println(this.getPersonnelName() + "\t\t-\topravil stroj\t\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.leaveMachine();
	}
	
	public void transportMachineToStorage(Machinery machine){
		this.takeControlOfMachine(machine);
		System.out.println(this.getPersonnelName() + "\t\t-\todviezol do skladu\t\t-\t\t" + this.getCurrentMachine().getMachineName() + ".\n");
		this.getCurrentMachine().setInStorage(true);
		this.leaveMachine();
	}
}
