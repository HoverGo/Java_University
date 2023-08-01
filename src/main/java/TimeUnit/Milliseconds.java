package TimeUnit;

public class Milliseconds implements TimeUnit {

	private final long num;

	public Milliseconds(long num) {
		this.num = num;
	}

	public long toMillis() {
		return num;
	}

	public long toSeconds() {
		return Math.round((double) (num / 1000));
	}

	public long toMinutes() {
		double num1 = (double) num;
		return Math.round(num1 / 1000 / 60);
	}

	public long toHours() {
		return Math.round((double) (num / 1000 / 60));
	}

}
