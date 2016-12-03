package app.rsa.keys;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class PublicKey {
    private BigInteger n;
    private BigInteger e;

    public PublicKey(BigInteger n, BigInteger q) {
        this.n = n;
        this.e = q;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }
}
