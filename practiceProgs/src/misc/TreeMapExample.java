package misc;

import java.util.*;

public class TreeMapExample {

    public boolean isOverLap(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start() - b.start());
        for(int i = 0; i < intervals.size() - 1; i++) {
            if(intervals.get(i).end() > intervals.get(i+1).start())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(0, 10), new Interval(10, 20), new Interval(15, 18));
        TreeMapExample example = new TreeMapExample();
        System.out.println(example.isOverLap(intervals));
    }
}


record Interval(int start, int end) { }
