public class PartTimeEmployee extends Employee {

   public PartTimeEmployee() {
      super();
	  HIGH_HOURS = 40;
	  HIGH_RATE = 22.5;
   }

  
   public double getPay() {
      double pay;
      pay = rate * hours;
      totalPay += pay;
      return pay;
   }
}

