package cs570;

public class Ex1 {

	public static void main(String[] args) {
		Ex1 ex1 = new Ex1();
		//ex1.printToI(10);
		//ex1.printFactorial(10);
		System.out.println(ex1.factorialRecursive(5));
	}
	
	public void printToI(int i) {
		for (int j = 0; j <= i; j++) {
			for(int k =0; k <= j; k++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	public void printFactorial(int n) {
		int val = n;
		for (int j = n - 1; j >= 1; j--) {
			System.out.println(val + " X " + j + " = " + (val*j));
			val = val * j;
		}
	}
	
	public int factorialRecursive(int n) {
		if(n > 1) {
			System.out.print(n + " X ");
			return n * factorialRecursive(n - 1);
		} else {
			System.out.print(n + " = ");
			return 1;
		}
	}
}