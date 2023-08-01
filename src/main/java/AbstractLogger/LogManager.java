package AbstractLogger;

import java.util.ArrayList;

public class LogManager {

	ArrayList<AbstractLogger> loggerList = new ArrayList<>();

	public void addLogger(AbstractLogger logger) {
		loggerList.add(logger);
	}

	public AbstractLogger getLogger(String name) {
		AbstractLogger logger = null;
		for (AbstractLogger loggerCheck : loggerList) {
			if (loggerCheck.getName().equals(name)) {
				logger = loggerCheck;
			}
		}
		return logger;
	}

	public String printLoggers() {
		String loggersNameString = "";
		for (AbstractLogger logger : loggerList) {
			loggersNameString += logger.toString() + "\n";
		}
		return loggersNameString;
	}

}
