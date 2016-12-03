package app.rsa.consumers;

import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class Consumer {

    private final PublicKey publicKey;
    private PrivateKey privateKey;

    public Consumer(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public boolean receiveMessage(BigInteger message, BigInteger signature) {
        return verifyMessageSignature(message, signature);
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    private boolean verifyMessageSignature(BigInteger message, BigInteger signature) {
        System.out.println(signature.modPow(publicKey.getE(), publicKey.getN()));
        return signature.modPow(publicKey.getE(), publicKey.getN()).equals(message);
    }
}
