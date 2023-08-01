package Animal;

public class Monkey extends Animal {

	private String color;

	public Monkey(String name, int age, String color) {
		super(name, age);
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	@Override
	public String toString() {
		return "\'" + super.getName() + "\'" + ", age= " + super.getAge() + ", color= " + this.color;
	}

}
