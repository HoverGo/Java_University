package TimeUnit;

public class Minutes implements TimeUnit {

	private final long num;

	public Minutes(long num) {
		this.num = num;
	}

	public long toMillis() {
		return Math.round((double) (num * 60 * 1000));
	}

	public long toSeconds() {
		return Math.round((double) (num * 60));
	}

	public long toMinutes() {
		return num;
	}

	public long toHours() {
		return Math.round((double) (num / 60));
	}

}
