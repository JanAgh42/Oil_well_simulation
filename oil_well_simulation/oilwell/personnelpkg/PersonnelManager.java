package oilwell.personnelpkg;

import java.util.ArrayList;

import oilwell.enumpkg.*;

public class PersonnelManager {

	private ArrayList<Worker> listOfWorkers;
	private ArrayList<Repairman> listOfRepairmen;
	
	
	
	public PersonnelManager() {
		this.listOfWorkers  = new ArrayList<Worker>();
		this.listOfRepairmen  = new ArrayList<Repairman>();
	}
	
	
	
	public ArrayList<Worker> getWorkers(){
		return this.listOfWorkers;
	}
	
	public ArrayList<Repairman> getRepairmen(){
		return this.listOfRepairmen;
	}
	
	
	
	public void addNewWorker(PersonnelNames personnelName) {
		this.getWorkers().add(new Worker(personnelName));
	}
	
	public void addNewRepairman(PersonnelNames personnelName) {
		this.getRepairmen().add(new Repairman(personnelName));
	}
	
	
	
	public Worker getWorker(PersonnelNames personnelName) {
		for(Worker worker : this.getWorkers()) {
			if(worker.getPersonnelName().equals(personnelName)) return worker;
		}
		return null;
	}
	
	public Repairman getRepairman(PersonnelNames personnelName) {
		for(Repairman repairman : this.getRepairmen()) {
			if(repairman.getPersonnelName().equals(personnelName)) return repairman;
		}
		return null;
	}
	
	public Worker getAvailableWorker() {
		for(Worker worker: this.getWorkers()) {
			if(worker.getAvailability()) return worker;
		}
		return null;
	}
	
	public Repairman getAvailableRepairman() {
		for(Repairman repairman: this.getRepairmen()) {
			if(repairman.getAvailability()) return repairman;
		}
		return null;
	}
}
