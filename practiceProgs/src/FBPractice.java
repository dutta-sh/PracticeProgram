import java.util.*;

public class FBPractice {

    public static void main(String[] args) {
        FBPractice fbPractice = new FBPractice();
        SubArray[] arr = fbPractice.getSubArray(new int[]{3, 4, 2});
        System.out.println(Arrays.toString(arr));
    }

    public SubArray[] getSubArray(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for(int a : arr) {
            sum += a;
        }

        List<SubArray> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int runningSum = 0;
            for(int j = i; j < len; j++) {
                runningSum += arr[j];
                double runningAvg = ((double)runningSum)/((double)j-i+1);
                double remAvg = len - (j-i+1) == 0 ? 0 : ((double)(sum - runningSum))/(double)(len - (j-i+1));
                if(runningAvg > remAvg)
                    list.add(new SubArray(i+1, j+1));
            }
        }

        Collections.sort(list, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        return list.toArray(new SubArray[list.size()]);
    }
}

class SubArray {
    int start;
    int end;

    public SubArray(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "SubArray{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
