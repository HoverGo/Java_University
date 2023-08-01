package Client;

public class PhysicalPerson extends Client {

	private double amount = 0;
	
	@Override
	public double getAmount() {
		return amount;
	}
	
	@Override
	public void put(double summ) {
		if (summ > 0) {
			this.amount = this.amount + summ;
		}

	}

	@Override
	public void take(double summ) {
		if (summ >= 0 && summ <= this.amount) {
			this.amount = this.amount - summ;
		}

	}

}
