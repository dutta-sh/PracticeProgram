package cs570;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracProg2 {

	public static void main(String[] args) throws IOException {
		String path = "cs570/input.txt";
		//String path = "C:\\work\\workspace_CS570\\PracticeProgram\\src\\input.txt";
		byte[] byteArr = Files.readAllBytes(Paths.get(path));
		String contents = new String(byteArr);
		
		String[] arr = contents.split(" ");
		Map<String, List<String>> countMap = new HashMap<>();
		countMap.put("ONE", new ArrayList<String>());
		countMap.put("TWO", new ArrayList<String>());
		countMap.put("THREE", new ArrayList<String>());
		
		for(String word : arr) {
			countMap = countWord(word, countMap);
		}
		outputTable(countMap);
	}
	
	public static Map<String, List<String>> countWord(String word, Map<String, List<String>> countMap) {
		List<String> wordList;
		if(word.length() == 1)
			wordList = countMap.get("ONE");
		else if(word.length() == 2)
			wordList = countMap.get("TWO");
		else
			wordList = countMap.get("THREE");
		
		wordList.add(word);
		
		return countMap;
	}
	
	public static void outputTable(Map<String, List<String>> countMap) {
		List<String> oneLetterWord = countMap.get("ONE");
		List<String> twoLetterWord = countMap.get("TWO");
		List<String> threeLetterWord = countMap.get("THREE");
		
		//System.out.println("One letter words: " + oneLetterWord.size() + " Contents: " + oneLetterWord);
		//System.out.println("Two letter words: " + twoLetterWord.size() + " Contents: " + twoLetterWord);
		//System.out.println("Three letter words: " + threeLetterWord.size() + " Contents: " + threeLetterWord);
		
		//PrintWriter writer = new PrintWriter("output.txt");
		String str= ("One letter words: " + oneLetterWord.size() + " Contents: " + oneLetterWord 	
				+ "\n Two letter words: " + twoLetterWord.size() + " Contents: " + twoLetterWord 
				+ "\n Three letter words: " + threeLetterWord.size() + " Contents: " + threeLetterWord);
		//writer.println("One letter words: " + oneLetterWord.size() + " Contents: " + oneLetterWord 	
		//		+ "\n Two letter words: " + twoLetterWord.size() + " Contents: " + twoLetterWord 
		//		+ "\n Three letter words: " + threeLetterWord.size() + " Contents: " + threeLetterWord);
		byte[] data= str.getBytes();
		FileOutputStream out;
		try {
			out = new FileOutputStream("cs570/output.txt");
			out.write(data);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("I did it");
		
		//writer.close();
	}
	
	
}