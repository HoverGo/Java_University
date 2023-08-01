package TimeUnit;

public class TimeUnitUtils {

	public static Milliseconds toMillis(TimeUnit a) {
		return new Milliseconds(a.toMillis());
	}

	public static Seconds toSeconds(TimeUnit a) {
		return new Seconds(a.toSeconds());
	}

	public static Hours toHours(TimeUnit a) {
		return new Hours(a.toHours());
	}

}
