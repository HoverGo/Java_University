import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Hospital {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Введите количество пациентов");
		int countPatients = input.nextInt();
		System.out.println();
		Hospital hospital = new Hospital(countPatients);
		int num;
		while (true) {
			System.out.print("1. Сгенерировать температуру для пациентов.\n"
					+ "2. Вычислить количество здоровых пациентов\n3. Получить строку температур из массива.\n"
					+ "4. Вычислить среднюю температуру.\n5. Создать отчёт.\n0. Выход из больницы\nВведите номер желаемой операции: ");
			num = input.nextInt();
			System.out.println();
			if (num == 0) {
				break;
			} else if (num == 1) {
				System.out.println(hospital.generatePatientsTemperatures());
			} else if (num == 2) {
				System.out.println(hospital.getCountHealthy());
			} else if (num == 3) {
				System.out.println(hospital.getTemperaturesToString());
			} else if (num == 4) {
				System.out.println(hospital.getAverageTemp());
			} else if (num == 5) {
				System.out.println(hospital.getReport());
			}

		}

	}

	private int patientsCount;
	private float[] patientsTemperatures;
	private boolean gPT = false;
	private boolean gCH = false;
	private boolean gTTS = false;
	private boolean gAT = false;
	private boolean gR = false;
	private int countHealthly;
	private String temperaturesToString;
	private double averageTemp;
	private String report;

	public Hospital(int patientsCount) {
		// TODO создание больницы с указанным кол-вом пациентов
		// если значение не верное, бросать IllegalArgumentException с помощью метода
		// throw new <Exception.class>
		if (patientsCount > 0) {
			this.patientsCount = patientsCount;
		} else {
			throw new IllegalArgumentException();
		}

	}

	// нужно кол-во пациентов
	public float[] generatePatientsTemperatures() {
		// TODO реализовать генерацию массива температур от 32 до 40 градусов
		float[] patientsTemperatures = new float[patientsCount];

		for (int i = 0; i < patientsTemperatures.length; i++) {
			patientsTemperatures[i] = (float) (Math.round(((float) (Math.random() * (40 - 32)) + 32) * 10.0) / 10.0);
		}
		gPT = true;
		this.patientsTemperatures = patientsTemperatures;
		return patientsTemperatures;
	}

	// нужна генерация температур
	public int getCountHealthy() {
		// TODO реализовать подсчёт кол-ва здоровых(36,2 < x < 36,9) в сгенерированном
		// массиве температур
		// если метод уже был вызван ранее, не выполнять подсчет снова, а возращать
		// текущее вычисленное значение
		// если генерация температур не была выполнена, вызвать метод генерации
		int count = 0;
		if (gCH == true) {
			return this.countHealthly;
		}

		if (gPT == false) {
			generatePatientsTemperatures();
		}
		for (float el : patientsTemperatures) {
			if (el > 36.2 && el < 36.9) {
				count++;
			}
		}

		gCH = true;
		this.countHealthly = count;
		return count;
	}

	// нужна генерация температур
	public String getTemperaturesToString() {
		// TODO реализовать получение массива температур в виде строки <double>,
		// <double>, <double>
		// если метод уже был вызван ранее, не выполнять подсчет снова, а возращать
		// текущее вычисленное значение
		// если генерация температур не была выполнена, вызвать метод генерации
		String text = "";
		if (gTTS == true) {
			return this.temperaturesToString;
		}
		if (gPT == false) {
			generatePatientsTemperatures();
		}

		for (float el : patientsTemperatures) {
			text += (Float.toString(el).replace('.', ',') + " ");
		}
		text = text.substring(0, text.length() - 1);

		gTTS = true;
		this.temperaturesToString = text;
		return text;
	}

	// Нужна генерация температур
	public double getAverageTemp() {
		// TODO реализовать получение средней температуры из массива
		// если метод уже был вызван ранее, не выполнять подсчет снова, а возращать
		// текущее вычисленное значение
		// если генерация температур не была выполнена, вызвать метод генерации
		double averageTemp = 0;
		double sum = 0;
		if (gAT == true) {
			return this.averageTemp;
		}

		if (gPT == false) {
			generatePatientsTemperatures();
		}

		for (float el : patientsTemperatures) {
			sum += el;
		}
		averageTemp = sum / (patientsTemperatures.length);

		gAT = true;
		this.averageTemp = averageTemp;
		return averageTemp;
	}

	// нужны температуры, средняя температура и кол-во здоровых
	public String getReport() {
		// TODO реализовать получение отчёта в формате приложенном ниже
		// если метод уже был вызван ранее, не выполнять подсчет снова, а возращать
		// текущее вычисленное значение
		// если все необходимые переменные не были получены ранее, вызвать все методы
		// необходимые для получения отчёта
		/*
		 * TODO Формат вывода: Температуры пациентов: 37,5 36,9 38,2 33,5 32,2 Средняя
		 * температура: 35,67 Количество здоровых: 1
		 */
		String report = "";
		if (gR == true) {
			return this.report;
		}
		if (gPT == false) {
			generatePatientsTemperatures();
		}
		if (gCH == false) {
			getCountHealthy();
		}
		if (gTTS == false) {
			getTemperaturesToString();
		}
		if (gAT == false) {
			getAverageTemp();
		}

		report += "Температуры пациентов: " + temperaturesToString + "\nСредняя температура: "
				+ Double.toString((Math.round(averageTemp * 100.0) / 100.0)).replace('.', ',')
				+ "\nКоличество здоровых: " + countHealthly;

		gR = true;
		this.report = report;
		return report;
	}
}