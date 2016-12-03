package app.rsa.subscribers;

import app.rsa.consumers.Consumer;
import app.rsa.keys.PrivateKey;
import app.rsa.keys.PublicKey;

import java.math.BigInteger;

/**
 * Created by ajoshi on 03-Dec-16.
 */
public class Subscriber {

    private final Consumer consumer;
    private final PrivateKey privateKey;
    private PublicKey publicKey;

    public Subscriber(PrivateKey privateKey, Consumer consumer) {
        this.privateKey = privateKey;
        this.consumer = consumer;
    }

    public boolean sendMessageToConsumer(BigInteger message) {
        BigInteger signature = message.modPow(privateKey.getD(), privateKey.getP().multiply(privateKey.getQ()));
        System.out.println(signature);
        return consumer.receiveMessage(message, signature);
    }
}
