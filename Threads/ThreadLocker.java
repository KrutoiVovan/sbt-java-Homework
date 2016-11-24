package Threads;

/**
 * Created by SBT-SAFONOV-VV on 24.11.2016.
 */
public class ThreadLocker {

    private static boolean isLocked = false;

    public void lock(){

        synchronized (this) {
            while (isLocked == true)
                try {
                    wait();
                } catch (InterruptedException e) {
                }
        }
        isLocked = true;

    }
    public void unlock() {
        synchronized (this) {
            isLocked = false;
            notify();
        }
    }

}
