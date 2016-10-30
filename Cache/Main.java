package Cache;

/**
 * Created by Makise on 30.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        SimpleHandler<CalculatorInterface> cachedCalc = new SimpleHandler<>();
        CalculatorInterface calc = new Calculator();
        calc = cachedCalc.cache(calc);
        System.out.println(calc.doHardWork(10, 20));
        System.out.println(calc.doHardWork(10, 30));
        System.out.println(calc.doHardWork(10, 20));
    }
}
