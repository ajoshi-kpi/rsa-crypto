package app.rsa.keygenerators;

import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;
import app.util.PrimaryNumbersHolder;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class KeyGenerator {

    private final BigInteger P = PrimaryNumbersHolder.getNextBigPrimary();
    private final BigInteger Q = PrimaryNumbersHolder.getNextBigPrimary();
    private final BigInteger N;
    private final BigInteger E = BigInteger.valueOf(2L).pow(16).add(BigInteger.ONE);

    public KeyGenerator() {
        N = P.multiply(Q);
    }

    public PublicKey generatePublicKey() {
        return new PublicKey(N, E);
    }

    public PrivateKey generatePrivateKey() {
        return new PrivateKey(getD(), P, Q);
    }

    private BigInteger getD() {
        return E.modInverse(N);
    }
}
