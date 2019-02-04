
public class tester {
	public static void main(String args[]) {
		PartTimeEmployee[] pe = new PartTimeEmployee[3];
		FullTimeEmployee[] fe = new FullTimeEmployee[3];
		int j = 0;
		for(PartTimeEmployee f: pe) {
			f = new PartTimeEmployee();
			pe[j] = f;
			j++;
		}
		j=0;
		for(FullTimeEmployee f: fe) {
			f = new FullTimeEmployee();
			fe[j] = f;
			j++;
		}
		
		pe[0].setName("Jamie");
		pe[1].setName("Harlee");
		pe[2].setName("John");
		fe[0].setName("Ryan");
		fe[1].setName("Alex");
		fe[2].setName("Jackie");
		
		//filler
		for(int i = 0; i < 3; i++) {
			pe[i].setHours((int)((Math.random() + 2) * 58));
			fe[i].setHours((int)((Math.random() + 2) * 58));
			pe[i].setRate(((Math.random() + 6.75) * (30.50 - 6.75)));
			fe[i].setRate(((Math.random() + 6.75) * (30.50 - 6.75)));
		}
		
		System.out.println("Part Time:");
		for(int i = 0; i < 3; i++) {
			System.out.printf("Employee Name: %s \nRate: $%.2f\nHours: %d\n\ngross pay: $%.2f\n\n", pe[i].getName(), pe[i].rate, pe[i].hours, pe[i].getPay());
		}
		
		System.out.println("Full Time:");
		for(int i = 0; i < 3; i++) {
			System.out.printf("Employee Name: %s\nnRate: $%.2f\nHours: %d\n\ngross pay: $%.2f\n\n", fe[i].getName(), fe[i].rate, fe[i].hours, fe[i].getPay());
		}
		
		
	}
}
