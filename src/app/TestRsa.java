package app;

import app.rsa.keygenerators.KeyGenerator;
import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;
import app.rsa.rsacryptoutil.Rsa;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class TestRsa {
    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        PublicKey publicKey = keyGenerator.generatePublicKey();
        PrivateKey privateKey = keyGenerator.generatePrivateKey();

        BigInteger plainText = new BigInteger("123123", 16);
        Rsa rsa = new Rsa();
        BigInteger cipherText = rsa.encrypt(plainText, publicKey);

        BigInteger decrypt = rsa.decrypt(cipherText, privateKey);
        System.out.println(decrypt.toString(16));
    }
}
