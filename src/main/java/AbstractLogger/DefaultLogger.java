package AbstractLogger;

public class DefaultLogger extends AbstractLogger {
	
	
	public DefaultLogger(String name) {
		super(name);
	}
	
	@Override
	public String debug(String message) {
		return String.format("[%s] <%s> %s - %s", "DEBUG", this.getCalendar().getTime().toString(), this.getName(), message);
	}
	
	@Override
	public String info(String message) {
		return String.format("[%s] <%s> %s - %s", "INFO", this.getCalendar().getTime().toString(), this.getName(), message);
	}
	
	@Override
	public String warning(String message) {
		return String.format("[%s] <%s> %s - %s", "WARNING", this.getCalendar().getTime().toString(), this.getName(), message);
	}
	
	@Override
	public String error(String message) {
		return String.format("[%s] <%s> %s - %s", "ERROR", this.getCalendar().getTime().toString(), this.getName(), message);
	}
	
	@Override
	public String toString() {
		return String.format("%s — DefaultLogger", this.getName());
	}

}
