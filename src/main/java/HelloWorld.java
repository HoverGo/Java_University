public class HelloWorld {

	public static void main() {
		System.out.println("Hello, World!");
	}
	
	public static int reverseInt(int num) {
		String reverse = Integer.toString(num);
		int revInt = Integer.parseInt(new StringBuilder(reverse).reverse().toString());
		return revInt;
	}

	public static int numMin(int[] arr) {
		int min = arr[0];
		int minIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] <= min) {
				min = arr[i];
				minIndex = i;
			}

		}

		return minIndex;
	}
}