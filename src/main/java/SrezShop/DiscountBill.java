package SrezShop;

import SrezShop.Bill.BillItem;

public class DiscountBill extends Bill {

	private double discount;

	public DiscountBill(double discount) {
		this.discount = discount;
	}

	public double getDiscount() {
		return this.discount;
	}

	@Override
	public long getPrice() {
		return (long) ((super.getPrice() * (1 - discount)));
	}

	@Override
	public String toString() {
		String discountText = "\nСкидка: " + discount*100 + "%";
		return super.toString().concat(null);
	}

}
