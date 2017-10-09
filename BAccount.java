
import java.util.ArrayList;

public class BAccount {
   private double bal;
   private double timeMonths;
   private int accNum;

    public BAccount(double moneys, double timePass, int index) {
      bal = moneys;
      timeMonths = timePass;
      accNum = index;
    }

    public double getBal() {
      return bal;
    }

    public double getTimeMonths() {
      return timeMonths;
    }

    public int getAccType() {
      return accNum;
    }
    
    public void setBal(double bal2) {
    	bal = bal2;
    }
}