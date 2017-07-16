package sorting;

/**
 * Created by Shouvik on 7/13/2017.
 */
public class SortOrderN {

    public static void main(String[] args) {
        int[] dataArr = new int[]{10, 2, 5, 7, 3, 9, 4, 1, 2, 0, 6, 80, 100};

        int[] dataRef = new int[100 + 1];

        for(int i = 0; i < dataArr.length; i++) {
            dataRef[dataArr[i]]++;
        }

        for(int i = 0; i < dataRef.length; i++) {
            for(int j = 1; j <= dataRef[i]; j++) {
                System.out.print(i + ", ");
            }
        }
    }
}
