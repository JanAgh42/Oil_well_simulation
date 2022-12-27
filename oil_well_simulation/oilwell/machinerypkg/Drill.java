package oilwell.machinerypkg;

import java.util.ArrayList;

import oilwell.enumpkg.*;

public class Drill extends Machinery{
	
	private static ArrayList<DrillBit> drillBits = new ArrayList<DrillBit>();
	private static int depthOfDrilling = 0;

	public Drill(int amountOfFuel, MachineNames machineName) {
		super(amountOfFuel, machineName);
	}
	
	public boolean startDrilling() {				//THIRD
		if(this.spendFuel()) {
			System.out.println(this.getMachineName() + "\t\t-\tprebieha vrtanie plosiny.\n");
			Drill.depthOfDrilling = Drill.drillBits.get(0).getID() * 10;
			return true;
		}
		else {
			return false;
		}
	}
	
	public void stopDrilling() {					//FOURTH
		System.out.println(this.getMachineName() + "\t\t-\tbola vyvrtana dalsia cast vrtu.\n");
	}
	
	public void deleteLastDrillBit() {
		Drill.drillBits.clear();
	}
	
	public void addNewDrillBit(DrillBit drillbit) {
		this.deleteLastDrillBit();
		Drill.drillBits.add(drillbit);
	}
	
	public void machineIsBroken() {
		System.out.println(this.getMachineName() + "\t\t-\tzariadenie nedokaze vrtat kvoli poskodeniu");
	}
	
	public static int getCurrentDepth() {
		return Drill.depthOfDrilling;
	}
}
