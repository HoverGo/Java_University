package School;

public class Teacher extends Human {

	public String name;
	public String surname;
	public String subject;
	public int exp;
	boolean isInSchool;

	public Teacher(String name, String surname, String subject, int exp) {
		this.name = name;
		this.surname = surname;
		this.subject = subject;
		this.exp = exp;
	}

	public String toString() {
		return name + " " + surname + " " + subject + " " + exp;
	}

	public void goInSchool() {
		isInSchool = true;
	}

	public void outFromSchool() {
		isInSchool = false;
	}

	public boolean isInSchool() {
		return isInSchool;
	}

}
