package AbstractLogger;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.GregorianCalendar;

public abstract class AbstractLogger {


	private Calendar calendar = new GregorianCalendar();
	public String name;

	abstract public String debug(String message);

	abstract public String info(String message);

	abstract public String warning(String message);

	abstract public String error(String message);

	public void setCalendar(TimeZone timeZone, int year, int month, int day, int hours, int minutes, int seconds) {
		TimeZone.setDefault(timeZone);
		calendar.setTimeZone(timeZone);
		calendar.set(year, month, day, hours, minutes, seconds);
		// TODO метод для установки даты для календаря
	}

	public AbstractLogger(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public String toString() {
		return String.format("name %s", name);
	}

}
