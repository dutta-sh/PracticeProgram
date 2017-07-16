package cs570;

import java.util.Scanner;

public class PracProg3 {
	
	public static void main(String[]args){
		int[] array = new int[]{50,40,30,20,10};
		System.out.println("Enter number to search:");
		Scanner sk = new Scanner(System.in);
		int search = Integer.parseInt(sk.nextLine());
		sk.close();
		
		
		if(searchVal(array,search)){
			System.out.println("Element" + search +" found");
		}
		else {
			System.out.println("Element" + search + " not found");
			
		}
		
	}
	
	public static boolean searchVal(int[] array, int search)
	{
		int searchPos = binarySearch(array, 0, array.length-1, search);
		return searchPos>=0 ? true : false;
	}

	public static int binarySearch(int[] array, int begin, int end, int search){
		System.out.println("Searching between" + begin + "and" + end);
		int half = (begin + end)/2;
		if(end<begin){
			return -1;
		}
		
		if (search < array[half]){
			return binarySearch(array, half-1, end, search);
		}
		else{
			System.out.println("Found at position:" + half);
			return half;
		}
	}
}
