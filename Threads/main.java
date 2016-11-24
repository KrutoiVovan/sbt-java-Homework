package Threads;

import Threads.ThreadLocker;
import Threads.classWithLocker;

/**
 * Created by SBT-SAFONOV-VV on 24.11.2016.
 */
public class main {
    public static void main(String[] args) {
            ThreadLocker locker = new ThreadLocker();
            classWithLocker thread = new classWithLocker(locker);
            classWithLocker thread2 = new classWithLocker(locker);
            classWithLocker thread3 = new classWithLocker(locker);
            thread.start();
            thread2.start();
            thread3.start();
    }
}
