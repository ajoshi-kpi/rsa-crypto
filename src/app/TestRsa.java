package app;

import app.rsa.consumers.Consumer;
import app.rsa.keygenerators.KeyGenerator;
import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;
import app.rsa.subscribers.Subscriber;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class TestRsa {
    public static void main(String[] args) {
        KeyGenerator keyGenerator = new KeyGenerator();
        PrivateKey privateKey = keyGenerator.generatePrivateKey();
        PublicKey publicKey = keyGenerator.generatePublicKey();

        Consumer consumer = new Consumer(publicKey);
        consumer.setPrivateKey(privateKey);
        Subscriber subscriber = new Subscriber(privateKey, consumer);

        System.out.println(subscriber.sendMessageToConsumer(BigInteger.valueOf(166L)));
    }
}
