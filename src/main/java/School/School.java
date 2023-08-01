package School;

import java.util.ArrayList;

public class School {

	ArrayList<Human> peoplesInSchool = new ArrayList<>();

	public String getPeoplesInSchool() {
		String peoples = "В школе:\n";
		for (Human el : peoplesInSchool) {
			if (el.isInSchool()) {
				peoples += el.toString() + "\n";
			}
		}
		return peoples;
	}

	public void add(Human human) {
		peoplesInSchool.add(human);
	}

	public void goInSchool(Human human) {
		human.goInSchool();
	}

	public void outFromSchool(Human human) {
		human.outFromSchool();
	}

}
