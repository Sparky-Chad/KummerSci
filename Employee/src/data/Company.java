package data;

import java.util.ArrayList;

import Util.RanMap;

public class Company {
	private RanMap ran;
	private ArrayList<FullTimeEmployee> femp = new ArrayList<FullTimeEmployee>();
	private ArrayList<PartTimeEmployee> pemp = new ArrayList<PartTimeEmployee>();
	
	public Company() {
		
		femp = new ArrayList<FullTimeEmployee>();
		pemp = new ArrayList<PartTimeEmployee>();
		ran = new RanMap();
		
		genEmploy(100, 100);
		sort();
	}
	
	
	//create all the employees
	public void genEmploy(int fulltime, int parttime) {
		for(int i = 0; i < fulltime; i++) {
			newFTEmployee();
		}
		for(int i = 0; i < parttime; i++) {
			newPTEmployee();
		}
	}

	public void newPTEmployee() {
		newPTEmployee(ran.getName(), (int)(Math.random() * 15) + 5, (double)(Math.random() * 10 + 8.25));
	}
	public void newPTEmployee(String name, int hour, double rate) {
		pemp.add(new PartTimeEmployee(name, rate, hour));
	}
	
	public void newFTEmployee() {
		newFTEmployee(ran.getName(), (int)(Math.random() * 35) + 5, (Math.random() * 30 + 8.25));
	}
	public void newFTEmployee(String name, int hours, double rate) {
		femp.add(new FullTimeEmployee(name, rate, hours));
		
	}
	
	public void sort() {
		//first sort the full time employees
		for(int i = 0; i < femp.size(); i++) {
			
			for(int j = 1; j < femp.size(); j++) {
				String current = femp.get(j-1).getName();
				if(current.compareToIgnoreCase(femp.get(j).getName()) > 0) {
					FullTimeEmployee temp = femp.get(j-1);
					femp.set(j-1, femp.get(j));
					femp.set(j, temp);
				}
				
			}
		}
		for(int i = 0; i < pemp.size(); i++) {
				
				for(int j = 1; j < pemp.size(); j++) {
					String current = pemp.get(j-1).getName();
					if(current.compareTo(pemp.get(j).getName()) > 0) {
						PartTimeEmployee temp = pemp.get(j-1);
						pemp.set(j-1, pemp.get(j));
						pemp.set(j, temp);
					}
					
				}
			}
	}
	
	public String search(String lastName) {
		for(FullTimeEmployee iterator: femp) {
			if(iterator.getName().equalsIgnoreCase(lastName)) {
				return iterator.toString();
			}
		}
		for(PartTimeEmployee iterator: pemp) {
			if(iterator.getName().equalsIgnoreCase(lastName)) {
				return iterator.toString();
			}
		}
		return "Employee not found\n";
	}
	
	public int size() {
		return femp.size() + pemp.size();
	}
	public String get(int i) {
		if(i < femp.size()) {
			return femp.get(i).toString();
		}
		if((i-femp.size()) < pemp.size()) {
			return pemp.get(i-femp.size()).toString();
		}
		else {
			return "Employee not found";
		}
	}
	public String toString() {
		String out = "";
		out += "Full Time:\n";
		for(FullTimeEmployee f: femp) {
			out += f.toString() + "\n";
		}
		out+="Part Time:\n";
		for(PartTimeEmployee p: pemp) {
			out += p.toString() + "\n";
		}
		return out;
	}
	
	
}
