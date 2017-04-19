import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Артем on 12.04.2017.
 */
public class Hasher {
    private final MessageDigest md;

    public Hasher(String hashType) {
        MessageDigest md;
        try{
            md = MessageDigest.getInstance(hashType);
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("No such hash algorithm");
        }
        this.md = md;
    }

    public byte[] getHash(String hash){
        return getHash(hash.getBytes());
    }

    public byte[] getHash(byte[] hash){
        md.update(hash);
        return md.digest();
    }
}
