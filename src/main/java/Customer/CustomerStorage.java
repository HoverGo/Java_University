package Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerStorage {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		CustomerStorage customerStorage = new CustomerStorage();
		String[] stroka;
		while (true) {
			System.out.print(
					"Format: \"command name surname email phone\"\nadd - добавить клиента\nlist - вывести список всех клиентов\nremove - удалить клиента\ncount - подсчитать количество клиентов\nhelp - вывести пример команды");
			stroka = input.next().split(" ");
			System.out.println();

			if (stroka.length < 5 || stroka.length > 5) {
				System.out.println("Неверный формат команды");
			} else if (stroka[0].equals("help")) {
				System.out.println("Пример команды - \"add hova bova kitikat@gmail.com 89097271422\"");
			} else if (stroka[0].equals("add")) {
				customerStorage.addCustomer(stroka[1] + " " + stroka[2] + " " + stroka[3] + " " + stroka[4]);
			} else if (stroka[0].equals("list")) {
				System.out.println(customerStorage.listCustomers());
			} else if (stroka[0].equals("remove")) {
				if (customerStorage.removeCustomer(stroka[1] + " " + stroka[2])) {
					System.out.println("Пользователь удалён");
				} else {
					System.out.println("Пользователь не найден");
				}
			} else if (stroka[0].equals("count")) {
				System.out.println(customerStorage.getCount());
			}

		}

	}

	ArrayList<Customer> customerList = new ArrayList<>();

	public void addCustomer(String input) {
		String[] stroka = input.split(" ");
		if (stroka.length > 4 || stroka.length < 4) {
			throw new WrongElementInputString("Введено неправильное количество элементов");
		} else {
			boolean trueMail = stroka[2].split("@").length == 2;
			boolean truePhone = ((stroka[3].length() == 11) && !stroka[3].startsWith("+")
					&& stroka[3].substring(1, stroka[3].length()).matches("\\d+"))
					|| ((stroka[3].length() == 12) && stroka[3].startsWith("+")
							&& stroka[3].substring(1, stroka[3].length()).matches("\\d+"));
			if (trueMail && truePhone) {
				customerList.add(new Customer(stroka[0], stroka[1], stroka[2], stroka[3]));
			} else if (!trueMail) {
				throw new ThisIsNotAnEmail("Неверный формат электронной почты");
			} else if (!truePhone) {
				throw new ThisIsNotANumber("Неверный формат телефона");
			}
		}
	}

	public ArrayList listCustomers() {
		return customerList;
	}

	public boolean removeCustomer(String input) {
		String[] stroka = input.split(" ");
		for (Customer customer : customerList) {
			if (customer.getName().equals(stroka[0]) && customer.getSurname().equals(stroka[1])) {
				customerList.remove(customer);
				return true;
			}
		}
		return false;
	}

	public Customer getCustomer(String input) {
		String[] stroka = input.split(" ");
		for (Customer customer : customerList) {
			if (customer.getName().equals(stroka[0]) && customer.getSurname().equals(stroka[1])) {
				return customer;
			}
		}
		return null;
	}

	public int getCount() {
		return customerList.size();
	}
}
