package Animal;

public class Lion extends Animal {

	private double bodyLength;

	public Lion(String name, int age, Double bodyLength) {
		super(name, age);
		this.bodyLength = bodyLength;
	}

	public double getBodyLength() {
		return this.bodyLength;
	}

	@Override
	public String toString() {
		return "\'" + super.getName() + "\'" + ", age= " + super.getAge() + ", bodyLength= " + this.bodyLength;
	}

}
