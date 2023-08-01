package Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Movements {

	public ArrayList<Product> products = new ArrayList<>();

	public Movements(String path) {
		// TODO реализуйте сохранение строк в объекты в конструкторе
		List<String> fileLines;
		try {
			fileLines = Files.readAllLines(Paths.get(path));
			for (String fileLine : fileLines) {
				String[] splitedText = fileLine.split(",");
				ArrayList<String> columnList = new ArrayList<String>();

				for (int i = 0; i < splitedText.length; i++) {

					if (IsColumnPart(splitedText[i])) {
						String lastText = columnList.get(columnList.size() - 1);
						columnList.set(columnList.size() - 1, lastText + "," + splitedText[i]);
					} else {
						columnList.add(splitedText[i]);
					}

				}
				Product product = new Product();
				product.setType(columnList.get(0));
				product.setAccNum(columnList.get(1));
				product.setCurrency(columnList.get(2));
				product.setDate(columnList.get(3));
				product.setReference(columnList.get(4));
				product.setOverview(columnList.get(5));
				product.setPlus(columnList.get(6));
				product.setMinus(columnList.get(7));
				products.add(product);

			}
		} catch (IOException e) {
		}
		
		products.remove(0);


	}

	private boolean IsColumnPart(String text) {
		String trimText = text.trim();
		// Если в тексте одна ковычка и текст на нее заканчиваеться значит это часть
		// предыдущей колонки
		return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
	}

	public double getExpenseSum() {
		// TODO метод получения расходов
		
		double summ = 0;
		for (int i = 0; i < products.size(); i++) {
			String stroka = products.get(i).getMinus();
			if (stroka.substring(0,1).equals("\"")) {
				stroka = stroka.substring(1, stroka.length()-1).replace(',', '.');
				summ += Double.parseDouble(stroka);
			} else {
				summ += Double.parseDouble(stroka);
			}
		}
		return summ;
	}

	public double getIncomeSum() {
		// TODO метод получения доходов

		double summ = 0;
		for (int i = 0; i < products.size(); i++) {
			String stroka = products.get(i).getPlus();
			if (stroka.substring(0,1).equals("\"")) {
				stroka = stroka.substring(1, stroka.length()-1).replace(',', '.');
				summ += Double.parseDouble(stroka);
			} else {
				summ += Double.parseDouble(stroka);
			}
		}
		return summ;
	}

	public ArrayList<String> getListOfExpenses() {
		// TODO метод получения расходов по организациям в виде строк
		// Пример строк:
		// /RU/CARD2CARD ALFA_MOBILE>MOSCOW —> 51000,00 руб.
		// \643\MOSKVA\Alfa Iss —> 353000,00 руб.
		// \643\MOSKVA\YANDEX TAXI —> 484,00 руб.
		
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> promResults = new ArrayList<>();
		HashMap<String, Double> expense = new HashMap<>();
		
		for (Product product : products) {
			String organization = product.getOverview().split(" +", 2)[1].split(" {3,}")[0];
			if (organization.contains("\\")) organization = organization.substring(organization.indexOf("\\"));
			if (organization.contains("/")) organization = organization.substring(organization.indexOf("/"));
			promResults.add(organization + "," + product.getMinus());
			
			expense.put(organization, 0.00);
		}
		
		for (Product product : products) {
			String organization = product.getOverview().split(" +", 2)[1].split(" {3,}")[0];
			if (organization.contains("\\")) organization = organization.substring(organization.indexOf("\\"));
			if (organization.contains("/")) organization = organization.substring(organization.indexOf("/"));
			promResults.add(organization + "," + product.getMinus());
			
			String stroka = product.getMinus();
			if (stroka.substring(0,1).equals("\"")) {
				stroka = stroka.substring(1, stroka.length()-1).replace(',', '.');
				expense.put(organization, (expense.get(organization) + Double.parseDouble(stroka) ));
			} else {
				expense.put(organization, (expense.get(organization) + Double.parseDouble(stroka) ));
			}
			
		}
		
		for (String key : expense.keySet()) {
			result.add(key + " -> " + expense.get(key));
		}
		
		return result;
	}
}