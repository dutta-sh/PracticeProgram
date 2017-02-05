import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BubbleSort {

	private static List<Integer> arr = Arrays.asList(50, 30, 100, 40, 80, 60, 90, 20, 10, 70);
	
	public static void main(String[] args) {
		sortNormal();
		print();
	}
	
	private static void sortNormal() {
		int temp;
		for(int i =0; i < arr.size(); i++) {
			for(int j = i+1; j < arr.size(); j++) {
				if(arr.get(i) > arr.get(j)) {
					temp = arr.get(j);
					arr.set(j, arr.get(i));
					arr.set(i, temp);
				}
			}
		}
	}
	
	private static void sortIterator() {
		Iterator<Integer> x = arr.iterator();
		while(x.hasNext()) {
			Iterator<Integer> y = arr.iterator();
		}
	}
	
	private static void print() {
		for(int i =0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
