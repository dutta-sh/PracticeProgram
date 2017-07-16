package cs570;/*
  GROUP DETAILS
  =============
  GROUP MEMBERS	: PAROMITA DATTA, & PARAS GARG
  GROUP SECTION	: CS 570-LA 
  LAB ASSIGNMENT 2 / WEEK 3 

*/

// importing packages
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CaesarCipher{
	
	public static void main(String args[]) {
		// variables declaration
		Scanner inp = new Scanner(System.in);
		String fName = "", message, decipherMessage = "";
		int key;

		// user input :: enter file name
		System.out.print("Enter file name :: ");
		fName = inp.nextLine();
		
		// reading the file
		byte[] byteRead = null;
		try {
			byteRead = Files.readAllBytes(Paths.get(fName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		message = new String(byteRead);
				
		key = 5 - 2;							// starting value of key
		for (int i = 0; i < message.length(); i++) {
			if (i % 3 == 0) key = key + 2;	// increase key by 2 after every 3 characters
			key = key % 26;					// key value can't be more than 26
						
			char data = message.charAt(i);
			int ascii = (int) data - key;				
			
			if (data >= 65 && data <= 90){
				if (ascii < 65)
					ascii = 90 + (ascii - 65 + 1);
				data = (char) ascii;
			} else if (data >= 97 && data <= 122){
				if (ascii < 97)
					ascii = 122 + (ascii - 97 + 1);
				data = (char) ascii;
			}
			
			decipherMessage = decipherMessage + data;
		}
		
		byte[] data = decipherMessage.getBytes();
		FileOutputStream out;
		try {
			out = new FileOutputStream("cs570/solution.txt");
			out.write(data);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}