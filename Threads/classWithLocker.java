package Threads;

/**
 * Created by SBT-SAFONOV-VV on 24.11.2016.
 */
public class classWithLocker extends Thread {
    private ThreadLocker locker;

    public classWithLocker(ThreadLocker locker){
        this.locker = locker;
    }

    @Override
    public void run() {
        super.run();
        locker.lock();
        System.out.println("ABC");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        locker.unlock();
    }

}
