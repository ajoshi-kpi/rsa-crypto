package app.rsa.keys;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class PublicKey {
    private BigInteger n;
    private BigInteger e;

    public PublicKey(BigInteger n, BigInteger e) {
        this.n = n;
        this.e = e;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    @Override
    public String toString() {
        return "PublicKey{" +
                "n=" + n +
                ", e=" + e +
                '}';
    }
}
