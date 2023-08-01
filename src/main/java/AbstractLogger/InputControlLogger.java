package AbstractLogger;

public class InputControlLogger extends AbstractLogger {

	public InputControlLogger(String name) {
		super(name);
	}

	@Override
	public String info(String message) {
		return String.format("[%s] <%s> %s %s", "INFO", this.getCalendar().getTime().toString(),
				"Вход пользователя:", "message");
	}

	@Override
	public String debug(String message) {
		return String.format("[%s] <%s> %s %s", "DEBUG", this.getCalendar().getTime().toString(), "Обнаружен пользователь:",
				"message");
	}

	@Override
	public String error(String message) {
		return String.format("[%s] <%s> %s %s", "ERROR", this.getCalendar().getTime().toString(),
				"Не удалось найти данные пользователя:", "message");
	}

	@Override
	public String warning(String message) {
		return String.format("[%s] <%s> %s %s", "WARNING", this.getCalendar().getTime().toString(),
				"Обнаружен неавторизованный доступ в систему:", "message");
	}

	@Override
	public String toString() {
		return String.format("%s — InputControlLogger", this.getName());
	}

}
