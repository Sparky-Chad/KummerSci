package data;

public class PartTimeEmployee extends Employee {

   public PartTimeEmployee() {
      super();
   }
   
   public PartTimeEmployee(String name, double rate, int hour) {
	   super(name, rate, hour);
   }
  
   public double getPay() {
      double pay;
      pay = rate * hours;
      totalPay += pay;
      return pay;
   }
}

