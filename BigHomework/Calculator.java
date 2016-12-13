package BigHomework;

/**
 * Created by Makise on 30.10.2016.
 */
public class Calculator implements CalculatorInterface {
    @Cached(CacheOnDisk = true, cachedArgument = 1,
            maxOutput = 100, key = "file", addToZip = false)
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
