package cs570;

public class AdvancedFizzBuzz {

	public static void main(String[] args) {
		int[] number = new int[241];
		for (int i = 10; i <= 250; i++) {
			number[i - 10] = i;
		}
		FizzBuzzer(number);
	}

	public static void FizzBuzzer(int[] intArray) {
		for (int i = 0; i < intArray.length; i++) {
			int j = intArray[i];
			if (j % 3 == 0 && j % 5 != 0) {
				System.out.println("Buzz");
			}
			if (j % 5 == 0 && j % 3 != 0) {
				System.out.println("Fizz");
				continue;
			}
			if (j % 3 == 0 && j % 5 == 0) {
				System.out.println("BuzzFizz");
				continue;
			}
			System.out.println(j);
		}
	}
}
