package app.rsa.rsacryptoutil;

import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;

import java.math.BigInteger;

public class Rsa {

    public BigInteger encrypt(BigInteger message, PublicKey publicKey) {
        return message.modPow(publicKey.getE(), publicKey.getN());
    }

    public BigInteger decrypt(BigInteger cipherText, PrivateKey privateKey) {
        return cipherText.modPow(privateKey.getD(), privateKey.getP().multiply(privateKey.getQ()));
    }
}
