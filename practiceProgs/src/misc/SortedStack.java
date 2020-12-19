package misc;

import java.util.Stack;

public class SortedStack {

    private static Stack<Integer> orig = new Stack<>();

    public static void main(String[] args) {
        orig.push(5);
        orig.push(10);
        orig.push(7);
        
        System.out.println(sort());
    }

    public static Stack<Integer> sort() {
        Stack<Integer> buffer = new Stack<>();
        while(!orig.isEmpty()) {
            int temp = orig.pop();
            while(!buffer.isEmpty() && buffer.peek() > temp) {
                orig.push(buffer.pop());
            }
            buffer.push(temp);
        }

        return buffer;
    }
}
