package Animal;

import java.util.ArrayList;

public class Zoo {

	ArrayList<Animal> animalList = new ArrayList<>();

	public void add(Animal animal) {
		animalList.add(animal);
	}
	
	public int getSize() {
		return animalList.size();
	}
	
	public String getReport() {
		int num = 1;
		String report = "";
		for (Animal animal : animalList) {
			report += num + " " + animal.toString() + "\n";
			num++;
		}
		return report;
	}

}
