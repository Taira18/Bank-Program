public class Checking extends BAccount {
	private int with;
	private int withd = 0;// here

	public Checking(double moneys, double timePass, int accT, int withdraw) {
		super(moneys, timePass, accT);
		with = withdraw;

		// withd = withd + 1;// here

		if (withd > 3) { // here
			setBal(getBal() - 1);
		}
	}

	public double setIntre() {
		if (with > 3) {
			setBal(getBal() - 1);
		}
		return getBal();
	}

	public int getwith() {
		return with;
	}

	public void setWit(int set) {// ?? set
		with = 0;
	}

	public int getWithd() {
		return withd;
	}

	public void setWithd(int withdra) {
		withd = withdra;
	}

}