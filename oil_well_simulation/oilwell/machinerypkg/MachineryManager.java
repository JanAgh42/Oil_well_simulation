package oilwell.machinerypkg;

import java.util.ArrayList;
import java.util.Random;
import oilwell.enumpkg.*;

public class MachineryManager {
	
	private ArrayList<Crane> listOfCranes;
	private ArrayList<WaterPump> listOfPumps;
	private ArrayList<Drill> listOfDrills;
	private Random random;
	private int craneFuel;
	private int pumpFuel;
	private int drillFuel;
	
	
	public MachineryManager() {
		this.listOfCranes = new ArrayList<Crane>();
		this.listOfPumps = new ArrayList<WaterPump>();
		this.listOfDrills = new ArrayList<Drill>();
		this.random = new Random();
		this.craneFuel = random.nextInt(13) * 10 + 120;
		this.pumpFuel = random.nextInt(9) * 10 + 80;
		this.drillFuel = random.nextInt(17) * 10 + 160;
	}
	
	
	
	public ArrayList<Crane> getCranes() {
		return this.listOfCranes;
	}
	
	public ArrayList<WaterPump> getPumps() {
		return this.listOfPumps;
	}
	
	public ArrayList<Drill> getDrills() {
		return this.listOfDrills;
	}
	
	public void addNewCrane(MachineNames machineName) {
		this.getCranes().add(new Crane(this.craneFuel, machineName));
	}
	
	public void addNewPump(MachineNames machineName) {
		this.getPumps().add(new WaterPump(this.pumpFuel, machineName));
	}
	
	public void addNewDrill(MachineNames machineName) {
		this.getDrills().add(new Drill(this.drillFuel, machineName));
	}
	
	public Crane getCrane(MachineNames machineName) {
		for(Crane crane : this.getCranes()) {
			if(crane.getMachineName().equals(machineName)) return crane;
		}
		return null;
	}
	
	public WaterPump getPump(MachineNames machineName) {
		for(WaterPump pump : this.getPumps()) {
			if(pump.getMachineName().equals(machineName)) return pump;
		}
		return null;
	}
	
	public Drill getDrill(MachineNames machineName) {
		for(Drill drill : this.getDrills()) {
			if(drill.getMachineName().equals(machineName)) return drill;
		}
		return null;
	}
}
