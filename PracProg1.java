

import java.text.DecimalFormat;
import java.util.Scanner;

public class PracProg1 {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		System.out.print("Enter a number: ");
		String ip = scanIn.nextLine();
		scanIn.close();
		
		double num;
		try {
			num = Double.parseDouble(ip);
		} catch (Exception e) {
			System.out.println("Input is not a valid number. Will terminate");
			e.printStackTrace();
			return;
		}
		
		System.out.println("The integer part is: " + (int)num);
		int intNum = (int)num;
		System.out.println("The new integer is: " + intNum);
		
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Number formatted to 2 dp: " + df.format(num));
		System.out.println("0 if even, 1 if odd: " + intNum%2);
		System.out.println("Paromita Datta");
	}
}