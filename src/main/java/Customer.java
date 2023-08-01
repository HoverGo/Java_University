

public class Customer {
	
	private String name;
	private String surname;
	
	public Customer (String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public void getName() {
		System.out.println(name);
	}
	
	public void getSurname() {
		System.out.println(surname);
	}

}
