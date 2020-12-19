package misc;

import java.util.Stack;

public class TowersOfHanoi {
    public static void main(String[] args) {
        Tower source = new Tower("source");
        Tower buffer = new Tower("buffer");
        Tower dest = new Tower("dest");

        int n = 10;
        for(int i = n; i > 0; i --)
            source.add(i);

        source.move(n, buffer, dest);
    }
}

class Tower {
    private Stack<Integer> tower;
    private String name;

    public Tower(String name) {
        this.name = name;
        tower = new Stack<>();
    }

    public void add(int val) {
        if(!tower.isEmpty() && tower.peek() < val)
            throw new RuntimeException("cant push a bigger value");

        tower.push(val);
    }

    public void move(int val, Tower via, Tower to) {
        if(val == 0)
            return;

        move(val - 1, to, via);
        System.out.println("Moving " + tower.peek() + " from " + name + " to " + to.name);
        to.add(tower.pop());
        via.move(val - 1, this, to);
    }
}