package app.rsa.signature;

import java.math.BigInteger;

public class SignedMessage {
    private BigInteger message;
    private BigInteger signature;

    public SignedMessage(BigInteger message, BigInteger signature) {
        this.message = message;
        this.signature = signature;
    }

    public BigInteger getMessage() {
        return message;
    }

    public void setMessage(BigInteger message) {
        this.message = message;
    }

    public BigInteger getSignature() {
        return signature;
    }

    public void setSignature(BigInteger signature) {
        this.signature = signature;
    }
}
