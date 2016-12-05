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
        System.out.println(publicKey.getE().toString(16));
        System.out.println(publicKey.getN().toString(16));
        testKeysSendingProtocol();
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
        System.out.println(signedMessage.getSignature().toString(16));
        System.out.println(rsa.checkMessage(signedMessage, publicKey));
    }

    public static void testKeysSendingProtocol() {
        Rsa rsa = new Rsa();
        KeyGenerator aKeyGenerator = new KeyGenerator();
        PublicKey aPublicKey = aKeyGenerator.generatePublicKey();
        PrivateKey aPrivateKey = aKeyGenerator.generatePrivateKey();

        final BigInteger keyToSend = new BigInteger("123123");
        BigInteger k1 = rsa.encrypt(keyToSend, publicKey);
        BigInteger s = rsa.decrypt(keyToSend, aPrivateKey);
        BigInteger s1 = rsa.encrypt(s, publicKey);

        System.out.println(checkKey(k1, s1, privateKey, aPublicKey));
    }

    private static boolean checkKey(BigInteger k1, BigInteger s1, PrivateKey privateKey, PublicKey aPublicKey) {
        Rsa rsa = new Rsa();
        BigInteger k = rsa.decrypt(k1, privateKey);
        BigInteger s = rsa.decrypt(s1, privateKey);

        return k.equals(s.modPow(aPublicKey.getE(), aPublicKey.getN()));
    }
}
