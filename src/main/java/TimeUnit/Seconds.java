package TimeUnit;

public class Seconds implements TimeUnit {

	private final long num;

	public Seconds(long num) {
		this.num = num;
	}

	public long toMillis() {
		return Math.round((double) (num * 1000));
	}

	public long toSeconds() {
		return num;
	}

	public long toMinutes() {
		double num1 = (double) num;
		return Math.round(num1 / 60);
	}

	public long toHours() {
		return Math.round((double) (num / 60 / 60));
	}

}
