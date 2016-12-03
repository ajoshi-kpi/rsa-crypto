package app.rsa.keys;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class PrivateKey {
    private BigInteger d;
    private BigInteger p;
    private BigInteger q;

    public PrivateKey(BigInteger d, BigInteger p, BigInteger q) {
        this.d = d;
        this.p = p;
        this.q = q;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }
}
