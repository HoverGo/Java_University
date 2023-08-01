package School;

public class Pupil extends Human {

	final public String name;
	final public String surname;
	public int year;
	boolean isInSchool;

	public Pupil(String name, String surname, int year) {
		this.name = name;
		this.surname = surname;
		this.year = year;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getYear() {
		return this.year;
	}
	
	public String toString() {
		return name + " " + surname + " " + year;
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
