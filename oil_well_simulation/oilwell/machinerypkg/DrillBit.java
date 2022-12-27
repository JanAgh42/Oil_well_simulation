package oilwell.machinerypkg;

public class DrillBit extends Tools{

	private final int ID;
	
	public DrillBit(int ID, boolean isActive){
		super(isActive);
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
}
