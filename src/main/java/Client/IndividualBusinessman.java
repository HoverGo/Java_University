package Client;

	public class IndividualBusinessman extends Client {
	
		private double amount = 0;
		
		@Override
		public double getAmount() {
			return amount;
		}
		
		
		@Override
		public void put(double summ) {
			if (summ > 0) {
				if (summ < 1000) {
					this.amount = this.amount + (summ - (summ / 100));
				} else if (summ >= 1000) {
					this.amount = this.amount + (summ - (summ / 200));
				}
	
				System.out.println(this.amount);
			}
	
		}
	
		@Override
		public void take(double summ) {
			if (summ >= 0 && summ <= this.amount) {
				this.amount = this.amount - summ;
			}
	
		}
	
	}
