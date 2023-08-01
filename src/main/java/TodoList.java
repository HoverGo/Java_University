import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TodoList doList = new TodoList();
		int num;
		while (true) {
			System.out.print("1. Вывести все дела с их порядковыми номерами.\n"
					+ "2. Добавить дело в конец списка дел\n3. Добавить дело в определённый индекс.\n"
					+ "4. Заменить дело.\n5. Удалить дело.\n0. Выход из списка дел\nВведите номер желаемой операции: ");
			num = input.nextInt();
			System.out.println();
			if (num == 0) {
				break;
			} else if (num == 1) {
				int nums = 1;
				for (String el : doList.getTodos()) {
					System.out.println(nums + ". " + el);
					nums++;
				}
			} else if (num == 2) {
				System.out.print("Введите дело для добавления: ");
				String task = input.next();
				doList.add(task);
			} else if (num == 3) {
				System.out.print("Введите дело для добавления: ");
				String task = input.next();
				System.out.print("Введите индекс на место которого небходимо поместить дело: ");
				int index = input.nextInt();
				doList.add(index, task);
			} else if (num == 4) {
				System.out.print("Введите дело для замены: ");
				String task = input.next();
				System.out.print("Введите индекс дела, которое следует заменить: ");
				int index = input.nextInt();
				doList.edit(task, index);
			} else if (num == 5) {
				System.out.print("Введите индекс дела, которое следует удалить: ");
				int index = input.nextInt();
				doList.delete(index);
			}

		}

	}

	private ArrayList<String> doList = new ArrayList<>();

	public void add(String todo) {
		doList.add(todo);
	}

	public void add(int index, String todo) {
		if (index < doList.size()) {
			doList.add(index, todo);
		}
	}

	public void edit(String todo, int index) {
		if (index < doList.size()) {
			doList.set(index, todo);
		}
	}

	public void delete(int index) {
		if (index < doList.size()) {
			doList.remove(index);
		}
	}

	public ArrayList<String> getTodos() {
		return this.doList;
	}
}