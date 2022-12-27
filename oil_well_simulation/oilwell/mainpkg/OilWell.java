package oilwell.mainpkg;
import oilwell.enumpkg.*;
import oilwell.machinerypkg.*;
import oilwell.personnelpkg.*;
import java.util.Random;

public class OilWell {
	
	static PersonnelManager personnel;
	static MachineryManager machinery;
	
	static MachineNames[] machinesAtSite = {null, null, null};

	public static void main(String[] args) {
		
		personnel = new PersonnelManager();
		machinery = new MachineryManager();
		
		Random random = new Random();
		int targetDrillingDepth = random.nextInt(17) * 10 + 40, counter = 0;
		
		personnel.addNewWorker(PersonnelNames.PRACOVNIK1);
		personnel.addNewWorker(PersonnelNames.PRACOVNIK2);
		personnel.addNewWorker(PersonnelNames.PRACOVNIK3);
		personnel.addNewRepairman(PersonnelNames.HLAVNY_OPRAVAR);
		personnel.addNewRepairman(PersonnelNames.POMOCNIK);
		machinery.addNewCrane(MachineNames.HLAVNY_ZERIAV);
		machinery.addNewCrane(MachineNames.ZALOZNY_ZERIAV);
		machinery.addNewPump(MachineNames.HLAVNA_PUMPA);
		machinery.addNewPump(MachineNames.ZALOZNA_PUMPA);
		machinery.addNewDrill(MachineNames.HLAVNA_VRTACKA);
		machinery.addNewDrill(MachineNames.ZALOZNA_VRTACKA);
		
		while(Drill.getCurrentDepth() < targetDrillingDepth) {
			if(machinesAtSite[0] == null) {
				machinesAtSite[0] = MachineNames.HLAVNA_VRTACKA;
				personnel.getWorker(PersonnelNames.PRACOVNIK1).getMachineFromStorage(machinery.getDrill(machinesAtSite[0]));
				personnel.getWorker(PersonnelNames.PRACOVNIK1).transportMachineToDrilling();
			}
			if(machinesAtSite[1] == null) {
				machinesAtSite[1] = MachineNames.HLAVNY_ZERIAV;
				personnel.getWorker(PersonnelNames.PRACOVNIK2).getMachineFromStorage(machinery.getCrane(machinesAtSite[1]));
				personnel.getWorker(PersonnelNames.PRACOVNIK2).transportMachineToDrilling();
			}
			if(machinesAtSite[2] == null) {
				machinesAtSite[2] = MachineNames.HLAVNA_PUMPA;
				personnel.getWorker(PersonnelNames.PRACOVNIK3).getMachineFromStorage(machinery.getPump(machinesAtSite[2]));
				personnel.getWorker(PersonnelNames.PRACOVNIK3).transportMachineToDrilling();
			}
			
			if(!machinery.getCrane(machinesAtSite[1]).liftDrillBit(new DrillBit(++counter, true))) {
				refuelAndChangeMachines(PersonnelNames.PRACOVNIK2, 1, MachineNames.HLAVNY_ZERIAV, MachineNames.ZALOZNY_ZERIAV);
				machinery.getCrane(machinesAtSite[1]).liftDrillBit(new DrillBit(counter, true));
			}
			if(!machinery.getCrane(machinesAtSite[1]).attachDrillBitToDrill(machinery.getDrill(machinesAtSite[0]))) {
				refuelAndChangeMachines(PersonnelNames.PRACOVNIK2, 1, MachineNames.HLAVNY_ZERIAV, MachineNames.ZALOZNY_ZERIAV);
				machinery.getCrane(machinesAtSite[1]).liftDrillBit(new DrillBit(counter, true));
				machinery.getCrane(machinesAtSite[1]).attachDrillBitToDrill(machinery.getDrill(machinesAtSite[0]));
			}
			if(!machinery.getPump(machinesAtSite[2]).startPumping(true)) {
				refuelAndChangeMachines(PersonnelNames.PRACOVNIK3, 2, MachineNames.HLAVNA_PUMPA, MachineNames.ZALOZNA_PUMPA);
				machinery.getPump(machinesAtSite[2]).startPumping(true);
			}
			if(!machinery.getDrill(machinesAtSite[0]).startDrilling()) {
				machinery.getPump(machinesAtSite[2]).stopPumping();
				refuelAndChangeMachines(PersonnelNames.PRACOVNIK1, 0, MachineNames.HLAVNA_VRTACKA, MachineNames.ZALOZNA_VRTACKA);	
				machinery.getPump(machinesAtSite[2]).startPumping(false);
				machinery.getDrill(machinesAtSite[0]).startDrilling();
			}
			machinery.getDrill(machinesAtSite[0]).stopDrilling();
			machinery.getPump(machinesAtSite[2]).stopPumping();
		}
		System.out.println("\nKoniec vrtania, ropny vrt hlbky " + targetDrillingDepth + "m sa podarilo vyvrtat.");
	}
	
	public static void refuelAndChangeMachines(PersonnelNames name, int ID, MachineNames machine1, MachineNames machine2) {
		personnel.getWorker(name).removeMachineFromDrilling();
		if(ID == 0) {
			personnel.getRepairman(PersonnelNames.HLAVNY_OPRAVAR).refillFuelTank(machinery.getDrill(machinesAtSite[ID]), personnel.getRepairman(PersonnelNames.POMOCNIK));
			personnel.getRepairman(PersonnelNames.POMOCNIK).transportMachineToStorage(machinery.getDrill(machinesAtSite[ID]));
			}
		if(ID == 1) {
			personnel.getRepairman(PersonnelNames.HLAVNY_OPRAVAR).refillFuelTank(machinery.getCrane(machinesAtSite[ID]), personnel.getRepairman(PersonnelNames.POMOCNIK));
			personnel.getRepairman(PersonnelNames.POMOCNIK).transportMachineToStorage(machinery.getCrane(machinesAtSite[ID]));
		}
		if(ID == 2) {
			personnel.getRepairman(PersonnelNames.HLAVNY_OPRAVAR).refillFuelTank(machinery.getPump(machinesAtSite[ID]), personnel.getRepairman(PersonnelNames.POMOCNIK));
			personnel.getRepairman(PersonnelNames.POMOCNIK).transportMachineToStorage(machinery.getPump(machinesAtSite[ID]));
		}
		machinesAtSite[ID] = (machinesAtSite[ID] == machine1 ? machine2 : machine1);
		if(ID == 0) personnel.getWorker(PersonnelNames.PRACOVNIK1).getMachineFromStorage(machinery.getDrill(machinesAtSite[ID]));
		if(ID == 1)	personnel.getWorker(PersonnelNames.PRACOVNIK2).getMachineFromStorage(machinery.getCrane(machinesAtSite[ID]));
		if(ID == 2) personnel.getWorker(PersonnelNames.PRACOVNIK3).getMachineFromStorage(machinery.getPump(machinesAtSite[ID]));
		personnel.getWorker(name).transportMachineToDrilling();
	}
}
