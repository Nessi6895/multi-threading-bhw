import java.util.*;

public class BrutForceThreadPool {
    private final int nThreads;
    private final byte[] hash;
    private volatile boolean found = false;
    private final String hashAlgo;

    public BrutForceThreadPool(int nThreads, byte[] hash, String hashAlgo) {
        this.nThreads = nThreads;
        this.hash = hash;
        this.hashAlgo = hashAlgo;
    }

    public void start() {
        for (int i = 0; i < nThreads; i++) {
            BrutForceThread thread = new BrutForceThread(i);
            thread.start();
        }
    }


    private class BrutForceThread extends Thread {
        private final int number;
        private final static int MAX_NUM = 1000000000;

        public BrutForceThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (Long i = (long) (number * MAX_NUM / nThreads); i < (number + 1) * MAX_NUM / nThreads; i++) {
                if (found) break;
                if (Arrays.equals(new Hasher(hashAlgo).getHash(i.toString()), hash)) {
                    found = true;
                    System.out.println("Number " + i + " has needed hashcode: " + Arrays.toString(hash));
                    break;
                }
            }
        }
    }
}