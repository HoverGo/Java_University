package Customer;

public class Customer {
	
	private final String name;
	private final String surname;
	private final String email;
	private final String phone;
	
	
	public Customer(String name, String surname, String email, String phone) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String toString() {
		return String.format("%s - %s - %s - %s", name, surname, email, phone);
	}

}
