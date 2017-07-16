package cs570;

import java.util.Scanner;

/*public class FactorialDemo {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Integer nmbr = -1;
		while(nmbr<0){
			System.out.println(" Enter a positive number ");
			try{
			nmbr = Integer.parseInt(sc.nextLine());
			}
			catch (Exception e){
			 System.out.println("You have entered a non numeric value");
			}
		}
		Integer fct = fact(nmbr);
		System.out.println(" Factorial of number " +nmbr+ " is: " + fct);
		sc.close();
	}
	
static int fact(Integer nmbr){
		Integer result;
		if(nmbr == 1 || nmbr == 0)
			return 1;
		else
			result = fact(nmbr-1)*nmbr;
		return result;
	}
}*/

public class FactorialDemo
{
	public static void main(String args[])
	{
		Integer counter;
		Integer fact = 1;
		System.out.println(" Enter a positive number: ");
		Scanner sc = new Scanner(System.in);
		Integer nmbr = Integer.parseInt(sc.nextLine());
		if(nmbr<0)
			System.out.println("Number should be non negative ");
		else {
			for ( counter =1; counter <= nmbr; counter++ )
				fact = fact* counter;
			System.out.println(" Factorial of number " +nmbr+ " is: " + fact);
		}
	}
}