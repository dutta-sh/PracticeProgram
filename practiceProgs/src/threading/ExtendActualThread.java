package threading;

public class ExtendActualThread extends Thread {

    private Execute ex = new Execute();

    public void run(){
        try {
            ex.doSomething();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
