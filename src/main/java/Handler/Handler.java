package Handler;

import java.util.ArrayList;

public class Handler {

	public int handleResults(String input) {

		if (input.length() == 0) {
			throw new NullHandlerException("Входящая строка пуста или null");
		} else if (input.contains("error")) {
			throw new HandlerException("Содержит сочетание символов \'error\'");
		} else {
			int counter = 0;
			int number;
			String[] stroka = input.split("\\.");

			if ((stroka.length) == 0) {
				return 0;
			} else {
				for (String el : stroka) {
					if (el.matches("\\d+")) {
						counter++;
					}
				}

				if (counter == 0 || counter == 1 || counter == 2) {
					return 0;
				} else {
					int[] numbers = new int[counter];
					counter = 0;
					for (int i = 0; i < stroka.length; i++) {
						if (stroka[i].matches("\\d+")) {
							numbers[counter] = Integer.parseInt(stroka[i]);
							counter++;
						}
					}
					number = (numbers[0] + numbers[1]) - (numbers[numbers.length - 1] * numbers[numbers.length - 2]);
					if (number < 0) {
						throw new HandlerResultException("Результат вычисления меньше нуля");
					} else {
						return number;
					}
				}
			}
		}
	}

}
