package app.rsa.rsacryptoutil;

import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;
import app.rsa.signature.SignedMessage;

import java.math.BigInteger;

public class Rsa {

    public BigInteger encrypt(BigInteger message, PublicKey publicKey) {
        return message.modPow(publicKey.getE(), publicKey.getN());
    }

    public BigInteger decrypt(BigInteger cipherText, PrivateKey privateKey) {
        return cipherText.modPow(privateKey.getD(), privateKey.getP().multiply(privateKey.getQ()));
    }

    public SignedMessage getSignedMessage(BigInteger message, PrivateKey privateKey) {
        BigInteger signature = message.modPow(privateKey.getD(), privateKey.getP().multiply(privateKey.getQ()));
        return new SignedMessage(message, signature);
    }

    public boolean checkMessage(SignedMessage signedMessage, PublicKey publicKey) {
        return signedMessage.getSignature().modPow(publicKey.getE(), publicKey.getN()).equals(signedMessage.getMessage());
    }
}
