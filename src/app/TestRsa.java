package app;

import app.rsa.keygenerators.KeyGenerator;
import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;
import app.rsa.rsacryptoutil.Rsa;
import app.rsa.signature.SignedMessage;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class TestRsa {
    private static KeyGenerator keyGenerator = new KeyGenerator();
    private static PublicKey publicKey = keyGenerator.generatePublicKey();
    private static PrivateKey privateKey = keyGenerator.generatePrivateKey();
    public static void main(String[] args) {
        testRsaSignature();
    }

    public static void testEncryption() {
        Rsa rsa = new Rsa();

        BigInteger plainText = new BigInteger("123123", 16);
        BigInteger cipherText = rsa.encrypt(plainText, publicKey);

        BigInteger decrypt = rsa.decrypt(cipherText, privateKey);
        System.out.println(decrypt.equals(plainText));
    }

    public static void testRsaSignature() {
        Rsa rsa = new Rsa();
        BigInteger plainText = new BigInteger("123123", 16);
        SignedMessage signedMessage = rsa.getSignedMessage(plainText, privateKey);
        System.out.println(rsa.checkMessage(signedMessage, publicKey));
    }
}
