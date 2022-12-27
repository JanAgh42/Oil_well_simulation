package oilwell.machinerypkg;

import oilwell.enumpkg.*;

public class WaterPump extends Machinery{

	public WaterPump(int amountOfFuel, MachineNames machineName) {
		super(amountOfFuel, machineName);
	}
	
	public boolean startPumping(boolean fuel) {
		if(fuel ? this.spendFuel() : true) {
			System.out.println(this.getMachineName() + "\t\t-\tzacala cerpat vodu do vrtu.\n");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void stopPumping() {
		System.out.println(this.getMachineName() + "\t\t-\tprestala cerpat vodu do vrtu.\n");
	}
	
	public void machineIsBroken() {
		System.out.println(this.getMachineName() + "\t\t-\tzariadenie nedokaze cerpat vodu kvoli poskodeniu");
	}
}
