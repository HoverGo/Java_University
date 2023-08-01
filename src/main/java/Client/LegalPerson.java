package Client;

public class LegalPerson extends Client {

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
		if ((summ + (summ / 100)) <= this.amount) {
			this.amount = this.amount - (summ + (summ / 100));
		}

	}

}
