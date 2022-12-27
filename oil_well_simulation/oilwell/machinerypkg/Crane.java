package oilwell.machinerypkg;

import oilwell.enumpkg.*;
import oilwell.machinerypkg.*;

public class Crane extends Machinery{
	
	private DrillBit currentDrillBit;

	public Crane(int amountOfFuel, MachineNames machineName) {
		super(amountOfFuel, machineName);
		this.currentDrillBit = null;
	}
	
	public boolean liftDrillBit(DrillBit drillbit) {			//FIRST and FIFTH (loop onwards)
		if(this.spendFuel()) {
			this.currentDrillBit = drillbit;
			System.out.println(this.getMachineName() + "\t\t-\tzdvihol " + this.getCurrentDrillBit().getID() + ". segment vrtaka.\n");
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean attachDrillBitToDrill(Drill drill) {			//SECOND
		if(this.spendFuel()) {
			drill.addNewDrillBit(this.getCurrentDrillBit());
			System.out.println(this.getMachineName() + "\t\t-\tpripevnil segment k\t\t-\t\t" + drill.getMachineName() + ".\n");
			this.currentDrillBit = null;
			//drill.startDrilling();							//THIRD
			return true;
		}
		else {
			System.out.println(this.getMachineName() + "\t\t-\tpolozil " + this.getCurrentDrillBit().getID() + ". segment vrtaka.\n");
			this.currentDrillBit = null;
			return false;
		}
	}
	
	public void machineIsBroken() {
		System.out.println(this.getMachineName() + "\t\t-\tzariadenie nedokaze pracovat s vrtakmi kvoli poskodeniu");
	}
	
	public DrillBit getCurrentDrillBit() {
		return this.currentDrillBit;
	}
}
