public class FullTimeEmployee extends Employee {

   public FullTimeEmployee(){
      super();
      LOW_HOURS = 30;
      LOW_RATE = 12.60;
   }
  
   public double getPay() {
      double pay;
      
      if (hours <= 40)
         pay = rate * hours;
      else
         pay = rate * 40 +  rate * 2 * (hours - 40);

      totalPay += pay;
      return pay;
   }
}

