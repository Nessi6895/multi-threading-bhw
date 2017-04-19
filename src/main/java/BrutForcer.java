import java.util.Scanner;

/**
 * Created by Артем on 24.03.2017.
 */
public class BrutForcer {
    private static final String HASH_ALGO = "SHA-256";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert any string");
        byte[] hash = new Hasher(HASH_ALGO).getHash(in.next());
        BrutForceThreadPool threadPool = new BrutForceThreadPool(8, hash, HASH_ALGO);
        threadPool.start();
    }
}
