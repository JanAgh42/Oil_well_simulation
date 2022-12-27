package oilwell.machinerypkg;

import oilwell.enumpkg.*;
import oilwell.personnelpkg.*;

public class Machinery extends Tools{

	private int amountOfFuel;
	private final int fuelTankSize;
	
	private boolean isFunctioning;
	private boolean isInStorage;
	
	private final MachineNames machineName;
	private PersonnelNames isControlledBy;
	
	private static int fuelAvailableAtSite = 500;
	
	
	
	public Machinery(int amountOfFuel, MachineNames machineName) {
		this(amountOfFuel, machineName, false, true, true);
	}
	
	public Machinery(int amountOfFuel, MachineNames machineName, boolean isActive, boolean isFunctioning, boolean isInStorage) {
		super(isActive);
		this.amountOfFuel = this.fuelTankSize = amountOfFuel;
		this.machineName = machineName;
		this.isFunctioning = isFunctioning;
		this.isInStorage = isInStorage;
		this.isControlledBy = null;
	}
	
	
	
	public void setFunctioning(boolean isFunctioning) {
		this.isFunctioning = isFunctioning;
	}
	
	public void setFuel(int amountOfFuel) {
		this.amountOfFuel = amountOfFuel;
	}
	
	public void setInStorage(boolean isInStorage) {
		this.isInStorage = isInStorage;
	}
	
	public void setControllerName(PersonnelNames controllerName) {
		this.isControlledBy = controllerName;
	}
	
	public PersonnelNames getControllerName() {
		return this.isControlledBy;
	}
	
	public boolean getFunctioning() {
		return this.isFunctioning;
	}
	
	public int getFuel() {
		return this.amountOfFuel;
	}
	
	public int getFuelTankSize() {
		return this.fuelTankSize;
	}
	
	public MachineNames getMachineName() {
		return this.machineName;
	}
	
	public static int getStorageFuel() {
		return Machinery.fuelAvailableAtSite;
	}
	
	public boolean spendFuel() {
		if((this.getFuel() - 20) > 0) {
			this.setFuel(this.getFuel() - 20);
			return true;
		}
		else {
			System.out.println(this.getMachineName() + "\t\t-\tNedostatok paliva na pokracovanie v praci.\n");
			return false;
		}
	}
	
	public void machineIsBroken() {
		System.out.println(this.getMachineName() + "\t\t-\tzariadenie sa pokazilo / poskodilo");
	}
	
	public static void changeAmountOfStorageFuel(int amount) {
		Machinery.fuelAvailableAtSite = amount;
	}
}
