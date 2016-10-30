package Cache;

/**
 * Created by Makise on 30.10.2016.
 */
public class Calculator implements CalculatorInterface {

    public int doHardWork(int a, int b) {
        Sleep(1000);
        return a + b;
    }

    private void Sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            return;}
    }

}
