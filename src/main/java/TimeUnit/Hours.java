package TimeUnit;

public class Hours implements TimeUnit {

	private final long num;

	public Hours(long num) {
		this.num = num;
	}

	public long toMillis() {
		return Math.round((double) (num * 60 * 60 * 1000));
	}

	public long toSeconds() {
		return Math.round((double) (num * 60 * 60));
	}

	public long toMinutes() {
		return Math.round((double) num * 60);
	}

	public long toHours() {
		return num;
	}

}
