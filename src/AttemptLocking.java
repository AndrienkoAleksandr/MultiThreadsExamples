import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by USER on 11.08.2014.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2. TimeUnit SECONDS):" +captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- 6/ioKnpoBKa AOCTyriHa
        al.timed(); // True -- 6/iOKnpoBKa flOCTyriHa
// Tenepb C03flaeM oTflenbHyio 3aflany ana ycTaHOBneHmi 6/iokhpobkm
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
                Thread.yield(); // flaeM B03M0>«H0CTb 2-Pi 3ana4e
        al.untimed();// False -- 6/iOKnpOBKa 3axBaneHa 3afla4eii
        al.timed(); // False -- 6/i0KMp0BKa 3axBaneHa zanaveiA
    }
}